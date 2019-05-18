package com.qlsv.ptit.tinhdiemptit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.DiemSos;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_MaMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;
import com.qlsv.ptit.tinhdiemptit.service.CauHinhDiemService;
import com.qlsv.ptit.tinhdiemptit.service.MonHocService;
import com.qlsv.ptit.tinhdiemptit.service.SinhVienService;
import com.qlsv.ptit.tinhdiemptit.service.TinhDiemService;

@Controller
@RequestMapping("/monhoc")
//@EnableWebMvc
public class MonHocController {

	@Autowired
	private MonHocService monHocService;

	@Autowired
	private SinhVienService sinhVienService;

	@Autowired
	private CauHinhDiemService cauHinhDiemService;

	@Autowired
	private TinhDiemService tinhDiemService;

	@GetMapping(value= {"", "/{maMonHoc}", "/{maMonHoc}/{nhomMonHoc}"})
	public String getListMonHocTheoNhom(Model model, 
			@PathVariable(required = false) String maMonHoc,
			@PathVariable(required = false) Integer nhomMonHoc) {
		List<MonHoc_MaMonHoc> listMonHoc = monHocService.findMonHocDropDown();
		model.addAttribute("listMonHoc", listMonHoc);
		if (maMonHoc != null) {
			List<Integer> listNhomMonHoc = monHocService.findNhomMonHocDropDown(maMonHoc);
			List<MonHocs> listMonHocs = monHocService.findById(maMonHoc, nhomMonHoc);
			String cauHinhDiem = cauHinhDiemService.findById(maMonHoc);
			model.addAttribute("cauHinhDiem", cauHinhDiem);
			model.addAttribute("selectedId", maMonHoc);
			model.addAttribute("listNhomMonHoc", listNhomMonHoc);
			model.addAttribute("listMonHocs", listMonHocs);
			if (nhomMonHoc != null) {
				model.addAttribute("selectedNhom", nhomMonHoc);
			}
		}
		return "/monhoc/danhsachmonhoc";
	}

	@GetMapping("/{maMonHoc}/{nhomMonHoc}/dssv")
	public String getListSinhVienTheoNhom(Model model,
			@PathVariable String maMonHoc,
			@PathVariable Integer nhomMonHoc,
			@RequestParam(name = "tenMH") String tenMH,
			@RequestParam(name = "giangVien") String giangVien) {
		List<SinhVien_Diem> listSinhVienDiem = sinhVienService.findByNhomMonHoc(maMonHoc, nhomMonHoc);
		String cauHinhDiem = cauHinhDiemService.findById(maMonHoc);
		if(!cauHinhDiem.isEmpty()) {
			tinhDiemService.formatCauHinh(cauHinhDiem);	
			tinhDiemService.setDiemSinhVien(listSinhVienDiem, nhomMonHoc, maMonHoc);
		}	
		DiemSos lst = new DiemSos(sinhVienService.findByNhomMonHoc(maMonHoc, nhomMonHoc));
		model.addAttribute("lst", lst);
		model.addAttribute("nhomMH", nhomMonHoc);
		model.addAttribute("giangVien", giangVien);
		model.addAttribute("tenMH", tenMH);
		model.addAttribute("maMonHoc", maMonHoc);
		model.addAttribute("cauHinhDiem", cauHinhDiem);
		return "/sinhvien/danhsachsinhvien";
	}

	@PostMapping("/{maMonHoc}/{nhomMonHoc}/dssv/saveDiemSo")
	public String saveDiemSinhVien(Model model, 
			RedirectAttributes ra, 
			@ModelAttribute("lst") DiemSos lst,
			@PathVariable Integer nhomMonHoc, 
			@PathVariable String maMonHoc,
			@RequestParam("tenMH") String tenMH, 
			@RequestParam("giangVien") String giangVien) {
		String cauHinhDiem = cauHinhDiemService.findById(maMonHoc);
		List<SinhVien_Diem> listSinhVienDiem = lst.getListSinhVienDiem();
		if(!cauHinhDiem.isEmpty()) {
			tinhDiemService.formatCauHinh(cauHinhDiem);
		}
		tinhDiemService.setDiemSinhVien(listSinhVienDiem, nhomMonHoc, maMonHoc);
		// Redirect đẩy dữ liệu sang
		ra.addAttribute("giangVien", giangVien);
		ra.addAttribute("tenMH", tenMH);
		return "redirect:/monhoc/" +maMonHoc+ "/" +nhomMonHoc+ "/dssv";
	}
}

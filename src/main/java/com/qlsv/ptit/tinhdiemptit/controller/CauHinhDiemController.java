package com.qlsv.ptit.tinhdiemptit.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qlsv.ptit.tinhdiemptit.entity.CheckValue;
import com.qlsv.ptit.tinhdiemptit.resultobject.CauHinhDiems;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;
import com.qlsv.ptit.tinhdiemptit.service.CauHinhDiemService;

@Controller
@RequestMapping("/cauhinh")
public class CauHinhDiemController {

	@Autowired
	private CauHinhDiemService cauHinhDiemService;

	@GetMapping("") 
	public String getListCauHinh(Model model) {
		List<MonHoc_CauHinhDiem> listCauHinhDiem = cauHinhDiemService.findAll();
		// Đưa model CauHinhDiems chứa List<MonHoc_CauHinhDiem>
		CauHinhDiems lst = new CauHinhDiems(listCauHinhDiem);
		model.addAttribute("lst", lst);
		return "/cauhinh/cauhinhdiem";
	}

	@PostMapping("/saveCauHinh")
	public String saveCauHinh(@ModelAttribute("lst") CauHinhDiems lst, @RequestParam("countIndex") int index,
			RedirectAttributes ra) {
		String check = CheckValue.OK.getValue();
		
		String cauHinhDiem = lst.getListCauHinhDiem().get(index).getCauHinhDiem();
		if (cauHinhDiemService.checkPattern(cauHinhDiem)) {
			if (cauHinhDiemService.checkCauHinh(cauHinhDiem)) {
				cauHinhDiemService.updateCauHinhDiem(lst.getListCauHinhDiem().get(index).getMaCauHinh(), cauHinhDiem);
			}
			else check = CheckValue.NOT_OK.getValue();
		}
		else {
			check = CheckValue.NOT_OK.getValue();
		}
		System.out.println("check??" +check);
		ra.addFlashAttribute("status", check);
		return "redirect:/cauhinh";
	}
}

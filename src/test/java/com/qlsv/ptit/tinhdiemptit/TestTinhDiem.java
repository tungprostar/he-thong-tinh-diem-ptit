package com.qlsv.ptit.tinhdiemptit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;
import com.qlsv.ptit.tinhdiemptit.service.CauHinhDiemService;
import com.qlsv.ptit.tinhdiemptit.service.SinhVienService;
import com.qlsv.ptit.tinhdiemptit.service.TinhDiemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestTinhDiem {

	@Autowired
	private TinhDiemService tinhDiemService;

	@Autowired
	private SinhVienService sinhVienService;

	@Autowired
	private CauHinhDiemService cauHinhDiemService;
	
	@Autowired
	private TinhDiemService tinhDiemService2;

	@Test
	public void testFormatCauHinhDiem() {
		int[] arr = new int[] { 10, 20, 20, 50 };
		assertArrayEquals(arr, tinhDiemService.formatCauHinh("10/20/20/50"));
	}

	@Test
	public void testTinhDiemSinhVien1() {
		List<SinhVien_Diem> lstSinhVienDiemBefore = sinhVienService.findByNhomMonHoc("INT1416", 1);
		// Set diem thi cho sinh vien co MSV1
		lstSinhVienDiemBefore.get(0).setDiemThi((float) 9);
		tinhDiemService.formatCauHinh(cauHinhDiemService.findById("INT1416"));
		tinhDiemService.setDiemSinhVien(lstSinhVienDiemBefore, 1, "INT1416");

		// Diem MSV1: 10 - CC, 8 - GK, 9 - BTL, 9 - Thi
		List<SinhVien_Diem> lstSinhVienDiemAfter = sinhVienService.findByNhomMonHoc("INT1416", 1);
		Float diemTB = lstSinhVienDiemAfter.get(0).getDiemTB();
		assertTrue(diemTB == 8.9f);
	}

	@Test
	public void testTinhDiemSinhVien2() {
		List<SinhVien_Diem> lstSinhVienDiemBefore = sinhVienService.findByNhomMonHoc("INT1408", 4);
		lstSinhVienDiemBefore.get(0).setDiemCC(10);
		lstSinhVienDiemBefore.get(0).setDiemGK(4f);
		lstSinhVienDiemBefore.get(0).setDiemBTL(7.5f);
		lstSinhVienDiemBefore.get(0).setDiemThi(9f);
		String cauHinhDiem = "10/20/10/60";
		if (cauHinhDiemService.checkPattern(cauHinhDiem)) {
			if (cauHinhDiemService.checkCauHinh(cauHinhDiem)) {
				cauHinhDiemService.updateCauHinhDiem(2, cauHinhDiem);
				tinhDiemService.formatCauHinh(cauHinhDiem);
				tinhDiemService.setDiemSinhVien(lstSinhVienDiemBefore, 4, "INT1408");
			}
		}
		List<SinhVien_Diem> lstSinhVienDiemAfter = sinhVienService.findByNhomMonHoc("INT1408", 4);
		float diemTB = lstSinhVienDiemAfter.get(0).getDiemTB();
		assertTrue(diemTB == 8.3f);
	}
	
	@Test
	public void testTinhDiemSinhVien3() {
		List<SinhVien_Diem> lstSinhVienDiemBefore = sinhVienService.findByNhomMonHoc("INT1408", 4);
		lstSinhVienDiemBefore.get(0).setDiemCC(10);
		lstSinhVienDiemBefore.get(0).setDiemGK(4f);
		lstSinhVienDiemBefore.get(0).setDiemBTL(7.5f);
		lstSinhVienDiemBefore.get(0).setDiemThi(9f);

		// Môn không có cấu hình điểm
		tinhDiemService2.setDiemSinhVien(lstSinhVienDiemBefore, 4, "INT1408");

		List<SinhVien_Diem> lstSinhVienDiemAfter = sinhVienService.findByNhomMonHoc("INT1408", 4);
		Float diemTB = lstSinhVienDiemAfter.get(0).getDiemTB();
		assertNull(diemTB);
	}
	
	@Test
	public void testTinhDiemSinhVien4() {
		List<SinhVien_Diem> lstSinhVienDiemBefore = sinhVienService.findByNhomMonHoc("INT1416", 1);
		// Set diem thi cho sinh vien co MSV1
		lstSinhVienDiemBefore.get(0).setDiemThi((float) 9);
		lstSinhVienDiemBefore.get(0).setDiemCC(0);
		tinhDiemService.formatCauHinh(cauHinhDiemService.findById("INT1416"));
		tinhDiemService.setDiemSinhVien(lstSinhVienDiemBefore, 1, "INT1416");
		
		List<SinhVien_Diem> lstSinhVienDiemAfter = sinhVienService.findByNhomMonHoc("INT1416", 1);
		Float diemTB = lstSinhVienDiemAfter.get(0).getDiemTB();
		assertNull(diemTB);
	}

	@Test
	public void testTinhDiemSinhVien5() {
		List<SinhVien_Diem> lstSinhVienDiemBefore = sinhVienService.findByNhomMonHoc("INT1416", 1);
		// Set diem thi cho sinh vien co MSV1
		lstSinhVienDiemBefore.get(0).setDiemThi((float) 9);
		lstSinhVienDiemBefore.get(0).setDiemCC(2);
		lstSinhVienDiemBefore.get(0).setDiemGK(9f);
		lstSinhVienDiemBefore.get(0).setDiemBTL(null);
		tinhDiemService.formatCauHinh(cauHinhDiemService.findById("INT1416"));
		tinhDiemService.setDiemSinhVien(lstSinhVienDiemBefore, 1, "INT1416");
		
		List<SinhVien_Diem> lstSinhVienDiemAfter = sinhVienService.findByNhomMonHoc("INT1416", 1);
		Float diemTB = lstSinhVienDiemAfter.get(0).getDiemTB();
		assertNull(diemTB);
	}
}

package com.qlsv.ptit.tinhdiemptit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;
import com.qlsv.ptit.tinhdiemptit.service.SinhVienService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSinhVien {

	@Autowired
	private SinhVienService sinhVienService;
	
	@Test
	public void testTimDanhSachSinhVienTheoMonHoc() {
		List<SinhVien_Diem> listSinhVienDiem = sinhVienService.findByNhomMonHoc("INT1408", 2);
		assertEquals(3, listSinhVienDiem.size());
	}
	
	@Test
	public void testKhongTimThayDanhSachSinhVien() {
		List<SinhVien_Diem> listSinhVienDiem = sinhVienService.findByNhomMonHoc("INT1408", 5);
		assertEquals(0, listSinhVienDiem.size());
	}
}

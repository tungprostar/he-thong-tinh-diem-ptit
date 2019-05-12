package com.qlsv.ptit.tinhdiemptit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;
import com.qlsv.ptit.tinhdiemptit.service.CauHinhDiemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestCauHinh {
	
	@Autowired
	private CauHinhDiemService cauHinhService;

	@Test
	public void testPatternDung() {
		String cauHinh = "10/20/30/40";
		assertTrue(cauHinhService.checkPattern(cauHinh));
	}
	
	@Test
	public void testPatternSai() {
		String cauHinh = "102/123/4";
		assertFalse(cauHinhService.checkPattern(cauHinh));
	}
	
	@Test
	public void testDiem100() {
		String cauHinhDiem = "10/20/20/50";
		if(cauHinhService.checkPattern(cauHinhDiem)) {
			assertTrue(cauHinhService.checkCauHinh(cauHinhDiem));	
		}
	}
	
	@Test
	public void testDiemKhac100() {
		String cauHinhDiem = "10/30/30/50";
		if(cauHinhService.checkPattern(cauHinhDiem)) {
			assertFalse(cauHinhService.checkCauHinh(cauHinhDiem));	
		}
	}
	
	@Test
	public void testTimKiemTatCaCauHinh() {
		List<MonHoc_CauHinhDiem> lst = cauHinhService.findAll();
		assertEquals(3, lst.size());
	}
	
	@Test
	public void testTimCauHinhDiemTheoMonHoc() {
		assertEquals("", cauHinhService.findById("INT1427"));
	}
	
	@Test
	public void testKhongTimThayCauHinh() {
		String cauHinh = cauHinhService.findById("INT");
		assertEquals("", cauHinh);
	}
	
	@Test
	public void testCapNhatCauHinhDiem() {
		String cauHinh = "10/20/30/40";
		if(cauHinhService.checkCauHinh(cauHinh)) {
			cauHinhService.updateCauHinhDiem(2, cauHinh);
			assertThat(cauHinhService.findById("INT1427")).matches(cauHinh);
		}	
	}

}

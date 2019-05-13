package com.qlsv.ptit.tinhdiemptit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qlsv.ptit.tinhdiemptit.dao.MonHocDAO;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_MaMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;
import com.qlsv.ptit.tinhdiemptit.service.MonHocService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMonHoc {
	
	@Autowired
	private MonHocService monHocService;
	
	private MonHocDAO monHocDAO;

	// Chi test duoc khi khong co dang nhap
	@Test
	public void testTongSoMonHoc() {
		List<MonHoc_MaMonHoc> lstMonHoc = monHocService.findMonHocDropDown();
		assertEquals(3, lstMonHoc.size());
	}

	@Test
	public void testTongNhomMonHocTheoMaMonHoc() {
		List<Integer> lstNhomMH = monHocService.findNhomMonHocDropDown("INT1416");
		assertEquals(5, lstNhomMH.size());
	}
	
	@Test
	public void testTimMonHocTheoIdVaMaMonHoc1() {
		List<MonHocs> lstMonHocs = monHocService.findById("INT1416", 1);
		assertEquals(1, lstMonHocs.size());
		assertEquals("Đảm bảo chất lượng phần mềm", lstMonHocs.get(0).getTenMonHoc());
	}
	
	@Test
	public void testTimMonHocTheoIdVaMaMonHoc2() {
		// không có nhóm môn học
		List<MonHocs> lstMonHocs = monHocService.findById("INT1416", null);
		assertEquals(5, lstMonHocs.size());
	}
	
	@Test
	public void testTimMonHocTheoIdVaMaMonHoc3() {
		// không có nhóm môn học và môn học
		List<MonHocs> lstMonHocs = monHocService.findById(null, null);
		assertEquals(0, lstMonHocs.size());
	}
}

package com.qlsv.ptit.tinhdiemptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_NhomMH;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;

public interface MonHocDAO {

	public List<MonHocs> findById(String maMH, Integer nhomMH);
	public List<MonHoc> findMonHocDropDown();
	public List<NhomMonHoc> findNhomMonHocDropDown(String maMH);
}

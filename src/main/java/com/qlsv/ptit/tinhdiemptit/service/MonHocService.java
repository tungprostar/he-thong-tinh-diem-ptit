package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;

public interface MonHocService {
	public List<MonHocs> findById(String maMH, Integer nhomMH);
	public List<MonHoc> findMonHocDropDown();
	public List<NhomMonHoc> findNhomMonHocDropDown(String maMH);
}

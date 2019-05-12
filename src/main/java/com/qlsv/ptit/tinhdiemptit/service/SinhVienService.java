package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

public interface SinhVienService {
	public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH);
}

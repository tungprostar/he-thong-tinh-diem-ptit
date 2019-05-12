package com.qlsv.ptit.tinhdiemptit.dao;

import java.util.List;

import com.qlsv.ptit.tinhdiemptit.entity.SinhVien;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

public interface SinhVienDAO {

	public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH);
}

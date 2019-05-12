package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import com.qlsv.ptit.tinhdiemptit.entity.DiemSo;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

public interface TinhDiemService {
	public void setDiemSinhVien(List<SinhVien_Diem> lstSinhVienDiem, Integer nhomMH, String maMH);
//	public Float tinhDiemSinhVien(DiemSo ds);
	public int[] formatCauHinh(String cauHinhDiem);
}

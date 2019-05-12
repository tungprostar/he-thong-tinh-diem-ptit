package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;

public interface CauHinhDiemService {
	public List<MonHoc_CauHinhDiem> findAll();
	public void updateCauHinhDiem(int maCauHinh, String cauHinhDiem);
	public String findById(String maMH);
	public boolean checkCauHinh(String cauHinhDiem);
	public boolean checkPattern(String cauHinhDiem);
}

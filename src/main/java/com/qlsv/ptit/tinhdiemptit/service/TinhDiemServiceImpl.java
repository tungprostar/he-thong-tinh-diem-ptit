package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.dao.TinhDiemDAO;
import com.qlsv.ptit.tinhdiemptit.entity.DiemSo;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

@Service
@Scope("prototype")
public class TinhDiemServiceImpl implements TinhDiemService {

	@Autowired
	private TinhDiemDAO tinhDiemDAO;
	
	@Override
	@Transactional
	public void setDiemSinhVien(List<SinhVien_Diem> lstSinhVienDiem, Integer nhomMH, String maMH) {
		tinhDiemDAO.setDiemSinhVien(lstSinhVienDiem, nhomMH, maMH);
	}

//	@Override
//	public Float tinhDiemSinhVien(DiemSo ds) {
//		return tinhDiemDAO.tinhDiemSinhVien(ds);
//	}

	@Override
	public int[] formatCauHinh(String cauHinhDiem) {
		return tinhDiemDAO.formatCauHinh(cauHinhDiem);
	}

}

package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.dao.CauHinhDiemDAO;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;

@Service
public class CauHinhDiemServiceImpl implements CauHinhDiemService {

	@Autowired
	private CauHinhDiemDAO cauHinhDiemDAO;
	
	@Override
	@Transactional
	public List<MonHoc_CauHinhDiem> findAll() {
		return cauHinhDiemDAO.findAll();
	}

	@Override
	@Transactional
	public void updateCauHinhDiem(int maCauHinh, String cauHinhDiem) {
		cauHinhDiemDAO.updateCauHinhDiem(maCauHinh, cauHinhDiem);
	}

	@Override
	@Transactional
	public String findById(String maMH) {
		return cauHinhDiemDAO.findById(maMH);
	}

	@Override
	public boolean checkCauHinh(String cauHinhDiem) {
		return cauHinhDiemDAO.checkCauHinh(cauHinhDiem);
	}

	@Override
	public boolean checkPattern(String cauHinhDiem) {
		return cauHinhDiemDAO.checkPattern(cauHinhDiem);
	}

}

package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.dao.SinhVienDAO;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

@Service
public class SinhVienServiceImpl implements SinhVienService {

	@Autowired
	private SinhVienDAO sinhVienDAO;
	
	@Override
	@Transactional
	public List<SinhVien_Diem> findByNhomMonHoc(String maMH, Integer nhomMH) {
		return sinhVienDAO.findByNhomMonHoc(maMH, nhomMH);
	}

}

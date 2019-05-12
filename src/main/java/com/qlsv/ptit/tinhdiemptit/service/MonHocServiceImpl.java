package com.qlsv.ptit.tinhdiemptit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.dao.MonHocDAO;
import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;

@Service
public class MonHocServiceImpl implements MonHocService {

	@Autowired
	private MonHocDAO monHocDAO;
	
	@Override
	@Transactional
	public List<MonHocs> findById(String maMH, Integer nhomMH) {
		return monHocDAO.findById(maMH, nhomMH);
	}

	@Override
	@Transactional
	public List<MonHoc> findMonHocDropDown() {
		return monHocDAO.findMonHocDropDown();
	}

	@Override
	@Transactional
	public List<NhomMonHoc> findNhomMonHocDropDown(String maMH) {
		return monHocDAO.findNhomMonHocDropDown(maMH);
	}

}

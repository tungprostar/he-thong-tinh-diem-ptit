package com.qlsv.ptit.tinhdiemptit.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;

@Repository
public class MonHocDAOImpl implements MonHocDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MonHoc> findMonHocDropDown() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from MonHoc", MonHoc.class);
		List<MonHoc> lstMonHoc = query.getResultList();
		return lstMonHoc;
	}

	@Override
	public List<NhomMonHoc> findNhomMonHocDropDown(String maMH) {
		Session currentSession = entityManager.unwrap(Session.class);
		// Tìm kiếm môn học theo mã môn học
		Query query = currentSession.createQuery("from NhomMonHoc nmh"
				+ " where nmh.monHoc.maMonHoc = :maMH"
				+ " order by nmh.nhomMonHoc asc", NhomMonHoc.class);
		query.setParameter("maMH", maMH);
		List<NhomMonHoc> lstNhomMH = query.getResultList();
		return lstNhomMH;
	}

	@Override
	public List<MonHocs> findById(String maMH, Integer nhomMH) {
		Session currentSession = entityManager.unwrap(Session.class);
		// Tìm kiếm môn học theo mã môn học, nhóm mh
		String strQuery1 = "Select new com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs(nmh.monHoc.tenMonHoc, nmh.nhomMonHoc, gv.hoTen, nmh.monHoc.soTC) "
				+ " from NhomMonHoc nmh"
				+ " join nmh.giangViens gv"
				+ " where nmh.monHoc.maMonHoc = :maMH";
		if(nhomMH != null) {
			strQuery1 = strQuery1.concat(" and nmh.nhomMonHoc = :nhomMH");
		}
		Query query = currentSession.createQuery(strQuery1);
		query.setParameter("maMH", maMH);
		if(nhomMH != null) {
			query.setParameter("nhomMH", nhomMH);
		}
		List<MonHocs> lstMonHocs = query.getResultList();
		return lstMonHocs;
	}
}

package com.qlsv.ptit.tinhdiemptit.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.qlsv.ptit.tinhdiemptit.entity.MonHoc;
import com.qlsv.ptit.tinhdiemptit.entity.NhomMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_MaMonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs;

@Repository
public class MonHocDAOImpl implements MonHocDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MonHoc_MaMonHoc> findMonHocDropDown() {
		Session currentSession = entityManager.unwrap(Session.class);
		String strQuery = "select distinct new com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_MaMonHoc(nmh.monHoc.tenMonHoc, nmh.monHoc.maMonHoc)"
				+ " from NhomMonHoc nmh join nmh.giangViens gv where gv.user.userName like :userName";	
		String userName = getUserName();
		Query query = currentSession.createQuery(strQuery);
		if(!userName.equals("admin")) {
			query.setParameter("userName", "%" + userName + "%");
		}
		else query.setParameter("userName", "%%");
		List<MonHoc_MaMonHoc> lstMonHoc = query.getResultList();
		System.out.println(userName);
		return lstMonHoc;
	}

	@Override
	public List<Integer> findNhomMonHocDropDown(String maMH) {
		Session currentSession = entityManager.unwrap(Session.class);
		// Tìm kiếm môn học theo mã môn học
		Query query = currentSession.createQuery("select nmh.nhomMonHoc from NhomMonHoc nmh"
				+ " join nmh.giangViens gv where gv.user.userName like :userName"
				+ " and nmh.monHoc.maMonHoc = :maMH"
				+ " order by nmh.nhomMonHoc asc");
		String userName = getUserName();
		if(!userName.equals("admin")) {
			query.setParameter("userName", "%" + userName + "%");
		}
		else query.setParameter("userName", "%%");
		query.setParameter("maMH", maMH);
		List<Integer> lstNhomMH = query.getResultList();
		return lstNhomMH;
	}

	@Override
	public List<MonHocs> findById(String maMH, Integer nhomMH) {
		Session currentSession = entityManager.unwrap(Session.class);
		// Tìm kiếm môn học theo mã môn học, nhóm mh
		String strQuery1 = "Select new com.qlsv.ptit.tinhdiemptit.resultobject.MonHocs(nmh.monHoc.tenMonHoc, nmh.nhomMonHoc, gv.hoTen, nmh.monHoc.soTC)"
				+ " from NhomMonHoc nmh"
				+ " join nmh.giangViens gv"
				+ " where nmh.monHoc.maMonHoc = :maMH"
				+ " and gv.user.userName like :userName";
		if(nhomMH != null) {
			strQuery1 = strQuery1.concat(" and nmh.nhomMonHoc = :nhomMH");
		}
		Query query = currentSession.createQuery(strQuery1);
		query.setParameter("maMH", maMH);
		if(nhomMH != null) {
			query.setParameter("nhomMH", nhomMH);
		}
		String userName = getUserName();
		if(!userName.equals("admin")) {
			query.setParameter("userName", "%" + userName + "%");
		}
		else query.setParameter("userName", "%%");
		List<MonHocs> lstMonHocs = query.getResultList();
		return lstMonHocs;
	}
	
	public static String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = "";
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			try {
				currentUser = authentication.getName();	
			} catch (Exception e) {
				
			}		
		}
		return currentUser;
	}
}

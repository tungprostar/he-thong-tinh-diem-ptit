package com.qlsv.ptit.tinhdiemptit.dao;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem;

@Repository
public class CauHinhDiemDAOImpl implements CauHinhDiemDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MonHoc_CauHinhDiem> findAll() {
		List<MonHoc_CauHinhDiem> lstCauHinhDiems = null;
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("select new "
				+ "com.qlsv.ptit.tinhdiemptit.resultobject.MonHoc_CauHinhDiem(c.maCauHinh, m.tenMonHoc, m.soTC, c.cauHinh)"
				+ "from CauHinhDiem c join c.monHoc m");
		lstCauHinhDiems = query.list();
		return lstCauHinhDiems;
	}

	@Override
	public void updateCauHinhDiem(int maCauHinh, String cauHinhDiem) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("update CauHinhDiem c set c.cauHinh = :chd" + " where c.maCauHinh = :mach");
		query.setParameter("chd", cauHinhDiem);
		query.setParameter("mach", maCauHinh);
		query.executeUpdate();
	}

	@Override
	public String findById(String maMH) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session
				.createQuery("Select c.cauHinh" + " from CauHinhDiem c join c.monHoc m" + " where m.maMonHoc = :maMH");
		query.setParameter("maMH", maMH);
		String cauHinh = "";
		try {
			cauHinh = (String) query.getSingleResult();
		} catch (NoResultException e) {
		}
		return cauHinh;
	}

	@Override
	public boolean checkCauHinh(String cauHinhDiem) {
		String[] check1 = cauHinhDiem.split("/");
		int check2 = 0;
		for (String s : check1) {
			check2 += Integer.parseInt(s);
		}
		System.out.println(check2);
		return check2 == 100 ? true : false;
	}

	@Override
	public boolean checkPattern(String cauHinhDiem) {
		Pattern pattern = Pattern.compile("\\d{1,2}[/]\\d{1,2}[/]\\d{1,2}[/]\\d{1,2}");
		return pattern.matcher(cauHinhDiem).matches();
	}

}

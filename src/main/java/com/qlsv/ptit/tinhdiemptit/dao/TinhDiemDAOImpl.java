package com.qlsv.ptit.tinhdiemptit.dao;

import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.qlsv.ptit.tinhdiemptit.entity.DiemSo;
import com.qlsv.ptit.tinhdiemptit.entity.SinhVien_MonHoc;
import com.qlsv.ptit.tinhdiemptit.resultobject.SinhVien_Diem;

@Repository
@Scope("prototype")
public class TinhDiemDAOImpl implements TinhDiemDAO {

	@Autowired
	private EntityManager entityManager;

	private final DecimalFormat format = new DecimalFormat("#.##");

	private int[] cauHinhArrInt;
	
	private String cauHinhDiem = null;

	@Override
	public void setDiemSinhVien(List<SinhVien_Diem> lstSinhVienDiem, Integer nhomMH, String maMH) {
		Session currentSession = entityManager.unwrap(Session.class);
		for (SinhVien_Diem diemso : lstSinhVienDiem) {
			// Lấy thông tin môn học của sinh viên
			SinhVien_MonHoc svmh = (SinhVien_MonHoc) currentSession
					.createQuery("from SinhVien_MonHoc svmh" + " where svmh.sinhVien.maSV = :maSV and"
							+ " svmh.nhomMonHoc.nhomMonHoc = :nhomMH and" + " svmh.nhomMonHoc.monHoc.maMonHoc = :maMH")
					.setParameter("maSV", diemso.getMaSV()).setParameter("nhomMH", nhomMH).setParameter("maMH", maMH)
					.getSingleResult();

			@SuppressWarnings("unchecked")
			// Tìm kiếm điểm của sinh viên theo môn học + nhóm môn học
			List<DiemSo> lstDs = currentSession.createQuery("from DiemSo ds where ds.sinhVienMonHoc.id =: id")
					.setParameter("id", svmh.getId()).getResultList();
			// Nếu không tồn tại thì tạo mới điểm (1)
			if (lstDs.isEmpty()) {
				DiemSo ds = new DiemSo(diemso.getDiemCC(), diemso.getDiemGK(), diemso.getDiemBTL(), diemso.getDiemThi(),
						diemso.getDiemTB(), svmh);
				// Nếu 1 trong các điểm thành phần bị thiếu hoặc = 0 thì sẽ không
				// được tính điểm TB chi (2)
				if (diemso.getDiemCC() != null && diemso.getDiemBTL() != null && diemso.getDiemGK() != null
						&& diemso.getDiemThi() != null && diemso.getDiemCC() != 0 && diemso.getDiemBTL() != 0
						&& diemso.getDiemGK() != 0 && diemso.getDiemThi() != 0 && cauHinhDiem != null) {
					// Tính điểm trung bình
					ds.setDiemTB(tinhDiemSinhVien(ds));
				}
				// Nếu 1 điểm bị thiếu thì sẽ không còn điểm trung bình
				else
					ds.setDiemTB(null);
				// Lưu điểm vừa nhập vào
				currentSession.merge(ds);
				// Nếu tồn tại thì sửa lại các điểm tương ứng (3)
			} else {
				DiemSo ds = lstDs.get(0);
				ds.setDiemCC(diemso.getDiemCC());
				ds.setDiemGK(diemso.getDiemGK());
				ds.setDiemBTL(diemso.getDiemBTL());
				ds.setDiemThi(diemso.getDiemThi());
				if (diemso.getDiemCC() != null && diemso.getDiemBTL() != null && diemso.getDiemGK() != null
						&& diemso.getDiemThi() != null && diemso.getDiemCC() != 0 && diemso.getDiemBTL() != 0
						&& diemso.getDiemGK() != 0 && diemso.getDiemThi() != 0 && cauHinhDiem != null) {
					ds.setDiemTB(tinhDiemSinhVien(ds));
				} else
					ds.setDiemTB(null);
				currentSession.merge(ds);
			}
		}

	}

//	@Override
	public Float tinhDiemSinhVien(DiemSo ds) {
		int[] cauHinhDiemFormat = this.cauHinhArrInt;
		return Float.parseFloat(
				format.format((((ds.getDiemCC() * cauHinhDiemFormat[0]) + (ds.getDiemBTL() * cauHinhDiemFormat[1])
						+ (ds.getDiemGK() * cauHinhDiemFormat[2]) + (ds.getDiemThi() * cauHinhDiemFormat[3])) / 100)));
	}

	@Override
	public int[] formatCauHinh(String cauHinhDiem) {
		// Cấu hình được lưu dưới dạng string tách và tính
		String[] cauHinhArrStr = cauHinhDiem.split("/");
		this.cauHinhArrInt = new int[cauHinhArrStr.length];
		for (int i = 0; i < this.cauHinhArrInt.length; i++) {
			this.cauHinhArrInt[i] = Integer.parseInt(cauHinhArrStr[i]);
		}
		this.cauHinhDiem = cauHinhDiem;
		return this.cauHinhArrInt;
	}

}
package com.qlsv.ptit.tinhdiemptit.resultobject;

import java.util.List;

public class DiemSos {

	private List<SinhVien_Diem> listSinhVienDiem;
	
	public DiemSos() {
		
	}

	public DiemSos(List<SinhVien_Diem> listSinhVienDiem) {
		this.listSinhVienDiem = listSinhVienDiem;
	}

	public List<SinhVien_Diem> getListSinhVienDiem() {
		return listSinhVienDiem;
	}

	public void setListSinhVienDiem(List<SinhVien_Diem> listSinhVienDiem) {
		this.listSinhVienDiem = listSinhVienDiem;
	}
	
}

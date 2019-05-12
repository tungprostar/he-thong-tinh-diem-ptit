package com.qlsv.ptit.tinhdiemptit.resultobject;

import java.util.List;

public class CauHinhDiems {

	private List<MonHoc_CauHinhDiem> listCauHinhDiem;

	public CauHinhDiems(List<MonHoc_CauHinhDiem> listCauHinhDiem) {
		this.listCauHinhDiem = listCauHinhDiem;
	}

	public CauHinhDiems() {
	}

	public List<MonHoc_CauHinhDiem> getListCauHinhDiem() {
		return listCauHinhDiem;
	}

	public void setListCauHinhDiem(List<MonHoc_CauHinhDiem> listCauHinhDiem) {
		this.listCauHinhDiem = listCauHinhDiem;
	}
	
}

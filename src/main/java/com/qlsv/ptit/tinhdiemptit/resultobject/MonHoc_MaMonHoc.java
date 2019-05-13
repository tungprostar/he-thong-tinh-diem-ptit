package com.qlsv.ptit.tinhdiemptit.resultobject;

public class MonHoc_MaMonHoc {

	private String tenMonHoc;
	
	private String maMonHoc;

	public MonHoc_MaMonHoc() {
	}

	public MonHoc_MaMonHoc(String tenMonHoc, String maMonHoc) {
		this.tenMonHoc = tenMonHoc;
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

}

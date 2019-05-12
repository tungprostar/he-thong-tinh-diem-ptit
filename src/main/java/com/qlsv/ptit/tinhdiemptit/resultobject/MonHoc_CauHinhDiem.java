package com.qlsv.ptit.tinhdiemptit.resultobject;

public class MonHoc_CauHinhDiem {

	private int maCauHinh;
	private String tenMonHoc;
	private int soTC;
	private String cauHinhDiem;
	
	public MonHoc_CauHinhDiem() {
		
	}

	public MonHoc_CauHinhDiem(int maCauHinh, String tenMonHoc, int soTC, String cauHinhDiem) {
		this.maCauHinh = maCauHinh;
		this.tenMonHoc = tenMonHoc;
		this.soTC = soTC;
		this.cauHinhDiem = cauHinhDiem;
	}

	public int getMaCauHinh() {
		return maCauHinh;
	}

	public void setMaCauHinh(int maCauHinh) {
		this.maCauHinh = maCauHinh;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getSoTC() {
		return soTC;
	}

	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}

	public String getCauHinhDiem() {
		return cauHinhDiem;
	}

	public void setCauHinhDiem(String cauHinhDiem) {
		this.cauHinhDiem = cauHinhDiem;
	}
		
}

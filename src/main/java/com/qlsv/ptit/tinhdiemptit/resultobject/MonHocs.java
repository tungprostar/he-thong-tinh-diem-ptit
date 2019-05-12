package com.qlsv.ptit.tinhdiemptit.resultobject;

public class MonHocs {

	private String tenMonHoc;
	private int nhomMonHoc;
	private String giangVien;
	private int soTC;
	
	public MonHocs() {
		
	}

	public MonHocs(String tenMonHoc, int nhomMonHoc, String giangVien, int soTC) {
		this.tenMonHoc = tenMonHoc;
		this.nhomMonHoc = nhomMonHoc;
		this.giangVien = giangVien;
		this.soTC = soTC;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getNhomMonHoc() {
		return nhomMonHoc;
	}

	public void setNhomMonHoc(int nhomMonHoc) {
		this.nhomMonHoc = nhomMonHoc;
	}

	public String getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	public int getSoTC() {
		return soTC;
	}

	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}
	
}

package com.qlsv.ptit.tinhdiemptit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="diemso")
public class DiemSo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_diemso")
	private Integer maDiemSo;
	
	@Column(name="diem_cc")
	private Integer diemCC;
	
	@Column(name="diem_gk")
	private Float diemGK;
	
	@Column(name="diem_btl")
	private Float diemBTL;
	
	@Column(name="diem_thi")
	private Float diemThi;
	
	@Column(name="diem_tb")
	private Float diemTB;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="sinhvien_monhoc_id")
	private SinhVien_MonHoc sinhVienMonHoc;

	
	public DiemSo() {
	}

	public DiemSo(Integer diemCC, Float diemGK, Float diemBTL, Float diemThi, Float diemTB,
			SinhVien_MonHoc sinhVienMonHoc) {
		this.diemCC = diemCC;
		this.diemGK = diemGK;
		this.diemBTL = diemBTL;
		this.diemThi = diemThi;
		this.diemTB = diemTB;
		this.sinhVienMonHoc = sinhVienMonHoc;
	}


	public Integer getMaDiemSo() {
		return maDiemSo;
	}


	public void setMaDiemSo(Integer maDiemSo) {
		this.maDiemSo = maDiemSo;
	}


	public Integer getDiemCC() {
		return diemCC;
	}


	public void setDiemCC(Integer diemCC) {
		this.diemCC = diemCC;
	}


	public Float getDiemGK() {
		return diemGK;
	}


	public void setDiemGK(Float diemGK) {
		this.diemGK = diemGK;
	}


	public Float getDiemBTL() {
		return diemBTL;
	}


	public void setDiemBTL(Float diemBTL) {
		this.diemBTL = diemBTL;
	}


	public Float getDiemThi() {
		return diemThi;
	}


	public void setDiemThi(Float diemThi) {
		this.diemThi = diemThi;
	}


	public Float getDiemTB() {
		return diemTB;
	}


	public void setDiemTB(Float diemTB) {
		this.diemTB = diemTB;
	}


	public SinhVien_MonHoc getSinhVienMonHoc() {
		return sinhVienMonHoc;
	}


	public void setSinhVienMonHoc(SinhVien_MonHoc sinhVienMonHoc) {
		this.sinhVienMonHoc = sinhVienMonHoc;
	}
}

package com.qlsv.ptit.tinhdiemptit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sinhvien")
public class SinhVien{

	@Id
	@Column(name="ma_sv")
	private String maSV;
	
	@Column(name="ho_lot")
	private String hoLot;
	
	@Column(name="ten")
	private String ten;
	
	@Column(name="ten_lop")
	private String tenLop;
	
	@OneToMany(mappedBy="sinhVien", cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<SinhVien_MonHoc> monHocs;
	
	public SinhVien() {
		
	}

	public SinhVien(String maSV, String hoLot, String ten, String tenLop, List<SinhVien_MonHoc> monHocs) {
		this.maSV = maSV;
		this.hoLot = hoLot;
		this.ten = ten;
		this.tenLop = tenLop;
		this.monHocs = monHocs;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoLot() {
		return hoLot;
	}

	public void setHoLot(String hoLot) {
		this.hoLot = hoLot;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public List<SinhVien_MonHoc> getMonHocs() {
		return monHocs;
	}

	public void setMonHocs(List<SinhVien_MonHoc> monHocs) {
		this.monHocs = monHocs;
	}

	
}

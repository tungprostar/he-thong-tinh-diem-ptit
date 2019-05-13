package com.qlsv.ptit.tinhdiemptit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="giangvien")
public class GiangVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_gv")
	private String maGV;
	
	@Column(name="ho_ten")
	private String hoTen;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinTable(
			name="monhoc_giangvien",
			joinColumns = @JoinColumn(name="giangvien_ma_gv"),
			inverseJoinColumns = @JoinColumn(name="nhommonhoc_nhom_monhoc")
			)
	private List<MonHoc> monHocs;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private User user;

	public GiangVien() {
		
	}
	
	public GiangVien(String maGV, String hoTen, List<MonHoc> monHocs, User user) {
		this.maGV = maGV;
		this.hoTen = hoTen;
		this.monHocs = monHocs;
		this.user = user;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public List<MonHoc> getMonHocs() {
		return monHocs;
	}

	public void setMonHocs(List<MonHoc> monHocs) {
		this.monHocs = monHocs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

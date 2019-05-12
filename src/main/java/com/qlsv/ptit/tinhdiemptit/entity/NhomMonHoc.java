package com.qlsv.ptit.tinhdiemptit.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="nhommonhoc")
public class NhomMonHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nhom_monhoc")
	private int nhomMonHoc;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "monhoc_ma_monhoc")
	private MonHoc monHoc;
	
	@OneToMany(mappedBy = "nhomMonHoc", cascade = CascadeType.ALL)
	private List<SinhVien_MonHoc> sinhViens;
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(
			name = "monhoc_giangvien", 
			joinColumns = @JoinColumn(name = "nhommonhoc_nhom_monhoc"), 
			inverseJoinColumns = @JoinColumn(name = "giangvien_ma_gv")
	)
	private List<GiangVien> giangViens;
	
	public NhomMonHoc() {
		
	}

	public NhomMonHoc(int nhomMonHoc, MonHoc monHoc, List<SinhVien_MonHoc> sinhViens, List<GiangVien> giangViens) {
		this.nhomMonHoc = nhomMonHoc;
		this.monHoc = monHoc;
		this.sinhViens = sinhViens;
		this.giangViens = giangViens;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNhomMonHoc() {
		return nhomMonHoc;
	}

	public void setNhomMonHoc(int nhomMonHoc) {
		this.nhomMonHoc = nhomMonHoc;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public List<SinhVien_MonHoc> getSinhViens() {
		return sinhViens;
	}

	public void setSinhViens(List<SinhVien_MonHoc> sinhViens) {
		this.sinhViens = sinhViens;
	}

	public List<GiangVien> getGiangViens() {
		return giangViens;
	}

	public void setGiangViens(List<GiangVien> giangViens) {
		this.giangViens = giangViens;
	}
	
}

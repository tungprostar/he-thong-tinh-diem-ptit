package com.qlsv.ptit.tinhdiemptit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sinhvien_monhoc")
public class SinhVien_MonHoc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="sinhvien_ma_sv")
	private SinhVien sinhVien;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="nhommonhoc_id")
	private NhomMonHoc nhomMonHoc;
	
	
	@OneToOne(mappedBy = "sinhVienMonHoc", cascade = CascadeType.ALL)
	private DiemSo diemSo;
	
	public SinhVien_MonHoc() {
		
	}

	public SinhVien_MonHoc(int id, SinhVien sinhVien, NhomMonHoc nhomMonHoc, DiemSo diemSo) {
		this.id = id;
		this.sinhVien = sinhVien;
		this.nhomMonHoc = nhomMonHoc;
		this.diemSo = diemSo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public NhomMonHoc getNhomMonHoc() {
		return nhomMonHoc;
	}

	public void setNhomMonHoc(NhomMonHoc nhomMonHoc) {
		this.nhomMonHoc = nhomMonHoc;
	}

	public DiemSo getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(DiemSo diemSo) {
		this.diemSo = diemSo;
	}
	
}

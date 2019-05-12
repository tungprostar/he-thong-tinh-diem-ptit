package com.qlsv.ptit.tinhdiemptit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cauhinhdiem")
public class CauHinhDiem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_cauhinh")
	private int maCauHinh;
	
	@Column(name="cauhinh")
	private String cauHinh;

	@OneToOne(mappedBy = "cauHinhDiem", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private MonHoc monHoc;
	
	public CauHinhDiem() {
		
	}
	
	public CauHinhDiem(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public int getMaCauHinh() {
		return maCauHinh;
	}

	public void setMaCauHinh(int maCauHinh) {
		this.maCauHinh = maCauHinh;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}
	
	

	
}

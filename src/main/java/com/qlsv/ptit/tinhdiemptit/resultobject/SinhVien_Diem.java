package com.qlsv.ptit.tinhdiemptit.resultobject;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SinhVien_Diem {

	private String maSV;
	private String hoLot;
	private String ten;
	private String tenLop;
	
//	@Pattern(regexp = "^[0-9]+", message = "only number")
	@Min(value = 0, message = ">=0")
	@Max(value = 10, message = "<=10")
	private Integer diemCC;
	
	@Min(value = 0, message = ">=0")
	@Max(value = 10, message = "<=10")
	private Float diemGK;
	
	@Min(value = 0, message = ">=0")
	@Max(value = 10, message = "<=10")
	private Float diemBTL;
	
	@Min(value = 0, message = ">=0")
	@Max(value = 10, message = "<=10")
	private Float diemThi;
	
	private Float diemTB;
	
	public SinhVien_Diem() {
		
	}

	public SinhVien_Diem(String maSV, String hoLot, String ten, String tenLop, Integer diemCC, Float diemGK,
			Float diemBTL, Float diemThi, Float diemTB) {
		this.maSV = maSV;
		this.hoLot = hoLot;
		this.ten = ten;
		this.tenLop = tenLop;
		this.diemCC = diemCC;
		this.diemGK = diemGK;
		this.diemBTL = diemBTL;
		this.diemThi = diemThi;
		this.diemTB = diemTB;
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

}

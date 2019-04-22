package hrm.entities;

import java.util.Date;

public class baocao {
	private int id;
	private int manv;
	private String hoten;
	private String ndbc;
	private String ngaybc;
	private String duan;

	public baocao() {
		super();
	}

	public baocao(int id, int manv, String hoten, String ndbc, String ngaybc, String duan) {
		super();
		this.id = id;
		this.manv = manv;
		this.hoten = hoten;
		this.ndbc = ndbc;
		this.ngaybc = ngaybc;
		this.duan = duan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getNdbc() {
		return ndbc;
	}

	public void setNdbc(String ndbc) {
		this.ndbc = ndbc;
	}

	public String getNgaybc() {
		return ngaybc;
	}

	public void setNgaybc(String ngaybc) {
		this.ngaybc = ngaybc;
	}

	public String getDuan() {
		return duan;
	}

	public void setDuan(String duan) {
		this.duan = duan;
	}
}

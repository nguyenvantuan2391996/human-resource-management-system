package hrm.entities;

import java.util.Date;

public class baocao {
	private String manv;
	private String ndbc;
	private Date ngaybc;
	private String duan;

	public baocao() {
		super();
	}

	public baocao(String manv, String ndbc, Date ngaybc, String duan) {
		super();
		this.manv = manv;
		this.ndbc = ndbc;
		this.ngaybc = ngaybc;
		this.duan = duan;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getNdbc() {
		return ndbc;
	}

	public void setNdbc(String ndbc) {
		this.ndbc = ndbc;
	}

	public Date getNgaybc() {
		return ngaybc;
	}

	public void setNgaybc(Date ngaybc) {
		this.ngaybc = ngaybc;
	}

	public String getDuan() {
		return duan;
	}

	public void setDuan(String duan) {
		this.duan = duan;
	}

}

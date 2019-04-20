package hrm.entities;

public class quanly {
	private int maql;
	private String tentk;
	private String matkhau;
	private String loaitk;

	public quanly() {
		super();
	}

	public quanly(int maql, String tentk, String matkhau, String loaitk) {
		super();
		this.maql = maql;
		this.tentk = tentk;
		this.matkhau = matkhau;
		this.loaitk = loaitk;
	}

	public int getMaql() {
		return maql;
	}

	public void setMaql(int maql) {
		this.maql = maql;
	}

	public String getTentk() {
		return tentk;
	}

	public void setTentk(String tentk) {
		this.tentk = tentk;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getLoaitk() {
		return loaitk;
	}

	public void setLoaitk(String loaitk) {
		this.loaitk = loaitk;
	}

}

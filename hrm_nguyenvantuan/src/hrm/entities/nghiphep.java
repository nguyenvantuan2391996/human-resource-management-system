package hrm.entities;

public class nghiphep {
	private int id;
	private int manv;
	private String hoten;
	private String loainghiphep;
	private String ngaynghi;
	private String lydo;
	private String xacnhan;

	public nghiphep() {
		super();
	}

	public nghiphep(int id, int manv, String hoten, String loainghiphep, String ngaynghi, String lydo, String xacnhan) {
		super();
		this.id = id;
		this.manv = manv;
		this.hoten = hoten;
		this.loainghiphep = loainghiphep;
		this.ngaynghi = ngaynghi;
		this.lydo = lydo;
		this.xacnhan = xacnhan;
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

	public String getLoainghiphep() {
		return loainghiphep;
	}

	public void setLoainghiphep(String loainghiphep) {
		this.loainghiphep = loainghiphep;
	}

	public String getNgaynghi() {
		return ngaynghi;
	}

	public void setNgaynghi(String ngaynghi) {
		this.ngaynghi = ngaynghi;
	}

	public String getLydo() {
		return lydo;
	}

	public void setLydo(String lydo) {
		this.lydo = lydo;
	}

	public String getXacnhan() {
		return xacnhan;
	}

	public void setXacnhan(String xacnhan) {
		this.xacnhan = xacnhan;
	}
}

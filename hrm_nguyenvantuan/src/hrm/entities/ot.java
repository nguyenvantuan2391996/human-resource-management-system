package hrm.entities;

public class ot {
	private int id;
	private int manv;
	private String hoten;
	private int sogioot;
	private String ngayot;
	private String lydo;
	private String xacnhan;

	public ot() {
		super();
	}

	public ot(int id, int manv, String hoten, int sogioot, String ngayot, String lydo, String xacnhan) {
		super();
		this.id = id;
		this.manv = manv;
		this.hoten = hoten;
		this.sogioot = sogioot;
		this.ngayot = ngayot;
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

	public int getSogioot() {
		return sogioot;
	}

	public void setSogioot(int sogioot) {
		this.sogioot = sogioot;
	}

	public String getNgayot() {
		return ngayot;
	}

	public void setNgayot(String ngayot) {
		this.ngayot = ngayot;
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

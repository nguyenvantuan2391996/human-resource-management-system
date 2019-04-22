package hrm.entities;

public class tienluong {
	private int manv;
	private String hoten;
	private String trinhdo;
	private float hesoluong;
	private float sogiocong;
	private float sogioot;
	private float songaynghi;
	private float tongluong;
	private float tientrocap;

	public tienluong() {
		super();
	}

	public tienluong(int manv, String hoten, String trinhdo, float hesoluong, float sogiocong, float sogioot,
			float songaynghi, float tongluong, float tientrocap) {
		super();
		this.manv = manv;
		this.hoten = hoten;
		this.trinhdo = trinhdo;
		this.hesoluong = hesoluong;
		this.sogiocong = sogiocong;
		this.sogioot = sogioot;
		this.songaynghi = songaynghi;
		this.tongluong = tongluong;
		this.tientrocap = tientrocap;
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

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public float getHesoluong() {
		return hesoluong;
	}

	public void setHesoluong(float hesoluong) {
		this.hesoluong = hesoluong;
	}

	public float getSogiocong() {
		return sogiocong;
	}

	public void setSogiocong(float sogiocong) {
		this.sogiocong = sogiocong;
	}

	public float getSogioot() {
		return sogioot;
	}

	public void setSogioot(float sogioot) {
		this.sogioot = sogioot;
	}

	public float getSongaynghi() {
		return songaynghi;
	}

	public void setSongaynghi(float songaynghi) {
		this.songaynghi = songaynghi;
	}

	public float getTongluong() {
		return tongluong;
	}

	public void setTongluong(float tongluong) {
		this.tongluong = tongluong;
	}

	public float getTientrocap() {
		return tientrocap;
	}

	public void setTientrocap(float tientrocap) {
		this.tientrocap = tientrocap;
	}
}

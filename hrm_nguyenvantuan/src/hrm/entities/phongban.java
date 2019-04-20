package hrm.entities;

public class phongban {
	private int mapb;
	private String tenpb;
	private String sdt;
	private String mota;

	public phongban() {
		super();
	}

	public phongban(int mapb, String tenpb, String sdt, String mota) {
		super();
		this.mapb = mapb;
		this.tenpb = tenpb;
		this.sdt = sdt;
		this.mota = mota;
	}

	public int getMapb() {
		return mapb;
	}

	public void setMapb(int mapb) {
		this.mapb = mapb;
	}

	public String getTenpb() {
		return tenpb;
	}

	public void setTenpb(String tenpb) {
		this.tenpb = tenpb;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

}

package hrm.entities;

public class dapantraloi {
	private int id;
	private int macauhoi;
	private int mauv;
	private String traloi;

	public dapantraloi() {
		super();
	}

	public dapantraloi(int id, int macauhoi, int mauv, String traloi) {
		super();
		this.id = id;
		this.macauhoi = macauhoi;
		this.mauv = mauv;
		this.traloi = traloi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMacauhoi() {
		return macauhoi;
	}

	public void setMacauhoi(int macauhoi) {
		this.macauhoi = macauhoi;
	}

	public int getMauv() {
		return mauv;
	}

	public void setMauv(int mauv) {
		this.mauv = mauv;
	}

	public String getTraloi() {
		return traloi;
	}

	public void setTraloi(String traloi) {
		this.traloi = traloi;
	}

}

package hrm.entities;

public class duan {
	private int maduan;
	private String tenduan;

	public duan() {
		super();
	}

	public duan(int maduan, String tenduan) {
		super();
		this.maduan = maduan;
		this.tenduan = tenduan;
	}

	public int getMaduan() {
		return maduan;
	}

	public void setMaduan(int maduan) {
		this.maduan = maduan;
	}

	public String getTenduan() {
		return tenduan;
	}

	public void setTenduan(String tenduan) {
		this.tenduan = tenduan;
	}

}

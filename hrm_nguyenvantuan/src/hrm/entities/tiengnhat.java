package hrm.entities;

public class tiengnhat {
	private int matn;
	private String trinhdo;
	private Float tientrocap;

	public tiengnhat() {
		super();
	}

	public tiengnhat(int matn, String trinhdo, Float tientrocap) {
		super();
		this.matn = matn;
		this.trinhdo = trinhdo;
		this.tientrocap = tientrocap;
	}

	public int getMatn() {
		return matn;
	}

	public void setMatn(int matn) {
		this.matn = matn;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public Float getTientrocap() {
		return tientrocap;
	}

	public void setTientrocap(Float tientrocap) {
		this.tientrocap = tientrocap;
	}
}

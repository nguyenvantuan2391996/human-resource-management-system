package hrm.entities;

public class danhgia {
	private int mauv;
	private int matp;
	private float hoadong;
	private float trungthuc;
	private float xulytt;
	private float giaotiep;

	public danhgia() {
		super();
	}

	public danhgia(int mauv, int matp, float hoadong, float trungthuc, float xulytt, float giaotiep) {
		super();
		this.mauv = mauv;
		this.matp = matp;
		this.hoadong = hoadong;
		this.trungthuc = trungthuc;
		this.xulytt = xulytt;
		this.giaotiep = giaotiep;
	}

	public int getMauv() {
		return mauv;
	}

	public void setMauv(int mauv) {
		this.mauv = mauv;
	}

	public int getMatp() {
		return matp;
	}

	public void setMatp(int matp) {
		this.matp = matp;
	}

	public float getHoadong() {
		return hoadong;
	}

	public void setHoadong(float hoadong) {
		this.hoadong = hoadong;
	}

	public float getTrungthuc() {
		return trungthuc;
	}

	public void setTrungthuc(float trungthuc) {
		this.trungthuc = trungthuc;
	}

	public float getXulytt() {
		return xulytt;
	}

	public void setXulytt(float xulytt) {
		this.xulytt = xulytt;
	}

	public float getGiaotiep() {
		return giaotiep;
	}

	public void setGiaotiep(float giaotiep) {
		this.giaotiep = giaotiep;
	}
}

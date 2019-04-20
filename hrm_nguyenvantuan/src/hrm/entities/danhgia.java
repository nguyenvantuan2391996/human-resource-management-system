package hrm.entities;

public class danhgia {
	private int mauv;
	private int matp;
	private int hoadong;
	private int trungthuc;
	private int xulytt;
	private int giaotiep;

	public danhgia() {
		super();
	}

	public danhgia(int mauv, int matp, int hoadong, int trungthuc, int xulytt, int giaotiep) {
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

	public int getHoadong() {
		return hoadong;
	}

	public void setHoadong(int hoadong) {
		this.hoadong = hoadong;
	}

	public int getTrungthuc() {
		return trungthuc;
	}

	public void setTrungthuc(int trungthuc) {
		this.trungthuc = trungthuc;
	}

	public int getXulytt() {
		return xulytt;
	}

	public void setXulytt(int xulytt) {
		this.xulytt = xulytt;
	}

	public int getGiaotiep() {
		return giaotiep;
	}

	public void setGiaotiep(int giaotiep) {
		this.giaotiep = giaotiep;
	}

}

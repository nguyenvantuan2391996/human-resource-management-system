package hrm.entities;

public class nhanvien {
	private int manv;
	private int matp;
	private int mapb;
	private int matn;
	private int maduan;
	private String tentp;
	private String tenpb;
	private String tenduan;
	private String trinhdo;
	private int hesoluong;
	private String hoten;
	private int namsinh;
	private String diachi;
	private String gioitinh;
	private String sdt;
	private String danhgia;
	private String tentk;
	private String matkhau;
	private String loaitk;

	public nhanvien() {
		super();
	}

	public nhanvien(int manv, int matp, int mapb, int matn, int maduan, String tentp, String tenpb, String tenduan,
			String trinhdo, int hesoluong, String hoten, int namsinh, String diachi, String gioitinh, String sdt,
			String danhgia, String tentk, String matkhau, String loaitk) {
		super();
		this.manv = manv;
		this.matp = matp;
		this.mapb = mapb;
		this.matn = matn;
		this.maduan = maduan;
		this.tentp = tentp;
		this.tenpb = tenpb;
		this.tenduan = tenduan;
		this.trinhdo = trinhdo;
		this.hesoluong = hesoluong;
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
		this.danhgia = danhgia;
		this.tentk = tentk;
		this.matkhau = matkhau;
		this.loaitk = loaitk;
	}

	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public int getMatp() {
		return matp;
	}

	public void setMatp(int matp) {
		this.matp = matp;
	}

	public int getMapb() {
		return mapb;
	}

	public void setMapb(int mapb) {
		this.mapb = mapb;
	}

	public int getMatn() {
		return matn;
	}

	public void setMatn(int matn) {
		this.matn = matn;
	}

	public int getMaduan() {
		return maduan;
	}

	public void setMaduan(int maduan) {
		this.maduan = maduan;
	}

	public String getTentp() {
		return tentp;
	}

	public void setTentp(String tentp) {
		this.tentp = tentp;
	}

	public String getTenpb() {
		return tenpb;
	}

	public void setTenpb(String tenpb) {
		this.tenpb = tenpb;
	}

	public String getTenduan() {
		return tenduan;
	}

	public void setTenduan(String tenduan) {
		this.tenduan = tenduan;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public int getHesoluong() {
		return hesoluong;
	}

	public void setHesoluong(int hesoluong) {
		this.hesoluong = hesoluong;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDanhgia() {
		return danhgia;
	}

	public void setDanhgia(String danhgia) {
		this.danhgia = danhgia;
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

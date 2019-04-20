package hrm.entities;

public class nhanvien {
	private int manv;
	private int matp;
	private int mapb;
	private String tentp;
	private String tenpb;
	private String tenduan;
	private String duan;
	private String hoten;
	private int namsinh;
	private String diachi;
	private String gioitinh;
	private String sdt;
	private String tentk;
	private String matkhau;
	private String loaitk;

	public nhanvien() {
		super();
	}

	public nhanvien(int manv, int matp, int mapb, String tentp, String tenpb, String tenduan, String duan, String hoten,
			int namsinh, String diachi, String gioitinh, String sdt, String tentk, String matkhau, String loaitk) {
		super();
		this.manv = manv;
		this.matp = matp;
		this.mapb = mapb;
		this.tentp = tentp;
		this.tenpb = tenpb;
		this.tenduan = tenduan;
		this.duan = duan;
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.sdt = sdt;
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

	public String getDuan() {
		return duan;
	}

	public void setDuan(String duan) {
		this.duan = duan;
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

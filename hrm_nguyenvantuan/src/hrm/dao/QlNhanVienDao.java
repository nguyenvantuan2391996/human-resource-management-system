package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.nhanvien;
import hrm.entities.truongphong;

public class QlNhanVienDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<nhanvien> getArrNV(int page, String search) {
		ArrayList<nhanvien> arrnv = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from nhanvien, truongphong, phongban ");
		sql.append("where nhanvien.matp = truongphong.matp ");
		sql.append("and nhanvien.mapb = phongban.mapb ");

		if (!"".equals(search)) {
			sql.append("and hoten like ? ");
		}
		if (page != 0) {
			sql.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());

				if (!"".equals(search)) {
					stmt.setString(1, "%" + search + "%");
					stmt.setInt(2, (page - 1) * 5);
				}
				if (page != 0) {
					stmt.setInt(1, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					nhanvien nv = new nhanvien();
					nv.setManv(Integer.valueOf(rs.getString("manv")));
					nv.setMatp(Integer.valueOf(rs.getString("matp")));
					nv.setMapb(Integer.valueOf(rs.getString("mapb")));
					nv.setHoten(rs.getString("nhanvien.hoten"));
					nv.setTentp(rs.getString("truongphong.hoten"));
					nv.setNamsinh(rs.getShort("namsinh"));
					nv.setDiachi(rs.getString("diachi"));
					nv.setGioitinh(rs.getString("gioitinh"));
					nv.setSdt(rs.getString("sdt"));
					nv.setTenpb(rs.getString("tenphong"));

					arrnv.add(nv);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrnv;
	}

	public int getTotalPage(String search) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(manv) as total from nhanvien ");

		if (!"".equals(search)) {
			sql.append("where hoten like ? ");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());
				if (!"".equals(search)) {
					stmt.setString(1, "%" + search + "%");
				}
				rs = stmt.executeQuery();
				if (rs.next()) {
					total = Integer.valueOf(rs.getString("total")) / 5 + 1;
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return total;
	}

	public boolean addNV(nhanvien nv) {
		String sql = "insert into nhanvien(manv, matp, mapb, hoten, namsinh, diachi, gioitinh, sdt, tentk, matkhau) values(?,?,?,?,?,?,?,?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1, nv.getManv());
				stmt.setInt(2, nv.getMatp());
				stmt.setInt(3, nv.getMapb());
				stmt.setString(4, nv.getHoten());
				stmt.setInt(5, nv.getNamsinh());
				stmt.setString(6, nv.getDiachi());
				stmt.setString(7, nv.getGioitinh());
				stmt.setString(8, nv.getSdt());
				stmt.setString(9, nv.getTentk());
				stmt.setString(10, nv.getMatkhau());

				stmt.executeUpdate();

				return true;
			} catch (Exception e) {
				return false;
			} finally {
				closeConnection();
			}
		}

		return false;
	}

	public boolean editNV(nhanvien nv) {
		String sql = "update nhanvien set matp = ?, mapb = ?, hoten = ?, namsinh = ?, diachi = ?, gioitinh = ?, sdt = ? where manv = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1, nv.getMatp());
				stmt.setInt(2, nv.getMapb());
				stmt.setString(3, nv.getHoten());
				stmt.setInt(4, nv.getNamsinh());
				stmt.setString(5, nv.getDiachi());
				stmt.setString(6, nv.getGioitinh());
				stmt.setString(7, nv.getSdt());
				stmt.setInt(8, nv.getManv());

				stmt.executeUpdate();

				return true;
			} catch (Exception e) {
				return false;
			} finally {
				closeConnection();
			}
		}

		return false;
	}

	public boolean deleteNV(nhanvien nv) {
		String sqlbc = "delete from baocao where manv = ?";
		String sqlluong = "delete from luong where manv = ?";
		String sqlnp = "delete from nghiphep where manv = ?";
		String sqlcc = "delete from chamcong where manv = ?";
		String sqlot = "delete from ot where manv = ?";
		String sqlnv = "delete from nhanvien where manv = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				conn.setAutoCommit(false);

				stmt = conn.prepareStatement(sqlbc);
				stmt.setInt(1, nv.getManv());

				stmt.executeUpdate();

				stmt = conn.prepareStatement(sqlluong);
				stmt.setInt(1, nv.getManv());

				stmt.executeUpdate();

				stmt = conn.prepareStatement(sqlnp);
				stmt.setInt(1, nv.getManv());

				stmt.executeUpdate();
				
				stmt = conn.prepareStatement(sqlcc);
				stmt.setInt(1, nv.getManv());

				stmt.executeUpdate();

				stmt = conn.prepareStatement(sqlot);
				stmt.setInt(1, nv.getManv());

				stmt.executeUpdate();

				stmt = conn.prepareStatement(sqlnv);
				stmt.setInt(1, nv.getManv());

				stmt.executeUpdate();

				conn.commit();

				return true;
			} catch (Exception e) {
				rollback();
				return false;
			} finally {
				closeConnection();
			}
		}

		return false;
	}

}

package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hrm.entities.nhanvien;
import hrm.entities.quanly;
import hrm.entities.truongphong;
import hrm.entities.ungvien;

public class LoginDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public quanly getQuanLy(String username, String password) {
		quanly ql = null;

		String sql = "select * from quanly " + " where tentk = ? and matkhau = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					ql = new quanly();
					ql.setMaql(Integer.valueOf(rs.getString("maql")));
					ql.setTentk(rs.getString("tentk"));
					ql.setMatkhau(rs.getString("matkhau"));
					ql.setLoaitk(rs.getString("loaitk"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return ql;
	}
	
	public nhanvien getNhanVien(String username, String password) {
		nhanvien nv = null;

		String sql = "select * from nhanvien " + " where tentk = ? and matkhau = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					nv = new nhanvien();
					nv.setManv(Integer.valueOf(rs.getString("manv")));
					nv.setTentk(rs.getString("tentk"));
					nv.setMatkhau(rs.getString("matkhau"));
					nv.setLoaitk(rs.getString("loaitk"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return nv;
	}
	
	public truongphong getTruongPhong(String username, String password) {
		truongphong tp = null;

		String sql = "select * from truongphong " + " where tentk = ? and matkhau = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					tp = new truongphong();
					tp.setMatp(Integer.valueOf(rs.getString("matp")));
					tp.setTentk(rs.getString("tentk"));
					tp.setMatkhau(rs.getString("matkhau"));
					tp.setLoaitk(rs.getString("loaitk"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return tp;
	}
	
	public ungvien getUngVien(String username, String password) {
		ungvien uv = null;

		String sql = "select * from ungvien " + " where tentk = ? and matkhau = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					uv = new ungvien();
					uv.setMauv(rs.getInt("mauv"));
					uv.setTentk(rs.getString("tentk"));
					uv.setMatkhau(rs.getString("matkhau"));
					uv.setLoaitk(rs.getString("loaitk"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return uv;
	}
	
}

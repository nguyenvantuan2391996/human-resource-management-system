package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.truongphong;
import hrm.entities.ungvien;

public class QlUngVienDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<ungvien> getArrUV(int page, String search) {
		ArrayList<ungvien> arruv = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from ungvien ");

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
					ungvien uv = new ungvien();
					uv.setMauv(Integer.valueOf(rs.getString("mauv")));
					uv.setHoten(rs.getString("hoten"));
					uv.setNamsinh(rs.getShort("namsinh"));
					uv.setDiachi(rs.getString("diachi"));
					uv.setGioitinh(rs.getString("gioitinh"));
					uv.setSdt(rs.getString("sdt"));

					arruv.add(uv);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arruv;
	}
	
	public int getTotalPage(String search) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(mauv) as total from ungvien ");

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
	
	public boolean addUV(ungvien uv) {
		String sql = "insert into ungvien(mauv, hoten, namsinh, diachi, gioitinh, sdt, tentk, matkhau) values(?,?,?,?,?,?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, uv.getMauv());
				stmt.setString(2, uv.getHoten());
				stmt.setInt(3, uv.getNamsinh());
				stmt.setString(4, uv.getDiachi());
				stmt.setString(5, uv.getGioitinh());
				stmt.setString(6, uv.getSdt());
				stmt.setString(7, uv.getTentk());
				stmt.setString(8, uv.getMatkhau());

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
	
	public boolean editUV(ungvien uv) {
		String sql = "update ungvien set hoten = ?, namsinh = ?, diachi = ?, gioitinh = ?, sdt = ? where mauv = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, uv.getHoten());
				stmt.setInt(2, uv.getNamsinh());
				stmt.setString(3, uv.getDiachi());
				stmt.setString(4, uv.getGioitinh());
				stmt.setString(5, uv.getSdt());
				stmt.setInt(6, uv.getMauv());
				
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

	public boolean deleteUV(ungvien uv) {
		String sqldg = "delete from danhgia where mauv = ?";
		String sqluv = "delete from ungvien where mauv = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				conn.setAutoCommit(false);
				
				stmt = conn.prepareStatement(sqldg);
				stmt.setInt(1, uv.getMauv());
				
				stmt.executeUpdate();
				
				stmt = conn.prepareStatement(sqluv);
				stmt.setInt(1, uv.getMauv());
				
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

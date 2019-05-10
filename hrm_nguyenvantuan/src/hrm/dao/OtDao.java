package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.ot;

public class OtDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<ot> getArrOT(int page, String search, int id, String type) {
		ArrayList<ot> arrot = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from ot, nhanvien ");
		sql.append("where ot.manv = nhanvien.manv ");
		if ("nhanvien".equals(type)) {
			sql.append("and nhanvien.manv = ? ");
		}
		if ("truongphong".equals(type)) {
			sql.append("and matp = ? ");
			sql.append("and ot.xacnhan = 'None' ");
		}

		if (!"".equals(search)) {
			sql.append("and ot.lydo like ? ");
		}
		if (page != 0) {
			sql.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());

				if (!"".equals(search)) {
					stmt.setInt(1, id);
					stmt.setString(2, "%" + search + "%");
					stmt.setInt(3, (page - 1) * 5);
				}
				if (page != 0) {
					stmt.setInt(1, id);
					stmt.setInt(2, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					ot ot = new ot();
					ot.setId(Integer.valueOf(rs.getString("id")));
					ot.setHoten(rs.getString("hoten"));
					ot.setSogioot(Integer.valueOf(rs.getString("sogioot")));
					ot.setNgayot(rs.getString("ngayot"));
					ot.setLydo(rs.getString("lydo"));
					ot.setXacnhan(rs.getString("xacnhan"));

					arrot.add(ot);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrot;
	}

	public int getTotalPage(String search, int id, String type) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(id) as total from ot, nhanvien ");
		sql.append("where ot.manv = nhanvien.manv ");
		if ("nhanvien".equals(type)) {
			sql.append("and nhanvien.manv = ? ");
		}
		if ("truongphong".equals(type)) {
			sql.append("and matp = ? ");
		}

		if (!"".equals(search)) {
			sql.append("and lydo like ? ");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());
				if (!"".equals(search)) {
					stmt.setInt(1, id);
					stmt.setString(2, "%" + search + "%");
				} else {
					stmt.setInt(1, id);
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

	public boolean addOT(ot ot) {
		String sql = "insert into ot(manv, sogioot, ngayot, lydo) values(?,?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, ot.getManv());
				stmt.setInt(2, ot.getSogioot());
				stmt.setString(3, ot.getNgayot());
				stmt.setString(4, ot.getLydo());

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

	public boolean editOT(ot ot) {
		String sql = "update ot set manv = ?, sogioot = ?, ngayot = ?, lydo = ? where id = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1, ot.getManv());
				stmt.setInt(2, ot.getSogioot());
				stmt.setString(3, ot.getNgayot());
				stmt.setString(4, ot.getLydo());
				stmt.setInt(5, ot.getId());

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

	public boolean checkConfirm(String type, int id) {
		String sql = "update ot set xacnhan = ? where id = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, type);
				stmt.setInt(2, id);

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

}

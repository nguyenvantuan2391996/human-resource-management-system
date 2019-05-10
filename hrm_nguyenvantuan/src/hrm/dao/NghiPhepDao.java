package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.nghiphep;

public class NghiPhepDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<nghiphep> getArrNP(int page, String search, int id, String type) {
		ArrayList<nghiphep> arrnp = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from nghiphep, nhanvien ");
		sql.append("where nghiphep.manv = nhanvien.manv ");

		if ("nhanvien".equals(type)) {
			sql.append("and nhanvien.manv = ? ");
		}
		if ("truongphong".equals(type)) {
			sql.append("and matp = ? ");
			sql.append("and nghiphep.xacnhan = 'None' ");
		}

		if (!"".equals(search)) {
			sql.append("and np.lydo like ? ");
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
					nghiphep np = new nghiphep();
					np.setId(Integer.valueOf(rs.getString("id")));
					np.setHoten(rs.getString("hoten"));
					np.setLoainghiphep(rs.getString("loainghiphep"));
					np.setNgaynghi(rs.getString("ngaynghi"));
					np.setLydo(rs.getString("lydo"));
					np.setXacnhan(rs.getString("xacnhan"));

					arrnp.add(np);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrnp;
	}

	public int getTotalPage(String search, int id, String type) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(id) as total from nghiphep, nhanvien ");
		sql.append("where nghiphep.manv = nhanvien.manv ");
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

	public boolean addNP(nghiphep np) {
		String sql = "insert into nghiphep(manv, ngaynghi, loainghiphep, sobuoi, lydo) values(?,?,?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, np.getManv());
				stmt.setString(2, np.getNgaynghi());
				stmt.setString(3, np.getLoainghiphep());
				if ("Sáng".equals(np.getLoainghiphep()) || "Chiều".equals(np.getLoainghiphep())) {
					stmt.setFloat(4, 0.5f);
				}
				if ("Cả Ngày".equals(np.getLoainghiphep())) {
					stmt.setFloat(4, 1f);
				}
				stmt.setString(5, np.getLydo());

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

	public boolean editNP(nghiphep np) {
		String sql = "update nghiphep set manv = ?, ngaynghi = ?, loainghiphep = ?, sobuoi = ?, lydo = ? where id = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1, np.getManv());
				stmt.setString(2, np.getNgaynghi());
				stmt.setString(3, np.getLoainghiphep());
				if ("Sáng".equals(np.getLoainghiphep()) || "Chiều".equals(np.getLoainghiphep())) {
					stmt.setFloat(4, 0.5f);
				}
				if ("Cả Ngày".equals(np.getLoainghiphep())) {
					stmt.setFloat(4, 1f);
				}
				stmt.setString(5, np.getLydo());
				stmt.setInt(6, np.getId());

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
		String sql = "update nghiphep set xacnhan = ? where id = ?";
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

package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import hrm.entities.baocao;

public class BaoCaoDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<baocao> getArrBC(int page, String search, int id) {
		ArrayList<baocao> arrbc = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from baocao, nhanvien, duan ");
		sql.append("where baocao.manv = nhanvien.manv ");
		sql.append("and nhanvien.maduan = duan.maduan ");
		sql.append("and nhanvien.manv = ? ");

		if (!"".equals(search)) {
			sql.append("and duan.tenduan like ? ");
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
					baocao bc = new baocao();
					bc.setId(Integer.valueOf(rs.getString("id")));
					bc.setHoten(rs.getString("hoten"));
					bc.setDuan(rs.getString("tenduan"));
					bc.setNdbc(rs.getString("ndbc"));
					bc.setNgaybc(rs.getString("ngaybc"));

					arrbc.add(bc);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrbc;
	}

	public int getTotalPage(String search, int id) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(id) as total from baocao ");
		sql.append("where manv = ? ");

		if (!"".equals(search)) {
			sql.append("and hoten like ? ");
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

	public boolean addBC(baocao bc) {
		String sql = "insert into baocao(manv, ndbc, ngaybc) values(?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, bc.getManv());
				stmt.setString(2, bc.getNdbc());
				stmt.setString(3, bc.getNgaybc());
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

	public boolean editBC(baocao bc) {
		String sql = "update baocao set manv = ?, ndbc = ?, ngaybc = ? where id = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1, bc.getManv());
				stmt.setString(2, bc.getNdbc());
				stmt.setString(3, bc.getNgaybc());
				stmt.setInt(4, bc.getId());

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

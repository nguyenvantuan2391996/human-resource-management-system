package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.phongban;

public class PhongBanDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * get list phongban
	 * 
	 * @param page
	 * @return
	 */
	public ArrayList<phongban> getArrayPb(int page, String search) {
		ArrayList<phongban> arrpb = new ArrayList<>();
		StringBuilder sql = new StringBuilder();

		sql.append("select * from phongban ");
		if (!"".equals(search)) {
			sql.append("where tenphong like ? ");
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
					phongban pb = new phongban();
					pb.setMapb(Integer.valueOf(rs.getString("mapb")));
					pb.setTenpb(rs.getString("tenphong"));
					pb.setSdt(rs.getString("sdt"));
					pb.setMota(rs.getString("mota"));

					arrpb.add(pb);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}

		return arrpb;
	}

	/**
	 * get total page
	 * 
	 * @return
	 */
	public int getTotalPage(String search) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(mapb) as total from phongban ");
		if (!"".equals(search)) {
			sql.append("where tenphong like ? ");
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

	/**
	 * add phongban to database
	 * 
	 * @param pb
	 * @return
	 */
	public boolean addPB(phongban pb) {
		String sql = "insert into phongban(tenphong, sdt, mota) values(?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, pb.getTenpb());
				stmt.setString(2, pb.getSdt());
				stmt.setString(3, pb.getMota());

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

	/**
	 * edit phongban
	 * 
	 * @param pb
	 * @return
	 */
	public boolean editPB(phongban pb) {
		String sql = "update phongban set tenphong = ?, sdt = ?, mota = ? where mapb = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, pb.getTenpb());
				stmt.setString(2, pb.getSdt());
				stmt.setString(3, pb.getMota());
				stmt.setInt(4, pb.getMapb());

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

	/**
	 * delete phongban
	 * 
	 * @param pb
	 * @return
	 */
	public boolean deletePB(phongban pb) {
		String sql = "delete from phongban where mapb = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, pb.getMapb());

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

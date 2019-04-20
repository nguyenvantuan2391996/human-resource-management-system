package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.phongban;
import hrm.entities.truongphong;

public class QlTruongPhongDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<truongphong> getArrTP(int page, String search) {
		ArrayList<truongphong> arrtp = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from truongphong, phongban ");
		sql.append("where truongphong.mapb = phongban.mapb ");

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
					truongphong tp = new truongphong();
					tp.setMatp(Integer.valueOf(rs.getString("matp")));
					tp.setMapb(Integer.valueOf(rs.getString("mapb")));
					tp.setHoten(rs.getString("hoten"));
					tp.setNamsinh(rs.getShort("namsinh"));
					tp.setDiachi(rs.getString("diachi"));
					tp.setGioitinh(rs.getString("gioitinh"));
					tp.setSdt(rs.getString("sdt"));
					tp.setTenpb(rs.getString("tenphong"));

					arrtp.add(tp);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrtp;
	}

	public int getTotalPage(String search) {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(matp) as total from truongphong ");

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

	public boolean addTP(truongphong tp) {
		String sql = "insert into truongphong(matp, mapb, hoten, namsinh, diachi, gioitinh, sdt, tentk, matkhau) values(?,?,?,?,?,?,?,?,?)";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, tp.getMatp());
				stmt.setInt(2, tp.getMapb());
				stmt.setString(3, tp.getHoten());
				stmt.setInt(4, tp.getNamsinh());
				stmt.setString(5, tp.getDiachi());
				stmt.setString(6, tp.getGioitinh());
				stmt.setString(7, tp.getSdt());
				stmt.setString(8, tp.getTentk());
				stmt.setString(9, tp.getMatkhau());

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

	public boolean editTP(truongphong tp) {
		String sql = "update truongphong set mapb = ?, hoten = ?, namsinh = ?, diachi = ?, gioitinh = ?, sdt = ? where matp = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, tp.getMapb());
				stmt.setString(2, tp.getHoten());
				stmt.setInt(3, tp.getNamsinh());
				stmt.setString(4, tp.getDiachi());
				stmt.setString(5, tp.getGioitinh());
				stmt.setString(6, tp.getSdt());
				stmt.setInt(7, tp.getMatp());
				
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

	public boolean deleteTP(truongphong tp) {
		String sqlnv = "delete from nhanvien where matp = ?";
		String sqldg = "delete from danhgia where matp = ?";
		String sqltp = "delete from truongphong where matp = ?";
		conn = getConnectDB();

		if (conn != null) {
			try {
				conn.setAutoCommit(false);
				
				stmt = conn.prepareStatement(sqlnv);
				stmt.setInt(1, tp.getMatp());

				stmt.executeUpdate();
				
				stmt = conn.prepareStatement(sqldg);
				stmt.setInt(1, tp.getMatp());
				
				stmt.executeUpdate();
				
				stmt = conn.prepareStatement(sqltp);
				stmt.setInt(1, tp.getMatp());
				
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

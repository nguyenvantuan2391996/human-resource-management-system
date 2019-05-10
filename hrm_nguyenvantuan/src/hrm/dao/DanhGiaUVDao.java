package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.baocao;
import hrm.entities.danhgia;
import hrm.entities.ungvien;

public class DanhGiaUVDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<ungvien> getArrUV(int page, String search, int id) {
		ArrayList<ungvien> arruv = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from ungvien ");
		sql.append("left join danhgia on ungvien.mauv = danhgia.mauv ");
		sql.append("and danhgia.matp = " + id + " ");

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
					uv.setHoadong(rs.getFloat("danhgia.hoadong"));
					uv.setTrungthuc(rs.getFloat("danhgia.trungthuc"));
					uv.setXulytt(rs.getFloat("danhgia.xulytt"));
					uv.setGiaotiep(rs.getFloat("danhgia.giaotiep"));

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

		sql.append("select Count(id) as total from ungvien ");

		if (!"".equals(search)) {
			sql.append("and hoten like ? ");
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

	public boolean updateUV(danhgia dg) {
		StringBuilder sql = new StringBuilder();
		sql.append("update ungvien set hoadong = ?, trungthuc = ?, xulytt = ?, giaotiep = ? where mauv = ?");
		
		conn = getConnectDB();
		
		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());

				stmt.setFloat(1, dg.getHoadong());
				stmt.setFloat(2, dg.getTrungthuc());
				stmt.setFloat(3, dg.getXulytt());
				stmt.setFloat(4, dg.getGiaotiep());
				stmt.setInt(5, dg.getMauv());
				
				stmt.executeUpdate();
				
				return true;
				
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
				return false;
			}
		}
		
		return false;
	}
	
	public danhgia getDanhGiaAVG(danhgia dg) {
		danhgia avgDanhGia = new danhgia();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select mauv, AVG(hoadong) as hoadong, AVG(trungthuc) as trungthuc, AVG(xulytt) as xulytt, AVG(giaotiep) as giaotiep ");
		sql.append("from danhgia ");
		sql.append("where mauv = ? ");
		
		conn = getConnectDB();
		
		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());

				stmt.setInt(1, dg.getMauv());
				
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					avgDanhGia.setMauv(rs.getInt("mauv"));
					avgDanhGia.setHoadong(rs.getFloat("hoadong"));
					avgDanhGia.setTrungthuc(rs.getFloat("trungthuc"));
					avgDanhGia.setXulytt(rs.getFloat("xulytt"));
					avgDanhGia.setGiaotiep(rs.getFloat("giaotiep"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return avgDanhGia;
	}
	
	public boolean checkDG(danhgia dg) {
		String sql = "select * from danhgia where mauv = ? and matp = ? ";
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);

				stmt.setInt(1, dg.getMauv());
				stmt.setInt(2, dg.getMatp());

				rs = stmt.executeQuery();
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		return false;
	}

	public boolean editDG(danhgia dg) {
		String sql = "update danhgia set hoadong = ?, trungthuc = ?, xulytt = ?, giaotiep = ? where mauv = ? and matp = ? ";
		String sqladd = "insert into danhgia(hoadong, trungthuc, xulytt, giaotiep, mauv, matp) values(?,?,?,?,?,?) ";
		conn = getConnectDB();

		if (conn != null) {
			try {
				if (checkDG(dg)) {
					stmt = conn.prepareStatement(sql);
				} else {
					stmt = conn.prepareStatement(sqladd);
				}

				stmt.setFloat(1, dg.getHoadong());
				stmt.setFloat(2, dg.getTrungthuc());
				stmt.setFloat(3, dg.getXulytt());
				stmt.setFloat(4, dg.getGiaotiep());
				stmt.setInt(5, dg.getMauv());
				stmt.setInt(6, dg.getMatp());

				stmt.executeUpdate();
				
				// update tieu chi o bang ungvien
				danhgia avgDanhGia = getDanhGiaAVG(dg);
				updateUV(avgDanhGia);

				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			} finally {
				closeConnection();
			}
		}

		return false;
	}

}

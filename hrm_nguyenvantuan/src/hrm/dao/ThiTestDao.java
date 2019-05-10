package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.cauhoi;
import hrm.entities.dapantraloi;

public class ThiTestDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public boolean checkTest(int mauv) {
		String sql = "select * from dapantraloi where mauv = ? ";

		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, mauv);

				rs = stmt.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (Exception e) {
				return false;
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return false;
	}

	public ArrayList<cauhoi> getArrCH(int page) {
		ArrayList<cauhoi> arrcauhoi = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from cauhoi ");

		if (page != 0) {
			sql.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());

				if (page != 0) {
					stmt.setInt(1, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					cauhoi ch = new cauhoi();
					ch.setMacauhoi(rs.getInt("macauhoi"));
					ch.setChude(rs.getString("chude"));
					ch.setCauhoi(rs.getString("cauhoi"));
					ch.setA(rs.getString("a"));
					ch.setB(rs.getString("b"));
					ch.setC(rs.getString("c"));
					ch.setD(rs.getString("d"));

					arrcauhoi.add(ch);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrcauhoi;
	}

	public boolean addDapAnTL(ArrayList<dapantraloi> arrdatl) {
		String sql = "insert into dapantraloi(macauhoi, mauv, traloi) values(?,?,?)";

		for (int i = 0; i < arrdatl.size(); i++) {
			conn = getConnectDB();

			if (conn != null) {
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, arrdatl.get(i).getMacauhoi());
					stmt.setInt(2, arrdatl.get(i).getMauv());
					stmt.setString(3, arrdatl.get(i).getTraloi());

					stmt.executeUpdate();

				} catch (Exception e) {
					return false;
				} finally {
					closeConnection();
				}
			}

		}

		return true;
	}

	public float getPoint(int mauv, String chude, int offset) {
		float point = 0f;
		int count = 0;
		ArrayList<String> arrtraloi = new ArrayList<>();
		ArrayList<String> arrdapan = new ArrayList<>();

		StringBuilder sqltraloi = new StringBuilder();
		sqltraloi.append("select traloi ");
		sqltraloi.append("from dapantraloi ");
		sqltraloi.append("where mauv = ? ");
		sqltraloi.append("limit ?,5 ");

		StringBuilder sqldapan = new StringBuilder();
		sqldapan.append("select dapan ");
		sqldapan.append("from cauhoi ");
		sqldapan.append("where cauhoi.chude = ? ");

		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sqltraloi.toString());
				stmt.setInt(1, mauv);
				stmt.setInt(2, offset);

				rs = stmt.executeQuery();

				while (rs.next()) {
					arrtraloi.add(rs.getString("traloi"));
				}

				stmt = conn.prepareStatement(sqldapan.toString());
				stmt.setString(1, chude);

				rs = stmt.executeQuery();

				while (rs.next()) {
					arrdapan.add(rs.getString("dapan"));
				}

				for (int i = 0; i < 5; i++) {
					if ((arrdapan.get(i)).equals(arrtraloi.get(i))) {
						count++;
					}
				}

				point = count * 2;
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}

		return point;
	}

	public ArrayList<Float> getArrPoint(int mauv) {
		ArrayList<Float> arrpoint = new ArrayList<>();

		arrpoint.add(getPoint(mauv, "Quản Trị Dự Án", 0));
		arrpoint.add(getPoint(mauv, "Phân Tích Thiết Kế Hệ Thống", 5));
		arrpoint.add(getPoint(mauv, "Ngoại Ngữ", 10));
		arrpoint.add(getPoint(mauv, "Tin Học", 15));
		arrpoint.add(getPoint(mauv, "CNTT", 20));

		StringBuilder sql = new StringBuilder();
		sql.append("update ungvien set quantri = ?, phantich = ?, ngoaingu = ?, tinhoc = ?, cntt = ? where mauv = ? ");

		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());

				for (int i = 0; i < arrpoint.size(); i++) {
					stmt.setFloat(i + 1, arrpoint.get(i));
				}
				stmt.setInt(6, mauv);

				stmt.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}

		return arrpoint;
	}
}

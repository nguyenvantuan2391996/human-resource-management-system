package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.io.File;
import javax.swing.JFileChooser;
import hrm.entities.tienluong;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TienLuongDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<Float> getArrSoGioOT(int page, String search, int id) {
		ArrayList<Float> arrsogioot = new ArrayList<>();

		StringBuilder sqlot = new StringBuilder();
		sqlot.append("select nhanvien.manv, nhanvien.hoten, sum(sogioot) as sogioot ");
		sqlot.append("from nhanvien left join ot on nhanvien.manv = ot.manv ");
		sqlot.append("group by nhanvien.manv ");

		if (page != 0) {
			sqlot.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sqlot.toString());

				if (page != 0) {
					stmt.setInt(1, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					Float sogioot = 0f;
					if (rs.getString("sogioot") != null) {
						sogioot = Float.valueOf(rs.getString("sogioot"));
					}
					arrsogioot.add(sogioot);
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrsogioot;
	}

	public ArrayList<Float> getArrSoNgayNghi(int page, String search, int id) {
		ArrayList<Float> arrsongaynghi = new ArrayList<>();

		StringBuilder sqlnp = new StringBuilder();
		sqlnp.append("select nhanvien.manv, nhanvien.hoten, sum(sobuoi) as songaynghi ");
		sqlnp.append("from nhanvien left join nghiphep on nhanvien.manv = nghiphep.manv ");
		sqlnp.append("group by nhanvien.manv ");

		if (page != 0) {
			sqlnp.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sqlnp.toString());

				if (page != 0) {
					stmt.setInt(1, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					float songaynghi = 0f;
					if (rs.getString("songaynghi") != null) {
						songaynghi = Float.valueOf(rs.getString("songaynghi"));
					}

					arrsongaynghi.add(songaynghi);
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrsongaynghi;
	}

	public ArrayList<Float> getArrSoGioCong(int page, String search, int id) {
		ArrayList<Float> arrsogiocong = new ArrayList<>();

		StringBuilder sqlchamcong = new StringBuilder();
		sqlchamcong.append("select nhanvien.manv, nhanvien.hoten, sum(socong) as sogiocong ");
		sqlchamcong.append("from nhanvien left join chamcong on nhanvien.manv = chamcong.manv ");
		sqlchamcong.append("group by nhanvien.manv ");

		if (page != 0) {
			sqlchamcong.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sqlchamcong.toString());

				if (page != 0) {
					stmt.setInt(1, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					Float sogiocong = 0f;
					if (rs.getString("sogiocong") != null) {
						sogiocong = Float.valueOf(rs.getString("sogiocong"));
					}

					arrsogiocong.add(sogiocong);
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrsogiocong;
	}

	public ArrayList<tienluong> getArrTL(int page, String search, int id) {
		ArrayList<tienluong> arrtl = new ArrayList<>();

		StringBuilder sqlluong = new StringBuilder();
		sqlluong.append("select * from nhanvien, luong, tiengnhat ");
		sqlluong.append("where nhanvien.manv = luong.manv and luong.matn = tiengnhat.matn ");
		sqlluong.append("group by nhanvien.manv ");

		if (!"".equals(search)) {
			// sql.append("and duan.tenduan like ? ");
		}
		if (page != 0) {
			sqlluong.append("limit ?,5");
		}
		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sqlluong.toString());

				if (page != 0) {
					stmt.setInt(1, (page - 1) * 5);
				}
				rs = stmt.executeQuery();

				while (rs.next()) {
					tienluong tl = new tienluong();
					tl.setManv(Integer.valueOf(rs.getString("manv")));
					tl.setHoten(rs.getString("hoten"));
					tl.setTrinhdo(rs.getString("trinhdo"));
					tl.setHesoluong(Float.valueOf(rs.getString("hesoluong")));
					tl.setTongluong(Float.valueOf(rs.getString("tongluong")));
					tl.setTientrocap(Float.valueOf(rs.getString("tientrocap")));

					arrtl.add(tl);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return arrtl;
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

	public boolean checkTL() {
		ArrayList<tienluong> arrtl = getArrTL(0, "", 0);
		ArrayList<Float> arrsogiocong = getArrSoGioCong(0, "", 0);
		ArrayList<Float> arrsogioot = getArrSoGioOT(0, "", 0);
		float tongluong = 0f;

		for (int i = 0; i < arrtl.size(); i++) {
			tongluong = arrtl.get(i).getHesoluong() * (arrsogiocong.get(i) + arrsogioot.get(i))
					+ arrtl.get(i).getTientrocap();

			String sql = "update luong set tongluong = ? where manv = ?";
			conn = getConnectDB();

			if (conn != null) {
				try {
					stmt = conn.prepareStatement(sql);

					stmt.setFloat(1, tongluong);
					stmt.setInt(2, arrtl.get(i).getManv());

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

	public boolean checkExportFile() {
		ArrayList<tienluong> arrtl = getArrTL(0, "", 0);
		ArrayList<Float> arrsogiocong = getArrSoGioCong(0, "", 0);
		ArrayList<Float> arrsogioot = getArrSoGioOT(0, "", 0);
		ArrayList<Float> arrsongaynghi = getArrSoNgayNghi(0, "", 0);

		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();

			try {
				WritableWorkbook wb = Workbook.createWorkbook(file);
				WritableSheet st = wb.createSheet("Report", 0);

				st.addCell(new Label(5, 0, "Bảng Lương Nhân Viên"));

				st.addCell(new Label(0, 2, "ID"));
				st.addCell(new Label(1, 2, "Họ & Tên"));
				st.addCell(new Label(2, 2, "Trình Độ"));
				st.addCell(new Label(3, 2, "Lương Cơ Bản"));
				st.addCell(new Label(4, 2, "Số Giờ Công"));
				st.addCell(new Label(5, 2, "Số Giờ OT"));
				st.addCell(new Label(6, 2, "Số Ngày Nghỉ"));
				st.addCell(new Label(7, 2, "Tổng Lương"));

				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(0, j + 3, String.valueOf(arrtl.get(j).getManv())));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(1, j + 3, arrtl.get(j).getHoten()));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(2, j + 3, arrtl.get(j).getTrinhdo()));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(3, j + 3, String.valueOf(arrtl.get(j).getHesoluong())));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(4, j + 3, String.valueOf(arrsogiocong.get(j))));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(5, j + 3, String.valueOf(arrsogioot.get(j))));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(6, j + 3, String.valueOf(arrsongaynghi.get(j))));
				}
				for (int j = 0; j < arrtl.size(); j++) {
					st.addCell(new Label(7, j + 3, String.valueOf(arrtl.get(j).getTongluong())));
				}

				wb.write();
				wb.close();
				return true;
			} catch (Exception e) {
				return false;
				// TODO: handle exception
			}
		}
		return false;
	}
}

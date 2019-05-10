package hrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hrm.entities.ungvien;

public class TuVanDao extends connectDB {
	private PreparedStatement stmt;
	private ResultSet rs;

	public ArrayList<ungvien> getArrayUV(int page, String type) {
		ArrayList<ungvien> arruv = new ArrayList<>();
		StringBuilder sql = new StringBuilder();

		sql.append("select * from ungvien ");

		if ("order by".equals(type)) {
			sql.append("where 1=1 ");
			sql.append("order by C DESC ");
		}

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
					ungvien uv = new ungvien();
					uv.setMauv(rs.getInt("mauv"));
					uv.setHoten(rs.getString("hoten"));
					uv.setHoadong(rs.getFloat("hoadong"));
					uv.setTrungthuc(rs.getFloat("trungthuc"));
					uv.setXulytt(rs.getFloat("xulytt"));
					uv.setGiaotiep(rs.getFloat("giaotiep"));
					uv.setQuantri(rs.getFloat("quantri"));
					uv.setPhantich(rs.getFloat("phantich"));
					uv.setNgoaingu(rs.getFloat("ngoaingu"));
					uv.setTinhoc(rs.getFloat("tinhoc"));
					uv.setCntt(rs.getFloat("cntt"));
					uv.setDotuongtu(rs.getDouble("C"));

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

	public int getTotalPage() {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(mauv) as total from ungvien ");

		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());
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

	public int getRowTotal() {
		int total = 0;
		StringBuilder sql = new StringBuilder();

		sql.append("select Count(mauv) as total from ungvien ");

		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				if (rs.next()) {
					total = Integer.valueOf(rs.getString("total"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return total;
	}

	public Float[][] getData(int row) {
		Float data[][] = new Float[row][9];
		StringBuilder sql = new StringBuilder();

		sql.append("select * from ungvien ");

		conn = getConnectDB();

		if (conn != null) {
			try {
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();

				for (int i = 0; i < row; i++) {
					rs.next();
					data[i][0] = rs.getFloat("hoadong");
					data[i][1] = rs.getFloat("trungthuc");
					data[i][2] = rs.getFloat("quantri");
					data[i][3] = rs.getFloat("phantich");
					data[i][4] = rs.getFloat("ngoaingu");
					data[i][5] = rs.getFloat("tinhoc");
					data[i][6] = rs.getFloat("cntt");
					data[i][7] = rs.getFloat("xulytt");
					data[i][8] = rs.getFloat("giaotiep");

				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				closeConnection();
			}
		}
		return data;
	}

	public Float[][] standardize(Float[][] data) {
		Float dataStandardize[][] = new Float[data.length][data[0].length];
		Double tongbp[] = new Double[data[0].length];
		for (int i = 0; i < tongbp.length; i++) {
			tongbp[i] = 0d;
		}

		for (int i = 0; i < data[0].length; i++) {
			for (int j = 0; j < data.length; j++) {
				tongbp[i] += Math.pow(data[j][i], 2);
			}
			tongbp[i] = Math.sqrt(tongbp[i]);
		}

		for (int i = 0; i < data[0].length; i++) {
			for (int j = 0; j < data.length; j++) {
				dataStandardize[j][i] = (float) (data[j][i] / tongbp[i]);
			}
		}

		return dataStandardize;
	}

	public Float[][] weightedMatrix(Float[][] data, ArrayList<Double> arrtrongso) {
		Float dataWeightedMatrix[][] = new Float[data.length][data[0].length];

		for (int i = 0; i < data[0].length; i++) {
			for (int j = 0; j < data.length; j++) {
				dataWeightedMatrix[j][i] = (float) (data[j][i] * arrtrongso.get(i));
			}
		}

		return dataWeightedMatrix;
	}

	public Float[][] idealSolution(Float[][] data) {
		Float A[][] = new Float[2][data[0].length];

		for (int i = 0; i < data[0].length; i++) {

			float max = data[0][i];
			float min = data[0][i];

			for (int j = 0; j < data.length; j++) {

				if (data[j][i] > max) {
					max = data[j][i];
				}

				if (data[j][i] < min) {
					min = data[j][i];
				}

				A[0][i] = max;
				A[1][i] = min;
			}
		}

		return A;
	}

	public Double[][] distanceIdealSolution(Float[][] data, Float[][] A) {
		Double S[][] = new Double[2][data.length];

		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S[0].length; j++) {
				S[i][j] = 0d;
			}
		}

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				S[0][i] += Math.pow(data[i][j] - A[0][j], 2);
				S[1][i] += Math.pow(data[i][j] - A[1][j], 2);
			}
			S[0][i] = Math.sqrt(S[0][i]);
			S[1][i] = Math.sqrt(S[1][i]);
		}

		return S;
	}

	public Double[] calculateC(Double[][] S, int row) {
		Double C[] = new Double[row];

		for (int i = 0; i < S[0].length; i++) {
			C[i] = S[1][i] / (S[0][i] + S[1][i]);
		}

		return C;
	}

	public boolean checkUpdateC(Double[] C) {
		for (int i = 0; i < C.length; i++) {

			String sql = "update ungvien set C = ? where mauv = ?";
			conn = getConnectDB();

			if (conn != null) {
				try {

					stmt = conn.prepareStatement(sql);
					stmt.setDouble(1, C[i]);
					stmt.setInt(2, i + 1);

					stmt.executeUpdate();

				} catch (Exception e) {
					// TODO: handle exception
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		TuVanDao a = new TuVanDao();
		ArrayList<Double> arrtrongso = new ArrayList<>();
		arrtrongso.add(0.1);
		arrtrongso.add(0.1);
		arrtrongso.add(0.1);
		arrtrongso.add(0.1);
		arrtrongso.add(0.1);
		arrtrongso.add(0.1);
		arrtrongso.add(0.1);
		arrtrongso.add(0.15);
		arrtrongso.add(0.15);

		Double C[] = new Double[3];
		Double S[][] = new Double[2][3];
		Float gplytuong[][] = new Float[2][9];
		Float data[][] = new Float[3][9];
		Float dataStandardize[][] = new Float[3][9];
		Float dataWeightedMatrix[][] = new Float[3][9];
		data = a.getData(3);
		dataStandardize = a.standardize(data);
		dataWeightedMatrix = a.weightedMatrix(dataStandardize, arrtrongso);
		gplytuong = a.idealSolution(dataWeightedMatrix);
		S = a.distanceIdealSolution(dataWeightedMatrix, gplytuong);
		C = a.calculateC(S, 3);

		for (int j = 0; j < 3; j++) {
			System.out.print(C[j] + " ");
		}
		System.out.println();

		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S[0].length; j++) {
				System.out.print(S[i][j] + " ");
			}
			System.out.println();
		}
	}

}

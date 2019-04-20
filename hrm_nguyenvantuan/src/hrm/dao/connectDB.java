package hrm.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	protected Connection conn = null; // tạo biến Connection

	/**
	 * kết nối Database
	 * 
	 * @return conn
	 */
	public Connection getConnectDB() {
		String url = "jdbc:mysql://localhost:3306/hrm?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String pass = "";
		String classforname = "com.mysql.jdbc.Driver";
		try {
			Class.forName(classforname);
			conn = DriverManager.getConnection(url, user, pass); // kết nối Database
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; // trả về conn
	}
	
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void rollback() {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

package hrm.logic;

import hrm.dao.LoginDao;
import hrm.entities.quanly;

public class LoginLogic {
	
	public String validateLogin(String username, String password) {
		String error = null;
		quanly ql;
		LoginDao lgDao = new LoginDao();
		
		ql = lgDao.getQuanLy(username, password);
		if(ql == null) {
			error = "Tài khoản hoặc mật khẩu không đúng !";
		}
		return error;
	}
}

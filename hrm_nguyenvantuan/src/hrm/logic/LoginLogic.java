package hrm.logic;

import java.util.ArrayList;

import hrm.dao.LoginDao;
import hrm.entities.*;

public class LoginLogic {
	protected LoginDao lgDao = new LoginDao();

	public ArrayList<String> validateLogin(String username, String password) {
		ArrayList<String> msg = new ArrayList<>();
		quanly ql;
		nhanvien nv;

		ql = lgDao.getQuanLy(username, password);
		nv = lgDao.getNhanVien(username, password);

		if (ql == null && nv == null) {
			msg.add("Tài khoản hoặc mật khẩu không đúng !");
			return msg;
		} else if (ql != null) {
			msg.add(String.valueOf(ql.getMaql()));
			msg.add(ql.getLoaitk());
			return msg;
		} else if (nv != null) {
			msg.add(String.valueOf(nv.getManv()));
			msg.add(nv.getLoaitk());
			return msg;
		}
		return msg;
	}
}

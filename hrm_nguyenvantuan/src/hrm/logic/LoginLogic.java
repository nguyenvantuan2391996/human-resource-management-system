package hrm.logic;

import java.util.ArrayList;

import hrm.dao.LoginDao;
import hrm.entities.nhanvien;
import hrm.entities.quanly;
import hrm.entities.truongphong;
import hrm.entities.ungvien;

public class LoginLogic {
	protected LoginDao lgDao = new LoginDao();

	public ArrayList<String> validateLogin(String username, String password) {
		ArrayList<String> msg = new ArrayList<>();
		quanly ql;
		nhanvien nv;
		truongphong tp;
		ungvien uv;
		
		ql = lgDao.getQuanLy(username, password);
		nv = lgDao.getNhanVien(username, password);
		tp = lgDao.getTruongPhong(username, password);
		uv = lgDao.getUngVien(username, password);

		if (ql == null && nv == null && tp == null && uv == null) {
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
		} else if (tp != null) {
			msg.add(String.valueOf(tp.getMatp()));
			msg.add(tp.getLoaitk());
			return msg;
		} else if (uv != null) {
			msg.add(String.valueOf(uv.getMauv()));
			msg.add(uv.getLoaitk());
			return msg;
		}
		return msg;
	}
}

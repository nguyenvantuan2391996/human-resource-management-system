package hrm.logic;

import java.util.ArrayList;

import hrm.dao.QlUngVienDao;
import hrm.entities.truongphong;
import hrm.entities.ungvien;


public class QlUngVienLogic {
	protected QlUngVienDao uvDao = new QlUngVienDao();

	public ArrayList<ungvien> getArrUV(int page, String search) {
		ArrayList<ungvien> arruv = new ArrayList<>();
		arruv = uvDao.getArrUV(page, search);
		return arruv;
	}
	
	public ArrayList<Integer> getTotalPage(String search) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = uvDao.getTotalPage(search);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}
	
	public boolean checkAddUV(ungvien uv) {
		boolean msgCheck;

		if (uvDao.addUV(uv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkEditUV(ungvien uv) {
		boolean msgCheck;

		if (uvDao.editUV(uv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkDeleteUV(ungvien uv) {
		boolean msgCheck;
		if (uvDao.deleteUV(uv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

}

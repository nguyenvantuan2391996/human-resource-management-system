package hrm.logic;

import java.util.ArrayList;

import hrm.dao.QlTruongPhongDao;
import hrm.entities.phongban;
import hrm.entities.truongphong;

public class QlTruongPhongLogic {
	protected QlTruongPhongDao tpDao = new QlTruongPhongDao();

	public ArrayList<truongphong> getArrTP(int page, String search) {
		ArrayList<truongphong> arrtp = new ArrayList<>();
		arrtp = tpDao.getArrTP(page, search);
		return arrtp;
	}
	
	public ArrayList<Integer> getTotalPage(String search) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = tpDao.getTotalPage(search);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}
	
	public boolean checkAddTP(truongphong tp) {
		boolean msgCheck;

		if (tpDao.addTP(tp)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkEditTP(truongphong tp) {
		boolean msgCheck;

		if (tpDao.editTP(tp)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkDeleteTP(truongphong tp) {
		boolean msgCheck;
		if (tpDao.deleteTP(tp)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

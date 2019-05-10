package hrm.logic;

import java.util.ArrayList;

import hrm.dao.BaoCaoDao;
import hrm.entities.baocao;
import hrm.entities.truongphong;

public class BaoCaoLogic {
	BaoCaoDao bcDao = new BaoCaoDao();

	public ArrayList<baocao> getArrBC(int page, String search, int id, String type) {
		ArrayList<baocao> arrbc = new ArrayList<>();
		arrbc = bcDao.getArrBC(page, search, id, type);
		return arrbc;
	}

	public ArrayList<Integer> getTotalPage(String search, int id, String type) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = bcDao.getTotalPage(search, id, type);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}

	public boolean checkAddBC(baocao bc) {
		boolean msgCheck;

		if (bcDao.addBC(bc)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

	public boolean checkEditBC(baocao bc) {
		boolean msgCheck;

		if (bcDao.editBC(bc)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

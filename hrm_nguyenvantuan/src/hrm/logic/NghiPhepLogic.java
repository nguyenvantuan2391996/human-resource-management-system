package hrm.logic;

import java.util.ArrayList;

import hrm.dao.NghiPhepDao;
import hrm.entities.nghiphep;

public class NghiPhepLogic {
	protected NghiPhepDao npDao = new NghiPhepDao();

	public ArrayList<nghiphep> getArrNP(int page, String search, int id) {
		ArrayList<nghiphep> arrnp = new ArrayList<>();
		arrnp = npDao.getArrNP(page, search, id);
		return arrnp;
	}

	public ArrayList<Integer> getTotalPage(String search, int id) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = npDao.getTotalPage(search, id);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}

	public boolean checkAddNP(nghiphep np) {
		boolean msgCheck;

		if (npDao.addNP(np)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

	public boolean checkEditNP(nghiphep np) {
		boolean msgCheck;

		if (npDao.editNP(np)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

package hrm.logic;

import java.util.ArrayList;

import hrm.dao.OtDao;
import hrm.entities.ot;

public class OtLogic {
	OtDao otDao = new OtDao();

	public ArrayList<ot> getArrOT(int page, String search, int id) {
		ArrayList<ot> arrot = new ArrayList<>();
		arrot = otDao.getArrOT(page, search, id);
		return arrot;
	}

	public ArrayList<Integer> getTotalPage(String search, int id) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = otDao.getTotalPage(search, id);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}

	public boolean checkAddOT(ot ot) {
		boolean msgCheck;

		if (otDao.addOT(ot)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

	public boolean checkEditOT(ot ot) {
		boolean msgCheck;

		if (otDao.editOT(ot)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

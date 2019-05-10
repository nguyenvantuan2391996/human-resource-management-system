package hrm.logic;

import java.util.ArrayList;

import hrm.dao.TienLuongDao;
import hrm.entities.tienluong;

public class TienLuongLogic {
	TienLuongDao tlDao = new TienLuongDao();
	
	public ArrayList<Float> getArrSoGioOT(int page, String search, int id) {
		ArrayList<Float> arrsogioot = new ArrayList<>();
		arrsogioot = tlDao.getArrSoGioOT(page, search, id);
		return arrsogioot;
	}
	
	public ArrayList<Float> getArrSoNgayNghi(int page, String search, int id) {
		ArrayList<Float> arrsongaynghi = new ArrayList<>();
		arrsongaynghi = tlDao.getArrSoNgayNghi(page, search, id);
		return arrsongaynghi;
	}
	
	public ArrayList<Float> getArrSoGioCong(int page, String search, int id) {
		ArrayList<Float> arrsogiocong = new ArrayList<>();
		arrsogiocong = tlDao.getArrSoGioCong(page, search, id);
		return arrsogiocong;
	}

	public ArrayList<tienluong> getArrTL(int page, String search, int id) {
		ArrayList<tienluong> arrtl = new ArrayList<>();
		arrtl = tlDao.getArrTL(page, search, id);
		return arrtl;
	}

	public ArrayList<Integer> getTotalPage(String search, int id) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = tlDao.getTotalPage(search, id);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}
	
	public boolean checkTL() {
		boolean msgCheck;

		if (tlDao.checkTL()) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkExportFile() {
		boolean msgCheck;

		if (tlDao.checkExportFile()) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkConfirm(int id) {
		boolean msgCheck;

		if (tlDao.checkConfirm(id)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

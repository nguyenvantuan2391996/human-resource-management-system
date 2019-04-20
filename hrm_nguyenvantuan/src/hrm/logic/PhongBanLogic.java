package hrm.logic;

import java.util.ArrayList;

import hrm.dao.PhongBanDao;
import hrm.entities.phongban;

public class PhongBanLogic {
	protected PhongBanDao pbDao = new PhongBanDao();

	/**
	 * Get list phong ban
	 * 
	 * @param page
	 * @return
	 */
	public ArrayList<phongban> getArrayPb(int page, String search) {
		ArrayList<phongban> arrpb = new ArrayList<>();

		arrpb = pbDao.getArrayPb(page, search);
		return arrpb;
	}

	/**
	 * get list page
	 * 
	 * @return
	 */
	public ArrayList<Integer> getListPage(String search) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = pbDao.getTotalPage(search);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}

	/**
	 * check add phongban
	 * 
	 * @param pb
	 * @return
	 */
	public boolean checkAddPB(phongban pb) {
		boolean msgCheck;

		if (pbDao.addPB(pb)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

	/**
	 * check edit phonban
	 * 
	 * @param pb
	 * @return
	 */
	public boolean checkEditPB(phongban pb) {
		boolean msgCheck;
		if (pbDao.editPB(pb)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

	/**
	 * check delet phonban
	 * 
	 * @param pb
	 * @return
	 */
	public boolean checkDeletePB(phongban pb) {
		boolean msgCheck;
		if (pbDao.deletePB(pb)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

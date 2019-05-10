package hrm.logic;

import java.util.ArrayList;

import hrm.dao.DanhGiaUVDao;
import hrm.entities.baocao;
import hrm.entities.danhgia;
import hrm.entities.ungvien;

public class DanhGiaUVLogic {
	DanhGiaUVDao uvDao = new DanhGiaUVDao();

	public ArrayList<ungvien> getArrUV(int page, String search, int id) {
		ArrayList<ungvien> arruv = new ArrayList<>();
		arruv = uvDao.getArrUV(page, search, id);
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
	
	public boolean checkEditDG(danhgia dg) {
		boolean msgCheck;

		if (uvDao.editDG(dg)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
}

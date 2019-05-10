package hrm.logic;

import java.util.ArrayList;

import hrm.dao.QlNhanVienDao;
import hrm.entities.duan;
import hrm.entities.nhanvien;
import hrm.entities.tiengnhat;
import hrm.entities.truongphong;

public class QlNhanVienLogic {
	protected QlNhanVienDao nvDao = new QlNhanVienDao();

	public ArrayList<nhanvien> getArrNV(int page, String search, int id) {
		ArrayList<nhanvien> arrnv = new ArrayList<>();
		arrnv = nvDao.getArrNV(page, search, id);
		return arrnv;
	}
	
	public ArrayList<tiengnhat> getArrTN() {
		ArrayList<tiengnhat> arrtn = new ArrayList<>();
		arrtn = nvDao.getArrTN();
		return arrtn;
	}
	
	public ArrayList<duan> getArrDA() {
		ArrayList<duan> arrduan = new ArrayList<>();
		arrduan = nvDao.getArrDA();
		return arrduan;
	}
	
	public ArrayList<Integer> getTotalPage(String search, int id) {
		ArrayList<Integer> list = new ArrayList<>();
		int total = nvDao.getTotalPage(search, id);
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		return list;
	}
	
	public boolean checkAddNV(nhanvien nv) {
		boolean msgCheck;

		if (nvDao.addNV(nv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkEditNV(nhanvien nv) {
		boolean msgCheck;

		if (nvDao.editNV(nv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkDeleteNV(nhanvien nv) {
		boolean msgCheck;
		if (nvDao.deleteNV(nv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}
	
	public boolean checkTPEditNV(nhanvien nv) {
		boolean msgCheck;

		if (nvDao.tpEditNV(nv)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

}

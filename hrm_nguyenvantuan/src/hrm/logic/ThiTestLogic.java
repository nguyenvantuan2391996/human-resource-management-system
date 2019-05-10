package hrm.logic;

import java.util.ArrayList;
import com.mysql.fabric.xmlrpc.base.Array;

import hrm.dao.ThiTestDao;
import hrm.entities.cauhoi;
import hrm.entities.dapantraloi;

public class ThiTestLogic {
	ThiTestDao ttDao = new ThiTestDao();

	public String checkTest(int mauv) {
		String msgCheck = null;

		if (ttDao.checkTest(mauv)) {
			msgCheck = "Bạn đã hoàn thành bài thi trước đó ! Xin vui lòng chờ kết quả đánh giá tuyển dụng của chúng tôi";
		}
		return msgCheck;
	}

	public ArrayList<cauhoi> getArrCH(int page) {
		ArrayList<cauhoi> arrcauhoi = new ArrayList<>();
		arrcauhoi = ttDao.getArrCH(page);
		return arrcauhoi;
	}

	public boolean addDapAnTL(ArrayList<dapantraloi> arrdatl) {
		boolean msgCheck;

		if (ttDao.addDapAnTL(arrdatl)) {
			msgCheck = true;
		} else {
			msgCheck = false;
		}
		return msgCheck;
	}

	public ArrayList<Float> getArrPoint(int mauv) {
		ArrayList<Float> arrpoint = new ArrayList<>();
		arrpoint = ttDao.getArrPoint(mauv);
		return arrpoint;
	}
}

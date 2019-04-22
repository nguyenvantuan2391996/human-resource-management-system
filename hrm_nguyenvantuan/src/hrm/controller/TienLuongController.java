package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.baocao;
import hrm.entities.nhanvien;
import hrm.entities.tienluong;
import hrm.logic.QlNhanVienLogic;
import hrm.logic.TienLuongLogic;

/**
 * Servlet implementation class TienLuongController
 */
@WebServlet("/TienLuongController")
public class TienLuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected TienLuongLogic tlLogic = new TienLuongLogic();
	protected QlNhanVienLogic nvLogic = new QlNhanVienLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TienLuongController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int id = 0;
		ArrayList<Integer> listPage = new ArrayList<>();
		String search = request.getParameter("search");

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (search == null) {
			search = "";
		}

		ArrayList<Float> arrsogioot = new ArrayList<>();
		arrsogioot = tlLogic.getArrSoGioOT(page, search, id);

		ArrayList<Float> arrsongaynghi = new ArrayList<>();
		arrsongaynghi = tlLogic.getArrSoNgayNghi(page, search, id);

		ArrayList<Float> arrsogiocong = new ArrayList<>();
		arrsogiocong = tlLogic.getArrSoGioCong(page, search, id);

		ArrayList<tienluong> arrtl = new ArrayList<>();
		arrtl = tlLogic.getArrTL(page, search, id);
		listPage = tlLogic.getTotalPage(search, id);

		for (int i = 0; i < arrtl.size(); i++) {
			arrtl.get(i).setSogiocong(arrsogiocong.get(i));
			arrtl.get(i).setSogioot(arrsogioot.get(i));
			arrtl.get(i).setSongaynghi(arrsongaynghi.get(i));
		}

		// send request
		request.setAttribute("arrtl", arrtl);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		// forward to qltruongphong.jsp
		request.getRequestDispatcher("jsp/tienluong.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type"); // type : add, edit
		String msg = null; // message notice

		if ("tinhluong".equals(type)) {

			if (tlLogic.checkTL()) {
				msg = "Hoàn thành";
			} else {
				msg = "Thất bại ! Xin vui lòng thử lại";
			}
		}

		if ("xuatbc".equals(type)) {
			if (tlLogic.checkExportFile()) {
				msg = "Export file hoàn thành";
			} else {
				msg = "Thất bại ! Xin vui lòng thử lại";
			}
		}

		// send request
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}

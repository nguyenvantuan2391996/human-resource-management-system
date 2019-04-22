package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.ot;
import hrm.logic.OtLogic;


/**
 * Servlet implementation class DangKyOtController
 */
@WebServlet("/DangKyOtController")
public class DangKyOtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      protected OtLogic otLogic = new OtLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyOtController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int page = 1;
		ArrayList<Integer> listPage = new ArrayList<>();
		String search = request.getParameter("search");
		int id = Integer.parseInt((String) session.getAttribute("id"));

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (search == null) {
			search = "";
		}

		ArrayList<ot> arrot = new ArrayList<>();
		arrot = otLogic.getArrOT(page, search, id);
		listPage = otLogic.getTotalPage(search, id);

		// send request
		request.setAttribute("arrot", arrot);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		// forward to qltruongphong.jsp
		request.getRequestDispatcher("jsp/dangkyot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ot ot = new ot();
		String type = request.getParameter("type"); // type : add, edit
		String msg = null; // message notice
		
		if ("add".equals(type)) {
			ot.setManv(Integer.parseInt((String) session.getAttribute("id")));
			ot.setSogioot(Integer.valueOf(request.getParameter("sogiootadd")));
			ot.setNgayot(request.getParameter("ngayotadd"));
			ot.setLydo(request.getParameter("lydoadd"));

			if (otLogic.checkAddOT(ot)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}

		if ("edit".equals(type)) {
			ot.setId(Integer.valueOf(request.getParameter("maot")));
			ot.setManv(Integer.parseInt((String) session.getAttribute("id")));
			ot.setSogioot(Integer.valueOf(request.getParameter("sogiootedit")));
			ot.setNgayot(request.getParameter("ngayotedit"));
			ot.setLydo(request.getParameter("lydoedit"));

			if (otLogic.checkEditOT(ot)) {
				msg = "Sửa thành công";
			} else {
				msg = "Sửa thất bại";
			}
		}
		
		// send request
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}

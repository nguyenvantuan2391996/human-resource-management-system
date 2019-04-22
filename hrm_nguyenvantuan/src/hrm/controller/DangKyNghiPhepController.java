package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.nghiphep;
import hrm.logic.NghiPhepLogic;

/**
 * Servlet implementation class DangKyNghiPhepController
 */
@WebServlet("/DangKyNghiPhepController")
public class DangKyNghiPhepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected NghiPhepLogic npLogic = new NghiPhepLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyNghiPhepController() {
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

		ArrayList<nghiphep> arrnp = new ArrayList<>();
		arrnp = npLogic.getArrNP(page, search, id);
		listPage = npLogic.getTotalPage(search, id);

		// send request
		request.setAttribute("arrnp", arrnp);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		// forward to qltruongphong.jsp
		request.getRequestDispatcher("jsp/dangkynghiphep.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		nghiphep np = new nghiphep();
		String type = request.getParameter("type"); // type : add, edit
		String msg = null; // message notice

		if ("add".equals(type)) {
			np.setManv(Integer.parseInt((String) session.getAttribute("id")));
			np.setLydo(request.getParameter("lydoadd"));
			np.setNgaynghi(request.getParameter("ngaynghiadd"));
			np.setLoainghiphep(request.getParameter("loainghiphep"));

			if (npLogic.checkAddNP(np)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}

		if ("edit".equals(type)) {
			np.setId(Integer.valueOf(request.getParameter("manp")));
			np.setManv(Integer.parseInt((String) session.getAttribute("id")));
			np.setLydo(request.getParameter("lydoedit"));
			np.setNgaynghi(request.getParameter("ngaynghiedit"));
			np.setLoainghiphep(request.getParameter("loainghiphep"));

			if (npLogic.checkEditNP(np)) {
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

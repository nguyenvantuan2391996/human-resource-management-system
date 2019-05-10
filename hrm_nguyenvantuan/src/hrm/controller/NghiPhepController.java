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
 * Servlet implementation class NghiPhepController
 */
@WebServlet("/NghiPhepController")
public class NghiPhepController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected NghiPhepLogic npLogic = new NghiPhepLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NghiPhepController() {
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
		int id = 0;
		String type = null;

		if (session.getAttribute("manv") != null) {
			id = Integer.parseInt((String) session.getAttribute("manv"));
			type = "nhanvien";
		}
		if (session.getAttribute("matp") != null) {
			id = Integer.parseInt((String) session.getAttribute("matp"));
			type = "truongphong";
		}

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (search == null) {
			search = "";
		}

		ArrayList<nghiphep> arrnp = new ArrayList<>();
		arrnp = npLogic.getArrNP(page, search, id, type);
		listPage = npLogic.getTotalPage(search, id, type);

		// send request
		request.setAttribute("arrnp", arrnp);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		if ("truongphong".equals(type)) {
			// forward to nghiphep.jsp
			request.getRequestDispatcher("jsp/nghiphep.jsp").forward(request, response);
		}
		if ("nhanvien".equals(type)) {
			// forward to dangkynghiphep.jsp
			request.getRequestDispatcher("jsp/dangkynghiphep.jsp").forward(request, response);
		}

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
		int id = 0;

		if (request.getParameter("id") != null) {
			id = Integer.valueOf(request.getParameter("id")); // ma nghi phep
		}

		if ("add".equals(type)) {
			np.setManv(Integer.parseInt((String) session.getAttribute("manv")));
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
			np.setManv(Integer.parseInt((String) session.getAttribute("manv")));
			np.setLydo(request.getParameter("lydoedit"));
			np.setNgaynghi(request.getParameter("ngaynghiedit"));
			np.setLoainghiphep(request.getParameter("loainghiphep"));

			if (npLogic.checkEditNP(np)) {
				msg = "Sửa thành công";
			} else {
				msg = "Sửa thất bại";
			}
		}
		
		if ("Accept".equals(type)) {
			if (npLogic.checkConfirm(type, id)) {
				msg = "Đã đồng ý";
			}
		}
		if ("No Accept".equals(type)) {
			if (npLogic.checkConfirm(type, id)) {
				msg = "Đã không đồng ý";
			}
		}


		// send request
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}

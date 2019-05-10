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
import hrm.logic.BaoCaoLogic;

/**
 * Servlet implementation class BaoCaoController
 */
@WebServlet("/BaoCaoController")
public class BaoCaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected BaoCaoLogic bcLogic = new BaoCaoLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaoCaoController() {
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

		ArrayList<baocao> arrbc = new ArrayList<>();
		arrbc = bcLogic.getArrBC(page, search, id, type);
		listPage = bcLogic.getTotalPage(search, id, type);

		// send request
		request.setAttribute("arrbc", arrbc);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		if ("truongphong".equals(type)) {
			// forward to baocao.jsp
			request.getRequestDispatcher("jsp/baocao.jsp").forward(request, response);
		}
		if ("nhanvien".equals(type)) {
			// forward to baocaonv.jsp
			request.getRequestDispatcher("jsp/baocaonv.jsp").forward(request, response);
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
		baocao bc = new baocao();
		String type = request.getParameter("type"); // type : add, edit
		String msg = null; // message notice

		if ("add".equals(type)) {
			bc.setManv(Integer.parseInt((String) session.getAttribute("manv")));
			bc.setNdbc(request.getParameter("ndbcadd"));
			bc.setNgaybc(request.getParameter("ngaybcadd"));

			if (bcLogic.checkAddBC(bc)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}

		if ("edit".equals(type)) {
			bc.setId(Integer.valueOf(request.getParameter("mabc")));
			bc.setManv(Integer.parseInt((String) session.getAttribute("manv")));
			bc.setNdbc(request.getParameter("ndbcedit"));
			bc.setNgaybc(request.getParameter("ngaybcedit"));

			if (bcLogic.checkEditBC(bc)) {
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

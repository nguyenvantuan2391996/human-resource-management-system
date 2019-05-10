package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.danhgia;
import hrm.entities.ungvien;
import hrm.logic.DanhGiaUVLogic;

/**
 * Servlet implementation class DanhGiaUVController
 */
@WebServlet("/DanhGiaUVController")
public class DanhGiaUVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected DanhGiaUVLogic uvLogic = new DanhGiaUVLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhGiaUVController() {
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

		if (session.getAttribute("matp") != null) {
			id = Integer.parseInt((String) session.getAttribute("matp"));
		}

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (search == null) {
			search = "";
		}

		ArrayList<ungvien> arruv = new ArrayList<>();
		arruv = uvLogic.getArrUV(page, search, id);
		listPage = uvLogic.getTotalPage(search);

		// send request
		request.setAttribute("arruv", arruv);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		// forward to phongban.jsp
		request.getRequestDispatcher("jsp/danhgiaungvien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		danhgia dg = new danhgia();
		String type = request.getParameter("type"); // type : add, edit
		String msg = null; // message notice
		int id = 0;

		if (session.getAttribute("matp") != null) {
			id = Integer.parseInt((String) session.getAttribute("matp"));
		}

		if ("edit".equals(type)) {
			dg.setMauv(Integer.valueOf(request.getParameter("id")));
			dg.setHoadong(Float.valueOf(request.getParameter("hoadong")));
			dg.setTrungthuc(Float.valueOf(request.getParameter("trungthuc")));
			dg.setXulytt(Float.valueOf(request.getParameter("xulytt")));
			dg.setGiaotiep(Float.valueOf(request.getParameter("giaotiep")));
			dg.setMatp(id);

			if (uvLogic.checkEditDG(dg)) {
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

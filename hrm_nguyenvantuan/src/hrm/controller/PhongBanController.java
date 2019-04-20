package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrm.entities.*;
import hrm.logic.*;

/**
 * Servlet implementation class PhongBanController
 */
@WebServlet("/PhongBanController")
public class PhongBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected PhongBanLogic pblogic = new PhongBanLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhongBanController() {
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
		ArrayList<Integer> listPage = new ArrayList<>();
		String search = request.getParameter("search");

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (search == null) {
			search = "";
		}
		ArrayList<phongban> arrpb = new ArrayList<>();

		arrpb = pblogic.getArrayPb(page, search);
		listPage = pblogic.getListPage(search);

		// send request
		request.setAttribute("arrpb", arrpb);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		// forward to phongban.jsp
		request.getRequestDispatcher("jsp/phongban.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		phongban pb = new phongban();
		String type = request.getParameter("type"); // type : add, edit, delete
		String id = request.getParameter("id"); // id phongban
		String msg = null; // message notice

		if ("add".equals(type)) {
			pb.setTenpb(request.getParameter("tenphongadd"));
			pb.setSdt(request.getParameter("sdtadd"));
			pb.setMota(request.getParameter("motaadd"));

			if (pblogic.checkAddPB(pb)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}

		if ("edit".equals(type)) {
			pb.setMapb(Integer.valueOf(request.getParameter("id")));
			pb.setTenpb(request.getParameter("tenphongedit"));
			pb.setSdt(request.getParameter("sdtedit"));
			pb.setMota(request.getParameter("motaedit"));

			if (pblogic.checkEditPB(pb)) {
				msg = "Sửa thành công";
			} else {
				msg = "Sửa thất bại";
			}
		}

		if ("delete".equals(type)) {
			pb.setMapb(Integer.valueOf(request.getParameter("id")));

			if (pblogic.checkDeletePB(pb)) {
				msg = "Xóa thành công";
			} else {
				msg = "Xóa thất bại";
			}
		}
		// send request
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}

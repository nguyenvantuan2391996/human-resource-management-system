package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrm.entities.phongban;
import hrm.entities.truongphong;
import hrm.logic.PhongBanLogic;
import hrm.logic.QlTruongPhongLogic;

/**
 * Servlet implementation class TruongPhongController
 */
@WebServlet("/TruongPhongController")
public class QlTruongPhongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected QlTruongPhongLogic tplogic = new QlTruongPhongLogic();
	protected PhongBanLogic pbLogic = new PhongBanLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QlTruongPhongController() {
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

		ArrayList<truongphong> arrtp = new ArrayList<>();
		arrtp = tplogic.getArrTP(page, search);
		listPage = tplogic.getTotalPage(search);
		
		ArrayList<phongban> arrpb = new ArrayList<>();
		arrpb = pbLogic.getArrayPb(0, "");
		
		// send request
		request.setAttribute("arrtp", arrtp);
		request.setAttribute("page", page);
		request.setAttribute("arrpb", arrpb);

		// forward to qltruongphong.jsp
		request.getRequestDispatcher("jsp/qltruongphong.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		truongphong tp = new truongphong();
		String type = request.getParameter("type"); // type : add, edit, delete
		String msg = null; // message notice
		
		if ("add".equals(type)) {
			tp.setMapb(Integer.valueOf(request.getParameter("phongban")));
			tp.setHoten(request.getParameter("hotenadd"));
			tp.setNamsinh(Integer.valueOf(request.getParameter("namsinhadd")));
			tp.setDiachi(request.getParameter("diachiadd"));
			tp.setGioitinh(request.getParameter("gioitinhadd"));
			tp.setSdt(request.getParameter("sdtadd"));
			tp.setTentk(request.getParameter("taikhoanadd"));
			tp.setMatkhau(request.getParameter("matkhauadd"));

			if (tplogic.checkAddTP(tp)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}

		if ("edit".equals(type)) {
			tp.setMatp(Integer.valueOf(request.getParameter("id")));
			tp.setMapb(Integer.valueOf(request.getParameter("phongban")));
			tp.setHoten(request.getParameter("hotenedit"));
			tp.setNamsinh(Integer.valueOf(request.getParameter("namsinhedit")));
			tp.setDiachi(request.getParameter("diachiedit"));
			tp.setGioitinh(request.getParameter("gioitinhedit"));
			tp.setSdt(request.getParameter("sdtedit"));

			if (tplogic.checkEditTP(tp)) {
				msg = "Sửa thành công";
			} else {
				msg = "Sửa thất bại";
			}
		}

		if ("delete".equals(type)) {
			tp.setMatp(Integer.valueOf(request.getParameter("id")));

			if (tplogic.checkDeleteTP(tp)) {
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

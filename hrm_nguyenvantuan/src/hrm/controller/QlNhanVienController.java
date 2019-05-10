package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.duan;
import hrm.entities.nhanvien;
import hrm.entities.phongban;
import hrm.entities.tiengnhat;
import hrm.entities.truongphong;
import hrm.logic.PhongBanLogic;
import hrm.logic.QlNhanVienLogic;
import hrm.logic.QlTruongPhongLogic;

/**
 * Servlet implementation class QlNhanVienController
 */
@WebServlet("/QlNhanVienController")
public class QlNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected QlNhanVienLogic nvLogic = new QlNhanVienLogic();
	protected PhongBanLogic pbLogic = new PhongBanLogic();
	protected QlTruongPhongLogic tpLogic = new QlTruongPhongLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QlNhanVienController() {
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

		ArrayList<nhanvien> arrnv = new ArrayList<>();
		arrnv = nvLogic.getArrNV(page, search, id);
		listPage = nvLogic.getTotalPage(search, id);

		ArrayList<phongban> arrpb = new ArrayList<>();
		arrpb = pbLogic.getArrayPb(0, "");

		ArrayList<truongphong> arrtp = new ArrayList<>();
		arrtp = tpLogic.getArrTP(0, "");

		ArrayList<tiengnhat> arrtn = new ArrayList<>();
		arrtn = nvLogic.getArrTN();
		
		ArrayList<duan> arrduan = new ArrayList<>();
		arrduan = nvLogic.getArrDA();

		// send request
		request.setAttribute("arrnv", arrnv);
		request.setAttribute("page", page);
		request.setAttribute("listPage", listPage);
		request.setAttribute("arrpb", arrpb);
		request.setAttribute("arrtp", arrtp);
		request.setAttribute("arrtn", arrtn);
		request.setAttribute("arrduan", arrduan);

		if (id == 0) {
			// forward to qlnhanvien.jsp
			request.getRequestDispatcher("jsp/qlnhanvien.jsp").forward(request, response);
		} else {
			// forward to qlnhanvien.jsp
			request.getRequestDispatcher("jsp/nhanvien.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		nhanvien nv = new nhanvien();
		String type = request.getParameter("type"); // type : add, edit, delete
		String msg = null; // message notice

		if ("add".equals(type)) {
			nv.setMapb(Integer.valueOf(request.getParameter("phongban")));
			nv.setHoten(request.getParameter("hotenadd"));
			nv.setNamsinh(Integer.valueOf(request.getParameter("namsinhadd")));
			nv.setDiachi(request.getParameter("diachiadd"));
			nv.setGioitinh(request.getParameter("gioitinhadd"));
			nv.setSdt(request.getParameter("sdtadd"));
			nv.setMatp(Integer.valueOf(request.getParameter("truongphong")));
			nv.setTentk(request.getParameter("taikhoanadd"));
			nv.setMatkhau(request.getParameter("matkhauadd"));
			nv.setMatn(Integer.valueOf(request.getParameter("matn")));
			nv.setHesoluong(Integer.valueOf(request.getParameter("hesoluongadd")));

			if (nvLogic.checkAddNV(nv)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}

		if ("edit".equals(type)) {
			nv.setManv(Integer.valueOf(request.getParameter("id")));
			nv.setMatp(Integer.valueOf(request.getParameter("truongphong")));
			nv.setMapb(Integer.valueOf(request.getParameter("phongban")));
			nv.setHoten(request.getParameter("hotenedit"));
			nv.setNamsinh(Integer.valueOf(request.getParameter("namsinhedit")));
			nv.setDiachi(request.getParameter("diachiedit"));
			nv.setGioitinh(request.getParameter("gioitinhedit"));
			nv.setSdt(request.getParameter("sdtedit"));
			nv.setMatn(Integer.valueOf(request.getParameter("trinhdo")));
			nv.setHesoluong(Integer.valueOf(request.getParameter("hesoluongedit")));

			if (nvLogic.checkEditNV(nv)) {
				msg = "Sửa thành công";
			} else {
				msg = "Sửa thất bại";
			}
		}

		if ("delete".equals(type)) {
			nv.setManv(Integer.valueOf(request.getParameter("id")));

			if (nvLogic.checkDeleteNV(nv)) {
				msg = "Xóa thành công";
			} else {
				msg = "Xóa thất bại";
			}
		}
		
		if ("tpedit".equals(type)) {
			nv.setManv(Integer.valueOf(request.getParameter("id")));
			nv.setMaduan(Integer.valueOf(request.getParameter("duan")));
			nv.setDanhgia(request.getParameter("danhgia"));

			if (nvLogic.checkTPEditNV(nv)) {
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

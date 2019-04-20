package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrm.entities.ungvien;
import hrm.logic.QlUngVienLogic;


/**
 * Servlet implementation class QlUngVienController
 */
@WebServlet("/QlUngVienController")
public class QlUngVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected QlUngVienLogic uvLogic = new QlUngVienLogic();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QlUngVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		ArrayList<ungvien> arruv = new ArrayList<>();
		arruv = uvLogic.getArrUV(page, search);
		listPage = uvLogic.getTotalPage(search);
		
		// send request
		request.setAttribute("arruv", arruv);
		request.setAttribute("page", page);

		// forward to qltruongphong.jsp
		request.getRequestDispatcher("jsp/qlungvien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ungvien uv = new ungvien();
		String type = request.getParameter("type"); // type : add, edit, delete
		String msg = null; // message notice
		
		if ("add".equals(type)) {
			uv.setHoten(request.getParameter("hotenadd"));
			uv.setNamsinh(Integer.valueOf(request.getParameter("namsinhadd")));
			uv.setDiachi(request.getParameter("diachiadd"));
			uv.setGioitinh(request.getParameter("gioitinhadd"));
			uv.setSdt(request.getParameter("sdtadd"));
			uv.setTentk(request.getParameter("taikhoanadd"));
			uv.setMatkhau(request.getParameter("matkhauadd"));

			if (uvLogic.checkAddUV(uv)) {
				msg = "Thêm thành công";
			} else {
				msg = "Thêm thất bại";
			}
		}
		
		if ("edit".equals(type)) {
			uv.setMauv(Integer.valueOf(request.getParameter("id")));
			uv.setHoten(request.getParameter("hotenedit"));
			uv.setNamsinh(Integer.valueOf(request.getParameter("namsinhedit")));
			uv.setDiachi(request.getParameter("diachiedit"));
			uv.setGioitinh(request.getParameter("gioitinhedit"));
			uv.setSdt(request.getParameter("sdtedit"));

			if (uvLogic.checkEditUV(uv)) {
				msg = "Sửa thành công";
			} else {
				msg = "Sửa thất bại";
			}
		}

		if ("delete".equals(type)) {
			uv.setMauv(Integer.valueOf(request.getParameter("id")));

			if (uvLogic.checkDeleteUV(uv)) {
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

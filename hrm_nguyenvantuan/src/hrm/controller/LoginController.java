package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.logic.LoginLogic;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// lấy thông tin người dùng nhập từ form
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Tạo đối tượng logic
		LoginLogic logiclg = new LoginLogic();
		ArrayList<String> msg = new ArrayList<>();
		msg = logiclg.validateLogin(username, password);

		if (msg.size() == 2) {
			session.setAttribute("id", msg.get(0));
			if("quanly".equals(msg.get(1))) {
				// sendRedirect tới dashboard admin
				response.sendRedirect("dashboard_admin");
			}
			if("nhanvien".equals(msg.get(1))) {
				// sendRedirect tới dashboard nhanvien
				response.sendRedirect("dashboard_nhanvien");
			}
			
		} else {
			// gui loi ve trang login
			request.setAttribute("msg", msg);
			// forward trang login
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
	}

}

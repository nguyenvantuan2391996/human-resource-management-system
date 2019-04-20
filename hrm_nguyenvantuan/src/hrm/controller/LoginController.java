package hrm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// lấy thông tin người dùng nhập từ form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Tạo đối tượng logic
		LoginLogic logiclg = new LoginLogic();
		String error = logiclg.validateLogin(username, password);
		
		if(error == null) {
			// sendRedirect tới dashboard admin
			response.sendRedirect("dashboard_admin");
		} else {
			// gui loi ve trang login
			request.setAttribute("error", error);
			// forward trang login
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
	}

}

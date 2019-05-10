package hrm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TrongSoController
 */
@WebServlet("/TrongSoController")
public class TrongSoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrongSoController() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Double hoadong = Double.valueOf(request.getParameter("hoadong"));
		Double trungthuc = Double.valueOf(request.getParameter("trungthuc"));
		Double xuly = Double.valueOf(request.getParameter("xuly"));
		Double giaotiep = Double.valueOf(request.getParameter("giaotiep"));
		Double quantri = Double.valueOf(request.getParameter("quantri"));
		Double phantich = Double.valueOf(request.getParameter("phantich"));
		Double ngoaingu = Double.valueOf(request.getParameter("ngoaingu"));
		Double tinhoc = Double.valueOf(request.getParameter("tinhoc"));
		Double cntt = Double.valueOf(request.getParameter("cntt"));
		Double tongtrongso = hoadong + trungthuc + xuly + giaotiep + quantri + phantich + ngoaingu + tinhoc + cntt;
		
		if (tongtrongso == 1) {

			// send session
			session.setAttribute("type", null);
			session.setAttribute("hoadong", hoadong);
			session.setAttribute("trungthuc", trungthuc);
			session.setAttribute("xuly", xuly);
			session.setAttribute("giaotiep", giaotiep);
			session.setAttribute("quantri", quantri);
			session.setAttribute("phantich", phantich);
			session.setAttribute("ngoaingu", ngoaingu);
			session.setAttribute("tinhoc", tinhoc);
			session.setAttribute("cntt", cntt);

			// forward to nhaptrongso.jsp
			request.getRequestDispatcher("xemtuvan").forward(request, response);
		} else {
			String msg = "Vui lòng nhập tổng trọng số của các tiêu chí bằng 1";

			// send request
			request.setAttribute("msg", msg);

			// forward to nhaptrongso.jsp
			request.getRequestDispatcher("jsp/nhaptrongso.jsp").forward(request, response);
		}

		doGet(request, response);
	}

}

package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.cauhoi;
import hrm.entities.dapantraloi;
import hrm.logic.ThiTestLogic;

/**
 * Servlet implementation class ThiTestController
 */
@WebServlet("/ThiTestController")
public class ThiTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected ThiTestLogic ttLogic = new ThiTestLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThiTestController() {
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
		String chude = null;
		int mauv = Integer.parseInt((String) session.getAttribute("mauv"));

		if (ttLogic.checkTest(mauv) != null && session.getAttribute("page") == null) {
			String notice = ttLogic.checkTest(mauv);
			request.setAttribute("notice", notice);
		} else {
			if (session.getAttribute("page") != null) {
				page = (Integer) session.getAttribute("page") + 1;
			}

			ArrayList<cauhoi> arrcauhoi = new ArrayList<>();
			if (page <= 5) {
				arrcauhoi = ttLogic.getArrCH(page);
				chude = arrcauhoi.get(0).getChude();
			}

			// send request
			request.setAttribute("arrcauhoi", arrcauhoi);
			request.setAttribute("listPage", listPage);
			request.setAttribute("page", page);
			request.setAttribute("chude", chude);

			// send session
			session.setAttribute("page", page);
		}
		// forward to thitest.jsp
		request.getRequestDispatcher("jsp/thitest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int page = (Integer) session.getAttribute("page");
		int mauv = Integer.parseInt((String) session.getAttribute("mauv"));

		ArrayList<Float> arrpoint = new ArrayList<>();

		ArrayList<dapantraloi> arrdatl = new ArrayList<>();
		dapantraloi datl;
		for (int i = (page - 1) * 5 + 1; i <= page * 5; i++) {
			datl = new dapantraloi();

			datl.setMauv(Integer.parseInt((String) session.getAttribute("mauv")));
			datl.setMacauhoi(i);
			if (request.getParameter(String.valueOf(i)) == null) {
				datl.setTraloi("E");
			} else {
				datl.setTraloi(request.getParameter(String.valueOf(i)));
			}

			arrdatl.add(datl);
		}

		ttLogic.addDapAnTL(arrdatl);

		if (page == 5) {
			arrpoint = ttLogic.getArrPoint(mauv);

			request.setAttribute("arrpoint", arrpoint);

			// forward to ketquathi.jsp
			request.getRequestDispatcher("jsp/ketquathi.jsp").forward(request, response);
		}

		if (page < 5) {
			doGet(request, response);
		}

	}

}

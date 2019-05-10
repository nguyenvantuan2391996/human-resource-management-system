package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.logic.TienLuongLogic;

/**
 * Servlet implementation class XemPhieuLuongController
 */
@WebServlet("/XemPhieuLuongController")
public class XemPhieuLuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected TienLuongLogic tlLogic = new TienLuongLogic();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemPhieuLuongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int page = 1;
		ArrayList<Integer> listPage = new ArrayList<>();
		String search = request.getParameter("search");
		int id = Integer.parseInt((String) session.getAttribute("id"));

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}
		if (search == null) {
			search = "";
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

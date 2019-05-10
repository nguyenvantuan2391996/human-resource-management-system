package hrm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrm.entities.ungvien;
import hrm.logic.TuVanLogic;

/**
 * Servlet implementation class TuVanController
 */
@WebServlet("/TuVanController")
public class TuVanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected TuVanLogic tvLogic = new TuVanLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TuVanController() {
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

		if (request.getParameter("page") != null) {
			page = Integer.valueOf(request.getParameter("page"));
		}

		ArrayList<ungvien> arruv = new ArrayList<>();

		if (session.getAttribute("type") != null) {
			arruv = tvLogic.getArrayUV(page, "order by");
		} else {
			arruv = tvLogic.getArrayUV(page, "");
		}

		listPage = tvLogic.getListPage();

		// send request
		request.setAttribute("arruv", arruv);
		request.setAttribute("listPage", listPage);
		request.setAttribute("page", page);

		if (session.getAttribute("type") != null) {
			// forward to ketquatuvan.jsp
			request.getRequestDispatcher("jsp/ketquatuvan.jsp").forward(request, response);

		} else {
			// forward to xemtuvan.jsp
			request.getRequestDispatcher("jsp/xemtuvan.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		Double hoadong = (Double) session.getAttribute("hoadong");
		Double trungthuc = (Double) session.getAttribute("trungthuc");
		Double quantri = (Double) session.getAttribute("quantri");
		Double phantich = (Double) session.getAttribute("phantich");
		Double ngoaingu = (Double) session.getAttribute("ngoaingu");
		Double tinhoc = (Double) session.getAttribute("tinhoc");
		Double cntt = (Double) session.getAttribute("cntt");
		Double xuly = (Double) session.getAttribute("xuly");
		Double giaotiep = (Double) session.getAttribute("giaotiep");

		ArrayList<Double> arrtrongso = new ArrayList<>();
		arrtrongso.add(hoadong);
		arrtrongso.add(trungthuc);
		arrtrongso.add(quantri);
		arrtrongso.add(phantich);
		arrtrongso.add(ngoaingu);
		arrtrongso.add(tinhoc);
		arrtrongso.add(cntt);
		arrtrongso.add(xuly);
		arrtrongso.add(giaotiep);

		int row = tvLogic.getRowTotal();
		Float data[][] = new Float[row][9];
		Float A[][] = new Float[2][9];
		Double S[][] = new Double[2][row];
		Double C[] = new Double[row];
		ArrayList<ungvien> arruv = new ArrayList<>();

		// get data
		data = tvLogic.getData(row);

		// chuan hoa mien [0;1]
		data = tvLogic.standardize(data);

		// tinh ma tran theo trong so
		data = tvLogic.weightedMatrix(data, arrtrongso);

		// tinh giai phap ly tuong
		A = tvLogic.idealSolution(data);

		// tinh khoang cach toi giai phap ly tuong
		S = tvLogic.distanceIdealSolution(data, A);

		// tinh do tuong tu toi giai phap ly tuong
		C = tvLogic.calculateC(S, row);
		
		// add C
		if (tvLogic.checkUpdateC(C)) {
			session.setAttribute("type", "order by");
			doGet(request, response);
		}
	}
}

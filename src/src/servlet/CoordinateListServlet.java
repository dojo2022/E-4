package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateDAO;
import model.CoordinateModel;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/CoordinateListServlet")
public class CoordinateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateSearch.jsp");
		dispatcher.forward(request, response);

		// 検索処理を行う
		CoordinateDAO cDao = new CoordinateDAO();
		List<CoordinateModel> CoordinateList = cDao.select(new CoordinateModel("", "", "",  "",  "",  "",  "",  "", "", "", "", "", ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CoordinateList", CoordinateList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String season = request.getParameter("search_season");
		String purpose = request.getParameter("search_purpose");
		String category = request.getParameter("search_word");
		String brand = request.getParameter("search_word");
		String size = request.getParameter("search_word");
		String remarks = request.getParameter("search_word");

		// 検索処理を行う
		CoordinateDAO cDao = new CoordinateDAO();
		List<CoordinateModel> CoordinateList = cDao.search(new CoordinateModel("", "", season, purpose, "", "", "", category, brand, size, "", remarks, ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CoordinateList", CoordinateList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateResult.jsp");
		dispatcher.forward(request, response);
	}
}

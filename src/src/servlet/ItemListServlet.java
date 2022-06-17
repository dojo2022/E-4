package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateItemDAO;
import model.CoordinateItemModel;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//検索処理を行う
		CoordinateItemDAO itemDao = new CoordinateItemDAO();
		List<CoordinateItemModel> ModelList = itemDao.select(new CoordinateItemModel("","","","","","","","",""));

		//検索結果をリクエストスコープに格納する
		request.setAttribute("ModelList", ModelList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemSearch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String category =request.getParameter("search_category");
		String brand =request.getParameter("search_brand");

	}
}
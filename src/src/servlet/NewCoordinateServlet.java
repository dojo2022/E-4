package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/NewCoordinateServlet")

public class NewCoordinateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        String coordinate_id = request.getParameter("q");
	        // 検索処理を行う
	        CoordinateDAO itemDao = new CoordinateDAO();
	        List<CoordinateItem> itemList = itemDao.select(new Coordinate_Item("", "",  "",  "",  "",  "",  "",  "",  ""));

	        request.setAttribute("itemList", itemList);
	        // 結果ページにフォワードする

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("user_id");
        String Coordinate_id = request.getParameter("Coordinate_id");
        String Season = request.getParameter("Season");
        String Purpose = request.getParameter("Purpose");
        String Coordinate_image = request.getParameter("Coordinate_image");
	}
}
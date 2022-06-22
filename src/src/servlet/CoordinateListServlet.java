package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoordinateDAO;
import model.Coordinate;
import model.LoginUser;

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

		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CCC/LoginServlet");
			return;
		}

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

		// 検索処理を行う
		CoordinateDAO cDao = new CoordinateDAO();
		List<Coordinate> CoordinateList = cDao.CoordinateSearch(new Coordinate(user_id, "", "", "", ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CoordinateList", CoordinateList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateSearch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String season = request.getParameter("search_season");
		String purpose = request.getParameter("search_purpose");

		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();
		// 検索処理を行う
		CoordinateDAO cDao = new CoordinateDAO();
		List<Coordinate> CoordinateList = cDao.CoordinateSearch(new Coordinate(user_id, "", season, purpose, ""));

		//タグをArrayListに格納
		List<String> tagList = new ArrayList<String>();
		tagList.add(season);
		tagList.add(purpose);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("CoordinateList", CoordinateList);
		request.setAttribute("tag_list", tagList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateResult.jsp");
		dispatcher.forward(request, response);
	}
}

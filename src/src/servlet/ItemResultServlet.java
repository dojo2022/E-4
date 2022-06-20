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
 * Servlet implementation class NewUserErrorServlet
 */
@WebServlet("/ItemResultServlet")
public class ItemResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//検索処理を行う
		CoordinateItemDAO ciDao = new CoordinateItemDAO();
		List<CoordinateItemModel> ciModel =ciDao.select(new CoordinateItemModel("","","","","","","","",""));

		//検索結果をリクエストスコープに収納する
		request.setAttribute("ciModel", ciModel);

		//検索結果のページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


	//アイテム詳細へのページ移動
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");



		doGet(request, response);

	}

}

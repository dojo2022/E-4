package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoordinateDAO;
import dao.CoordinateItemDAO;
import dao.UsedItemDAO;
import model.CoordinateInsertModel;
import model.CoordinateItemModel;
import model.ItemBrandModel;
import model.LoginUser;
import model.UsedItemModel;

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
		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

		//アイテムを全件取得
		CoordinateItemDAO itemdao = new CoordinateItemDAO();
		List <CoordinateItemModel> modelList = itemdao.select (new CoordinateItemModel("","","","","","","","",""));

		//リクエストスコープに格納する
		request.setAttribute("modelList",modelList);

		CoordinateItemDAO bDao = new CoordinateItemDAO();
		List<ItemBrandModel> brandList = bDao.selectBrand(new ItemBrandModel(user_id,""));

		//検索結果をリクエストスコープに格納する
		request.setAttribute("brandList", brandList);

		//jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		//登録情報の取得
		// リクエストパラメータを取得する
        String user_id = request.getParameter("user_id");
        String coordinate_id = request.getParameter("coordinate_id");
        String season = request.getParameter("season");
        String purpose = request.getParameter("purpose");
        String coordinate_image = request.getParameter("coordinate_image");
        String item_id = request.getParameter("item_id");

		// 登録処理を行う
		CoordinateDAO bDao = new CoordinateDAO();
		if (bDao.insert(new CoordinateInsertModel(user_id, coordinate_id, season, purpose, coordinate_image))) {	// 登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {												// 登録失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateError.jsp");
			dispatcher.forward(request, response);
		}

		UsedItemDAO iDao = new UsedItemDAO();
		if (iDao.insertId((List<UsedItemModel>) new UsedItemModel(user_id, item_id, coordinate_id))) {	// 登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {												// 登録失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateError.jsp");
			dispatcher.forward(request, response);
		}




	}
}
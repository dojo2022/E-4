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

import dao.CoordinateItemDAO;
import model.CoordinateItemModel;
import model.LoginUser;

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

		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		//String user_id = user.getUser_id();
		String user_id = "takahashi";

		//検索処理を行う
		CoordinateItemDAO itemDao = new CoordinateItemDAO();
		List<CoordinateItemModel> ModelList = itemDao.select(new CoordinateItemModel(user_id,"","","","","","","",""));

		//検索結果をリクエストスコープに格納する
		request.setAttribute("ModelList", ModelList);

		//結果ページにフォワードする
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

		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		// String user_id = user.getUser_id();
		String user_id = "takahashi";
		
		CoordinateItemModel itemModel = (CoordinateItemModel)session.getAttribute("item_image");
	/*	String item_image = itemModel.getItem_image();*/

		//検索処理を行う
		CoordinateItemDAO itemDao = new CoordinateItemDAO();
		List<CoordinateItemModel> CoordinateItemList = itemDao.select(new CoordinateItemModel(user_id,"","",category,brand,"","","",""));

		//タグをArrayListに格納
		List<String> iTagList = new ArrayList<>();
		iTagList.add(category);
	    iTagList.add(brand);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("CoordinateItemList", CoordinateItemList);

		request.setAttribute("iTagList", iTagList);

		//結果ページにフォワードする
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
		dispatcher.forward(request, response);

	}
}
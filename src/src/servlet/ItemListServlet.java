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
import model.ItemBrandModel;
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
		String user_id = user.getUser_id();
		

		//検索処理を行う
		CoordinateItemDAO itemDao = new CoordinateItemDAO();
		List<CoordinateItemModel> ModelList = itemDao.select(new CoordinateItemModel(user_id,"","","","","","","",""));

		//検索結果をリクエストスコープに格納する
		request.setAttribute("ModelList", ModelList);

		CoordinateItemDAO bDao = new CoordinateItemDAO();
		List<ItemBrandModel> brandList = bDao.selectBrand(new ItemBrandModel(user_id,""));

		//検索結果をリクエストスコープに格納する
		request.setAttribute("brandList", brandList);

		//結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemSearch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String category1 =request.getParameter("search_category1");
		String category2 =request.getParameter("search_category2");
		String category3 =request.getParameter("search_category3");
		String category4 =request.getParameter("search_category4");
		String category5 =request.getParameter("search_category5");
		String category6 =request.getParameter("search_category6");
		String category7 = request.getParameter("search_category7");




		String brand =request.getParameter("search_brand");

		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		 String user_id = user.getUser_id();


		CoordinateItemModel itemModel = (CoordinateItemModel)session.getAttribute("item_image");
	/*	String item_image = itemModel.getItem_image();*/

		//検索処理を行う
		CoordinateItemDAO itemDao = new CoordinateItemDAO();
		//List<CoordinateItemModel> CoordinateItemList = itemDao.select(new CoordinateItemModel(user_id,"","",category,brand,"","","",""));
		List<CoordinateItemModel> CoordinateItemList = itemDao.select(new CoordinateItemModel(user_id,"","",category1,brand,"","","",""));
		//タグをArrayListに格納
		List<String> iTagList = new ArrayList<>();
		if(session.getAttribute("catagory1") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category1);
		}

		if(session.getAttribute("catagory2") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category2);
		}
		if(session.getAttribute("catagory3") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category3);
		}
		if(session.getAttribute("catagory4") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category4);
		}
		if(session.getAttribute("catagory5") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category5);
		}
		if(session.getAttribute("catagory6") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category6);
		}
		if(session.getAttribute("catagory7") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			iTagList.add(category7);
		}
		/*iTagList.add(category2);
		iTagList.add(category3);
		iTagList.add(category4);
		iTagList.add(category5);
		iTagList.add(category6);
		*/


	    iTagList.add(brand);

		//検索結果をリクエストスコープに格納する
		request.setAttribute("CoordinateItemList", CoordinateItemList);

		request.setAttribute("iTagList", iTagList);

		//結果ページにフォワードする
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/ItemResult.jsp");
		dispatcher.forward(request, response);

	}
}
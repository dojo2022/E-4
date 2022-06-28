package servlet;

import java.io.IOException;

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
 * Servlet implementation class NewUserErrorServlet
 */
@WebServlet("/NewItemServlet")
public class NewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewItem.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登録情報の取得
		// リクエストパラメータを取得する
		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

		request.setCharacterEncoding("UTF-8");
		String item_image = request.getParameter("item_image");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String size = request.getParameter("size");
		String remarks = request.getParameter("remarks");


		// 登録処理を行う
		CoordinateItemDAO nDao = new CoordinateItemDAO();
		if (nDao.insert(new CoordinateItemModel(user_id,"",item_image,category, brand,size,"",remarks,""))) {	// 登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewItemSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {	// 登録失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewItemError.jsp");
			dispatcher.forward(request, response);
		}

		// 結果ページにフォワードする
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);*/
	}
 }

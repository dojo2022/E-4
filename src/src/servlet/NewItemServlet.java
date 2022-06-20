package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateItemDAO;

/**
 * Servlet implementation class NewUserErrorServlet
 */
@WebServlet("/NewItemtServlet")
public class NewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String item_id = request.getParameter("ITEM_ID");
		String item_image = request.getParameter("ITEM_IMAGE");
		String category = request.getParameter("CATEGORY");
		String brand = request.getParameter("BRAND");
		String size = request.getParameter("SIZE");
		String flag = request.getParameter("FLAG");
		String remarks = request.getParameter("REMARKS");
		String date = request.getParameter("DATE");


		// 登録処理を行う
		CoordinateItemDAO bDao = newCoordinateItemDAO();
		if (bDao.insert(new CoordinateItem(user_id,item_id,item_image,category, brand,size,flag,remarks,date))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/CCC/NewItemServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/CCC/NewItemErrorServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}

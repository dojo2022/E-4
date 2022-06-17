package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		// 登録処理を行う
		UserDAO uDao = new UserDAO();
		if (uDao.insert(new User(user_id, password))) {	// 登録成功
			request.setAttribute("result",
			new Result("Welcome!", "/CCC/LoginServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("An error has occurred. Try again.", "/CCC/NewUserServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);

	}
}
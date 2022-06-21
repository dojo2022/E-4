package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.LoginUser;
import model.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
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

			// ログイン処理を行う
			UserDAO userDao = new UserDAO();
			if (userDao.isLoginOK(new UserModel(user_id, password))) {	// ログイン成功

				// セッションスコープにIDを格納する
				HttpSession session = request.getSession();
				session.setAttribute("user_id", new LoginUser(user_id));


				// ホームサーブレットにリダイレクトする
				response.sendRedirect("/CCC/HomeServlet");
			}
			else {									// ログイン失敗
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LoginError.jsp");
				dispatcher.forward(request, response);
			}

	}
}
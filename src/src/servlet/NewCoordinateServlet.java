package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateDAO;
import dao.UsedItemDAO;
import model.CoordinateModel;
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("user_id");
        String coordinate_id = request.getParameter("coordinate_id");
        String season = request.getParameter("season");
        String purpose = request.getParameter("purpose");
        String coordinate_image = request.getParameter("coordinate_image");
        String item_id = request.getParameter("item_id");


		CoordinateDAO bDao = new CoordinateDAO();
		if (bDao.insert(new CoordinateModel(user_id, coordinate_id, season, purpose, coordinate_image, "", "", "", "", "", "", "", ""))) {	// 登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {												// 登録失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateError.jsp");
			dispatcher.forward(request, response);
		}

		UsedItemDAO iDao = new UsedItemDAO();
		if (iDao.insert(new UsedItemModel(user_id, item_id, coordinate_id))) {	// 登録成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {												// 登録失敗
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateError.jsp");
			dispatcher.forward(request, response);
		}




	}
}
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


		/*CoordinateDAO cDao = new CoordinateDAO();
		//List<CoordinateModel> CoordinateList = cDao.insert(new CoordinateModel(user_id, coordinate_id, season, purpose, coordinate_image, "", "", "", "", "", "", "", ""))) {
		if (cDao.insert(new CoordinateModel(user_id, coordinate_id, season, purpose, coordinate_image, "", "", "", "", "", "", "", "" ))) {	// 登録成功
			request.setAttribute("result",
			new result("Welcome!", "/CCC/NewCoordinateServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new result("An error has occurred. Try again.", "/CCC/NewCoordinateServlet"));
		}*/


		CoordinateDAO bDao = new CoordinateDAO();
		if (bDao.insert(new CoordinateModel("", "", "", "", "", "", "", "", "", "", "", "", ""))) {	// 登録成功
			request.setAttribute("result",
			new result("登録成功！", "Successfully registered", "/simpleBC/MenuServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new result("登録失敗！", "An error has occurred. Try again.", "/simpleBC/MenuServlet"));
		}

		UsedItemDAO iDao = new UsedItemDAO();
		if (iDao.insert(new UsedItemModel("", "", ""))) {	// 登録成功
			request.setAttribute("result",
			new result("登録成功！", "Successfully registered", "/simpleBC/MenuServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new result("登録失敗！", "An error has occurred. Try again.", "/simpleBC/MenuServlet"));
		}




	}
}
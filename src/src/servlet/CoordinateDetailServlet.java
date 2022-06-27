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
import dao.UsedItemDAO;
import model.Coordinate;
import model.CoordinateModel;
import model.LoginUser;
import model.UsedItemModel;

/**
 * Servlet implementation class CoordinateDetailServlet
 */
@WebServlet("/CoordinateDetailServlet")
public class CoordinateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String coordinate_id = request.getParameter("q");

		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

        // 検索処理を行う
        CoordinateDAO cDao = new CoordinateDAO();
        List<CoordinateModel> CoordinateList = cDao.search(new CoordinateModel(user_id, coordinate_id, "", "", "", "", "", "", "", "", "", "", ""));//コーディネートの画像のみ
        // 検索結果をリクエストスコープに格納する
        request.setAttribute("CoordinateList", CoordinateList);

         // 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateDetail.jsp");
		dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータを取得する
        request.setCharacterEncoding("UTF-8");
        String coordinate_id = request.getParameter("coordinate_id");
        String item_id = request.getParameter("item_id");

        HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

        //アイテム情報追加、アイテム、コーディネート削除
		UsedItemDAO usedItemDAO = new UsedItemDAO();
		CoordinateDAO cDao = new CoordinateDAO();

        if(request.getParameter("submit").equals("delete")){
            if (usedItemDAO.deleteI(new UsedItemModel(user_id, "",item_id))) { // 削除成功

            	List<CoordinateModel> CoordinateList = cDao.search(new CoordinateModel(user_id, coordinate_id, "", "", "", "", "", "", "", "", "", "", ""));//コーディネートの画像のみ
                // 検索結果をリクエストスコープに格納する
                request.setAttribute("CoordinateList", CoordinateList);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateDetail.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateDetail.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
        }
        else if(request.getParameter("submit").equals("Delete this look")){
            if (cDao.delete(new Coordinate(user_id, coordinate_id, "", "", ""))) { // 削除成功

        		List<Coordinate> CoordinateList = cDao.CoordinateSearch(new Coordinate(user_id, "", "", "", ""));

        		// 検索結果をリクエストスコープに格納する
        		request.setAttribute("CoordinateList", CoordinateList);
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateSearch.jsp");
        		dispatcher.forward(request, response);
            	return;
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateSearch.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
        }

         /* else if(request.getParameter("submit").equals("Update this look")){
        	// 追加成功
            if (coordinateDao.insert(new CoordinateInsertModel(user_id, coordinate_id, season, purpose, coordinate_image))) {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateResult.jsp");
            	dispatcher.forward(request, response);
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CoordinateList.jsp");
            	dispatcher.forward(request, response);
            }
        }

        // 結果ページにフォワードする

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateError.jsp");
        dispatcher.forward(request, response);
        */

    }
}
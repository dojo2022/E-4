package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateDAO;
import dao.CoordinateItemDAO;
import model.CoordinateModel;

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
        // 検索処理を行う
        CoordinateDAO cDao = new CoordinateDAO();
        List<CoordinateModel> CoordinateList = cDao.search(new CoordinateModel("", coordinate_id, "", "", "", "", "", "", "", "", "", "", ""));//コーディネートの画像のみ
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
        String useditem_id = request.getParameter("item_id");

        //アイテム情報追加、アイテム、コーディネート削除
        CoordinateDAO coordinateDao = new CoordinateDAO();
        CoordinateItemDAO itemDao = new CoordinateItemDAO();

        if(request.getParameter("submit").equals("アイテム削除")){
            if (coordinateDao.delete(useditem_id)) { // 削除成功
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
        }
        else if(request.getParameter("submit").equals("コーディネート削除")){
            if (coordinateDao.delete(coordinate_id)) { // 削除成功
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
        }

        else if(request.getParameter("submit").equals("コーディネートアイテム追加")){
            if (coordinateDao.insert(item_id)) { // 追加成功
                request.setAttribute("result",
                new Result("レコードを追加しました。", "/CCC/CoordinateDetailServlet"));
            }
            else {                      // 削除失敗
                request.setAttribute("result",
                new Result("レコードを追加できませんでした。", "/CCC/CoordinateDetailServlet"));
            }
        }

        // 結果ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewCoordinateError.jsp");
        dispatcher.forward(request, response);

    }
}
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CoordinateItemDAO;
import model.CoordinateItemModel;
import model.DeleteFlagModel;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/ItemDetailServlet")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String item_id = request.getParameter("q");
        // 検索処理を行う
        CoordinateItemDAO itemDao = new CoordinateItemDAO();
        List<CoordinateItemModel> itemList = itemDao.select(new CoordinateItemModel("", item_id,  "",  "",  "",  "",  "",  "",  ""));
        // 検索結果をリクエストスコープに格納する
        request.setAttribute("itemList", itemList);
        // 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemDetail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータを取得する
        request.setCharacterEncoding("UTF-8");
        String item_id = request.getParameter("item_id");
        String brand = request.getParameter("brand");
        String size = request.getParameter("size");
        String remarks = request.getParameter("remarks");

        // 更新または削除を行う
        CoordinateItemDAO itemDao = new CoordinateItemDAO();
        if (request.getParameter("submit").equals("更新")) {
            if (itemDao.update(new CoordinateItemModel("",item_id, "", "", "", brand, size, remarks,""))) {  // 更新成功
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
            else {                                              // 更新失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
        }
        else if(request.getParameter("submit").equals("削除")){
            if (itemDao.updateflag(new DeleteFlagModel("","",""))) { // 削除成功
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemList.jsp");
            	dispatcher.forward(request, response);
            }
        }
        // 結果ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewItemError.jsp");
        dispatcher.forward(request, response);
    }
}
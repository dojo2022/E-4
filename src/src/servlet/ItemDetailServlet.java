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

import dao.CoordinateItemDAO;
import model.CoordinateItemModel;
import model.DeleteFlagModel;
import model.LoginUser;

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

		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

        // 検索処理を行う
        CoordinateItemDAO itemDao = new CoordinateItemDAO();
        List<CoordinateItemModel> itemList = itemDao.select(new CoordinateItemModel(user_id, item_id,  "",  "",  "",  "",  "",  "",  ""));
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

        HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("user_id");
		String user_id = user.getUser_id();

		 CoordinateItemDAO itemDao = new CoordinateItemDAO();
	        List<CoordinateItemModel> itemList = itemDao.select(new CoordinateItemModel(user_id, item_id,  "",  "",  "",  "",  "",  "",  ""));
	        // 検索結果をリクエストスコープに格納する
	        request.setAttribute("itemList", itemList);

		CoordinateItemDAO itemDao1 = new CoordinateItemDAO();
		//検索結果をリクエストスコープに格納する


        // 更新または削除を行う
		//検索しておく
        if (request.getParameter("submit").equals("update")) {
            if (itemDao1.update(new CoordinateItemModel(user_id,item_id, "", "", brand, size, "", remarks,""))) {  // 更新成功

        		List<CoordinateItemModel> itemList1 = itemDao1.select(new CoordinateItemModel(user_id,item_id,"","","","","","",""));
        		//検索結果をリクエストスコープに格納する
        		request.setAttribute("itemList", itemList1);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemDetail.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
            else {                                              // 更新失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemDetail.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
        }
        else if(request.getParameter("submit").equals("delete")){
        	if (itemDao.updateflag(new DeleteFlagModel(user_id,item_id,"delete"))) { // 削除成功
        		List<CoordinateItemModel> ModelList2 = itemDao1.select(new CoordinateItemModel(user_id,"","","","","","","",""));

        		//検索結果をリクエストスコープに格納する
        		request.setAttribute("ModelList", ModelList2);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemSearch.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
            else {                      // 削除失敗
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemSearch.jsp");
            	dispatcher.forward(request, response);
            	return;
            }
        }
        // 結果ページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewItemError.jsp");
        dispatcher.forward(request, response);
    }
}
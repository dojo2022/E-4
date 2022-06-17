package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsedItemDAO {

	public List<UsedItemModel> select(UsedItemModel param) {
		Connection conn = null;
		List<UsedItemModel> UsedItemList = new ArrayList<UsedItemModel>();

try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "insert into Used_Item (User_ID, Item_ID, Coordinate_ID) values (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_ID() != null && !param.getUser_ID().equals("")) {
				pStmt.setString(1, param.getUser_ID());
			}
			else {
				pStmt.setString(1, null);
			}
			if (param.getItem_ID() != null && !param.getItem_ID().equals("")) {
				pStmt.setString(2, param.getItem_ID());
			}
			else {
				pStmt.setString(2, null);
			}
			if (param.getCoordinate_ID() != null && !param.getCoordinate_ID().equals("")) {
				pStmt.setString(3, param.getCoordinate_ID());
			}
			else {
				pStmt.setString(3, null);
			}
			// 結果表をコレクションにコピーする

		}
		catch (SQLException e) {
			e.printStackTrace();
			param = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			param = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					param = null;
				}

			}
		return result;
public boolean delete(String Coordinate_ID) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "delete from UsedItem_ID where COORDINATE_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, Coordinate_ID);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}
}

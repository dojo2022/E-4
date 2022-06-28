package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.UsedItemModel;



public class UsedItemDAO {
	//アイテムIDとコーディネートIDの登録
	public boolean insertId(List<UsedItemModel> list) {
		Connection conn = null;
		boolean result = false;
		//List<UsedItemModel> UsedItemList = new ArrayList<UsedItemModel>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/CCC", "sa", "ccc");

			// SQL文を準備する
			//ここからループ
			for(UsedItemModel param:list) {
			String sql = "insert into Used_Item (User_ID, Item_ID, Coordinate_ID) values (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null && !param.getUser_id().equals("")) {
				pStmt.setString(1, param.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (param.getItem_id() != null && !param.getItem_id().equals("")) {
				pStmt.setString(2, param.getItem_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (param.getCoordinate_id() != null && !param.getCoordinate_id().equals("")) {
				pStmt.setString(3, param.getCoordinate_id());
			}
			else {
				pStmt.setString(3, null);
			}
			//SQL文の実行
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			list = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			list = null;
		}

		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					list = null;
				}

			}
		}
		return result;
	}

	//アイテムの削除
		public boolean deleteI(UsedItemModel Item_ID) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/CCC", "sa", "ccc");

				// SQL文を準備する
				String sql = "delete from Used_Item where user_id=? and item_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, Item_ID.getUser_id());
				pStmt.setString(2, Item_ID.getItem_id());

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

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CoordinateItemModel;
import model.DeleteFlagModel;
import model.UsedItemModel;

public class CoordinateItemDAO {

       	//アイテム検索
    	public List<CoordinateItemModel> select(CoordinateItemModel param) {
    		Connection conn = null;
    		List<CoordinateItemModel> cardList = new ArrayList<CoordinateItemModel>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    			// SQL文を準備(検索）
    			String sql = "select category,brand,item_image,item_id,size,remarks,day,flag "
    					+ "from item where  category like ? and brand like ? and item_id like ? and flag != 'Delete' and user_id like ?";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
    			if (param.getCategory() != null) {
    				pStmt.setString(1, "%" + param.getCategory() + "%");
    			}
    			else {
    				pStmt.setString(1, "%");
    			}
    			if (param.getBrand() != null) {
    				pStmt.setString(2, "%" + param.getBrand() + "%");
    			}
    			else {
    				pStmt.setString(2, "%");
    			}
    			if (param.getItem_id() != null) {
    				pStmt.setString(3, "%" + param.getItem_id() + "%");
    			}
    			else {
    				pStmt.setString(3, "%");
    			}
    			if (param.getUser_id() != null) {
    				pStmt.setString(4, "%" + param.getUser_id() + "%");
    			}
    			else {
    				pStmt.setString(4, "%");
    			}


    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				CoordinateItemModel card = new CoordinateItemModel(
    				param.getUser_id(),
    				rs.getString("item_id"),
    				rs.getString("item_image"),
    				rs.getString("category"),
    				rs.getString("brand"),
    				rs.getString("size"),
    				rs.getString("flag"),
    				rs.getString("remarks"),
    				rs.getString("day")
    				);
    				cardList.add(card);
    			}
    		}
    		catch (SQLException e) {
    			e.printStackTrace();
    			cardList = null;
    		}
    		catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			cardList = null;
    		}
			finally {
    				// データベースを切断
    				if (conn != null) {
    					try {
    						conn.close();
    					}
    					catch (SQLException e) {
    						e.printStackTrace();
    						cardList = null;
    				}
    			}
    		}

    			// 結果を返す(どのようにデータを返せばいいかわからない)
    			return cardList;

    	}


    	//アイテムを登録する 引数cardで指定されたレコードを登録し、成功したらtrueを返す(修正）
    		public boolean insert(CoordinateItemModel card) {
    			Connection conn = null;
    			boolean result = false;

    			try {
    				// JDBCドライバを読み込む
    				Class.forName("org.h2.Driver");

    				// データベースに接続する
    				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    				// SQL文を準備する
    				String sql = "insert into item (user_id,item_id,item_image,category, brand,size,flag,remarks,date) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    				PreparedStatement pStmt = conn.prepareStatement(sql);

 					// SQL文を完成させる
					if (card.getUser_id() != null && !card.getUser_id().equals("")) {
						pStmt.setString(1, card.getUser_id());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getItem_id() != null && !card.getItem_id().equals("")) {
						pStmt.setString(2, card.getItem_id());
					}
					else {
						pStmt.setString(2, null);
					}
					if (card.getItem_image() != null && !card.getItem_image().equals("")) {
						pStmt.setString(3, card.getItem_image());
					}
					else {
						pStmt.setString(3, null);
					}
					if (card.getCategory() != null && !card.getCategory().equals("")) {
						pStmt.setString(4, card.getCategory());
					}
					else {
						pStmt.setString(4, null);
					}
					if (card.getBrand() != null && !card.getBrand().equals("")) {
						pStmt.setString(5, card.getBrand());
					}
					else {
						pStmt.setString(5, null);
					}
					if (card.getSize() != null && !card.getSize().equals("")) {
						pStmt.setString(6, card.getSize());
					}
					else {
						pStmt.setString(6, null);
					}
					if (card.getFlag() != null && !card.getFlag().equals("")) {
						pStmt.setString(7, card.getFlag());
					}
					else {
						pStmt.setString(7, null);
					}
					if (card.getRemarks() != null && !card.getRemarks().equals("")) {
						pStmt.setString(8, card.getRemarks());
					}
					else {
						pStmt.setString(8, null);
					}
					if (card.getDay() != null && !card.getDay().equals("")) {
						pStmt.setString(9, card.getDay());
					}
					else {
						pStmt.setString(9, null);
					}

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


    	//アイテムの更新
    	public boolean update(CoordinateItemModel card) {
    				Connection conn = null;
    				boolean result = false;

    				try {
    					// JDBCドライバを読み込む
    					Class.forName("org.h2.Driver");

    					// データベースに接続する
    					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");


    					// SQL文を準備する
    					String sql = "update item set item_id=?,item_image=?,category=?,brand=?,size=?,flag=?, remarks=?,date=? where user_id=?";
    					PreparedStatement pStmt = conn.prepareStatement(sql);

    					// SQL文を完成させる
    					if (card.getItem_id() != null && !card.getItem_id().equals("")) {
    						pStmt.setString(1, card.getItem_id());
    					}
    					else {
    						pStmt.setString(1, null);
    					}
    					if (card.getItem_image() != null && !card.getItem_image().equals("")) {
    						pStmt.setString(2, card.getItem_image());
    					}
    					else {
    						pStmt.setString(2, null);
    					}
    					if (card.getCategory() != null && !card.getCategory().equals("")) {
    						pStmt.setString(3, card.getCategory());
    					}
    					else {
    						pStmt.setString(3, null);
    					}
    					if (card.getBrand() != null && !card.getBrand().equals("")) {
    						pStmt.setString(4, card.getBrand());
    					}
    					else {
    						pStmt.setString(4, null);
    					}
    					if (card.getSize() != null && !card.getSize().equals("")) {
    						pStmt.setString(5, card.getSize());
    					}
    					else {
    						pStmt.setString(5, null);
    					}
    					if (card.getFlag() != null && !card.getFlag().equals("")) {
    						pStmt.setString(6, card.getFlag());
    					}
    					else {
    						pStmt.setString(6, null);
    					}
    					if (card.getRemarks() != null && !card.getRemarks().equals("")) {
    						pStmt.setString(7, card.getRemarks());
    					}
    					else {
    						pStmt.setString(7, null);
    					}
    					if (card.getDay() != null && !card.getDay().equals("")) {
    						pStmt.setString(8, card.getDay());
    					}
    					else {
    						pStmt.setString(8, null);
    					}
    					pStmt.setString(9, card.getUser_id());

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


    	//フラグ更新
     	public boolean updateflag(DeleteFlagModel card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");


				// SQL文を準備する
				String sql = "update item set flag=delete where user_id=?,item_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(1, card.getUser_id());
				}
				else {
					pStmt.setString(1, null);

				}
				if (card.getItem_id() != null && !card.getItem_id().equals("")) {
					pStmt.setString(2, card.getItem_id());
				}
				else {
					pStmt.setString(2, null);
				}

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


     	//着用日付の更新

    	public boolean updateDate(List<CoordinateItemModel> card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");


				// SQL文を準備する
				//ここからループ
				for(CoordinateItemModel param:card) {
				String sql = "update item set date=CAST(GETDATE() as date where user_id=?,item_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);


				//SQL文を完成させる
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

				// SQL文を実行する()
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
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

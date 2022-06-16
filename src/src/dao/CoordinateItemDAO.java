package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CoordinateItemModel;

public class CoordinateItemDAO {

       	//コーディネイト一覧からコーディネイトidを受けて使用アイテムまとまりを表示する（型や()の中に何を書いたらいいかわからない）
    	public List<CoordinateItemModel> select(CoordinateItemModel param) {
    		Connection conn = null;
    		List<CoordinateItemModel> cardList = new ArrayList<CoordinateItemModel>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    			// SQL文を準備(コーディネイトからアイテムのまとまりを探す)
    			String sql = "select user_id,item_id,item_image,category,brand,size,flag,remarks,date from item where user_id = ? item_id = ? item_image = ? category = ? brand = ? size = ?  flag = ? remarks = ? date = ? and ";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる（追加）
    			if (param.getUser_id() != null) {
    				pStmt.setString(1, "%" + param.getUser_id() + "%");
    			}
    			else {
    				pStmt.setString(1, "%");
    			}
    			if (param.getItem_id() != null) {
    				pStmt.setString(2, "%" + param.getItem_id() + "%");
    			}
    			else {
    				pStmt.setString(2, "%");
    			}
    			if (param.getItem_image() != null) {
    				pStmt.setString(3, "%" + param.getItem_image() + "%");
    			}
    			else {
    				pStmt.setString(3, "%");
    			}
    			if (param.getCategory() != null) {
    				pStmt.setString(4, "%" + param.getCategory() + "%");
    			}
    			else {
    				pStmt.setString(4, "%");
    			}
    			if (param.getBrand() != null) {
    				pStmt.setString(5, "%" + param.getBrand() + "%");
    			}
    			else {
    				pStmt.setString(5, "%");
    			}
    			if (param.getSize() != null) {
    				pStmt.setString(6, "%" + param.getSize() + "%");
    			}
    			else {
    				pStmt.setString(6, "%");
    			}
    			if (param.getFlag() != null) {
    				pStmt.setString(7, "%" + param.getFlag() + "%");
    			}
    			else {
    				pStmt.setString(7, "%");
    			}
    			if (param.getRemarks() != null) {
    				pStmt.setString(8, "%" + param.getRemarks() + "%");
    			}
    			else {
    				pStmt.setString(8, "%");
    			}
    			if (param.getDate() != null) {
    				pStmt.setString(9, "%" + param.getDate() + "%");
    			}
    			else {
    				pStmt.setString(9, "%");
    			}


    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				CoordinateItemModel card = new CoordinateItemModel(
    				rs.getString("user_id"),
    				rs.getString("item_id"),
    				rs.getString("item_image"),
    				rs.getString("category"),
    				rs.getString("brand"),
    				rs.getString("size"),
    				rs.getString("flag"),
    				rs.getString("remarks"),
    				rs.getString("date")
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


    		//アイテムを登録する 引数cardで指定されたレコードを登録し、成功したらtrueを返す(わからない、ここの登録データをどのデータベースにいれるか、入れる情報がわからない)
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

    				// SQL文を完成させる（追加）
        			if (card.getUser_id() != null) {
        				pStmt.setString(1, "%" + card.getUser_id() + "%");
        			}
        			else {
        				pStmt.setString(1, "%");
        			}
        			if (card.getItem_id() != null) {
        				pStmt.setString(2, "%" + card.getItem_id() + "%");
        			}
        			else {
        				pStmt.setString(2, "%");
        			}
        			if (card.getItem_image() != null) {
        				pStmt.setString(3, "%" + card.getItem_image() + "%");
        			}
        			else {
        				pStmt.setString(3, "%");
        			}
        			if (card.getCategory() != null) {
        				pStmt.setString(4, "%" + card.getCategory() + "%");
        			}
        			else {
        				pStmt.setString(4, "%");
        			}
        			if (card.getBrand() != null) {
        				pStmt.setString(5, "%" + card.getBrand() + "%");
        			}
        			else {
        				pStmt.setString(5, "%");
        			}
        			if (card.getSize() != null) {
        				pStmt.setString(6, "%" + card.getSize() + "%");
        			}
        			else {
        				pStmt.setString(6, "%");
        			}
        			if (card.getFlag() != null) {
        				pStmt.setString(7, "%" + card.getFlag() + "%");
        			}
        			else {
        				pStmt.setString(7, "%");
        			}
        			if (card.getRemarks() != null) {
        				pStmt.setString(8, "%" + card.getRemarks() + "%");
        			}
        			else {
        				pStmt.setString(8, "%");
        			}
        			if (card.getDate() != null) {
        				pStmt.setString(9, "%" + card.getDate() + "%");
        			}
        			else {
        				pStmt.setString(9, "%");
        			}


        			// SQL文を実行し、結果表を取得する
        			ResultSet rs = pStmt.executeQuery();


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

        			// 結果を返す(どのようにデータを返せばいいかわからない)
    			return result;

        		}



    	//コーディネイトアイテムの更新(フラグつける)
    	public boolean update(CoordinateItemModel card) {
    				Connection conn = null;
    				boolean result = false;

    				try {
    					// JDBCドライバを読み込む
    					Class.forName("org.h2.Driver");

    					// データベースに接続する
    					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    					// SQL文を準備する
    					String sql = "update used_item set item_id = ?";
    					PreparedStatement pStmt = conn.prepareStatement(sql);

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
    					if (card.getDate() != null && !card.getDate().equals("")) {
    						pStmt.setString(8, card.getDate());
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
    				// 結果を返す
    				return result;
    			}
    	}
   }

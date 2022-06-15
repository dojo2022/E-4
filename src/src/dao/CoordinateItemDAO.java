package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import model.CoordinateItemModel;

/**
 * Servlet implementation class Coordinate_ItemDAO
 */
@WebServlet("/CoordinateItemDAO")
public class CoordinateItemDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoordinateItemDAO() {

       	//コーディネイト一覧からコーディネイトidを受けて使用アイテムまとまりを表示する（型や()の中に何を書いたらいいかわからない）
    	public List<CoordinateItemModel> select(CoordinateItemModel param) {
    		Connection conn = null;
    		List<CoordinateItemModel> cardList = new ArrayList<CoordinateItemModel>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    			// SQL文を準備(コーディネイトからアイテムのまとまりを探す)(修正)
    			String sql = "select item_id,item_image,category,brand,size from item where item_id = ? item_image = ? category = ? brand = ? size = ? and ";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
    			if (param.getItem_id() != null) {
    				pStmt.setString(1, "%" + param.getItem_id() + "%");
    			}
    			else {
    				pStmt.setString(1, "%");
    			}
    			if (param.getItem_image() != null) {
    				pStmt.setString(2, "%" + param.getItem_image() + "%");
    			}
    			else {
    				pStmt.setString(2, "%");
    			}
    			if (param.getCategory() != null) {
    				pStmt.setString(3, "%" + param.getCategory() + "%");
    			}
    			else {
    				pStmt.setString(3, "%");
    			}
    			if (param.getBrand() != null) {
    				pStmt.setString(4, "%" + param.getBrand() + "%");
    			}
    			else {
    				pStmt.setString(4, "%");
    			}
     			if (param.getSize() != null) {
    				pStmt.setString(5, "%" + param.getSize() + "%");
    			}
    			else {
    				pStmt.setString(5, "%");
    			}


    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				CoordinateItemModel card = new CoordinateItemModel(
    				rs.getString("item_id"),
    				rs.getString("item_image"),
    				rs.getString("category"),
    				rs.getString("brand"),
    				rs.getString("size"),
    				);
    				cardList.add(card);//ここよくわからない
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
    			return cardList;//

    		}

    		//コーディネイトアイテムを登録する 引数cardで指定されたレコードを登録し、成功したらtrueを返す
    		public boolean insert(CoordinateItemModel card) {
    			Connection conn = null;
    			boolean result = false;

    			try {
    				// JDBCドライバを読み込む
    				Class.forName("org.h2.Driver");

    				// データベースに接続する
    				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    				// SQL文を準備する
    				String sql = "insert into used_item (user_id,item_id,item_image,category, brand,size) values (?, ?, ?, ?, ?, ?)";
    				PreparedStatement pStmt = conn.prepareStatement(sql);



    			}
    	//コーディネイトアイテムの更新
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

    					// SQL文を完成させる
    					if (card.getused_item() != null && !card.getused_item().equals("")) {
    						pStmt.setString(1, card.getused_item());
    					}
    					else {
    						pStmt.setString(1, null);
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

    	//コーディネイト削除
    			public boolean delete(String number) {
    				Connection conn = null;
    				boolean result = false;

    				try {
    					// JDBCドライバを読み込む
    					Class.forName("org.h2.Driver");

    					// データベースに接続する
    					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    					// SQL文を準備する
    					String sql = "delete from used_item where coordinate_id =?";
    					PreparedStatement pStmt = conn.prepareStatement(sql);

    				}
    			}
    			// SQL文を完成させる
    			pStmt.setString(1, coordinate_id);

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

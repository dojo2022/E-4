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

import model.Bc;

/**
 * Servlet implementation class Coordinate_ItemDAO
 */
@WebServlet("/Coordinate_ItemDAO")
public class CoordinateItemDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoordinateItemDAO() {

       	//コーディネイト一覧からコーディネイトidを受けて使用アイテムまとまりを表示する（型や()の中に何を書いたらいいかわからない）
    	public List<used_item> select(used_item param) {
    		Connection conn = null;
    		List<CI> cardList = new ArrayList<CI>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    			// SQL文を準備(コーディネイトからアイテムのまとまりを探す)
    			String sql = "select coordinate_id";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

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

    		//コーディネイトアイテムを登録する 引数cardで指定されたレコードを登録し、成功したらtrueを返す
    		public boolean insert(CI card) {
    			Connection conn = null;
    			boolean result = false;

    			try {
    				// JDBCドライバを読み込む
    				Class.forName("org.h2.Driver");

    				// データベースに接続する
    				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

    				// SQL文を準備する
    				String sql = "insert into used_item (NUMBER,CORP,DIVISION,POSITION, NAME,TEL,PHONE,MAIL, ADDRESS) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    				PreparedStatement pStmt = conn.prepareStatement(sql);



    			}
    	//コーディネイトアイテムの更新
    			public boolean update(Bc card) {
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
    			pStmt.setString(2, coordinate_id);

    			// SQL文を実行する
    			if (pStmt.executeUpdate() == 2) {
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

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CoordinateModel;

public class CoordinateDAO{
	//季節にあった服装をランダムで選択する。
	public List<CoordinateModel> select(CoordinateModel param) {
		Connection conn = null;
		List<CoordinateModel> coordinateList = new ArrayList<CoordinateModel>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SELECT文を準備する
			String sql ="select top(3) USER_ID, COORDINATE_ID, SEAAON, PURPOSE, COORDINATE_IMAGE from COORDINATE where SEASON = ? and PURPOSE = bussines";
			String sql2 ="select top(3) USER_ID, COORDINATE_ID, SEAAON, PURPOSE, COORDINATE_IMAGE from COORDINATE where SEASON = ? and PURPOSE = private";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を完成させる
			if(param.getSeason() != null) {
				pStmt.setString(1,param.getSeason());
				pStmt2.setString(1,param.getSeason());
			}
			else {
				pStmt.setString(1, "%");
				pStmt2.setString(1, "%");
			}



			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			ResultSet rs2 = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CoordinateModel card = new CoordinateModel(
				rs.getString("user_id"),
				rs.getString("coordinate_id"),
				rs.getString("SEASON"),
				rs.getString("purpose"),
				rs.getString("COORDINATE_IMAGE")
				);
				coordinateList.add(card);

				CoordinateModel card2 = new CoordinateModel(
				rs2.getString("user_id"),
				rs2.getString("coordinate_id"),
				rs2.getString("SEASON"),
				rs2.getString("purpose"),
				rs2.getString("COORDINATE_IMAGE")
				);
				coordinateList.add(card2);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			coordinateList = null;
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			coordinateList = null;
		}

			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						coordinateList = null;
					}
				}
			}

		// 結果を返す
				return coordinateList;




	}






	//コーディネートの登録
	public boolean insert(CoordinateModel card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "insert into COORDINATE (USER_ID, COORDINATE_ID, SEASON, PURPOSE, COORDINATE_IMAGE) values (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}

			if (card.getCoordinate_id() != null && !card.getCoordinate_id().equals("")) {
				pStmt.setString(2, card.getCoordinate_id());
			}
			else {
				pStmt.setString(2, null);
			}

			if (card.getSeason() != null && !card.getSeason().equals("")) {
				pStmt.setString(3, card.getSeason());
			}
			else {
				pStmt.setString(3, null);
			}

			if (card.getPurpose() != null && !card.getPurpose().equals("")) {
				pStmt.setString(4, card.getPurpose());
			}
			else {
				pStmt.setString(4, null);
			}

			if (card.getCoordinate_image() != null && !card.getCoordinate_image().equals("")) {
				pStmt.setString(5, card.getCoordinate_image());
			}
			else {
				pStmt.setString(5, null);
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




	// コーディネートの削除
	public boolean delete(String coodinate_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "delete from COORDINATE where COORDINATE_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, coodinate_id);

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


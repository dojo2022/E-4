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
			String sql ="select top(3) COORDINATE_ID, COORDINATE from COORDINATE where SEASON = ? and PURPOSE = bussines";
			String sql2 ="select top(3) COORDINATE_ID, COORDINATE from COORDINATE where SEASON = ? and PURPOSE = private";
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
				rs.getString("COORDINATE_ID"),
				rs.getString("COORDINATE_IMAGE")
				);
				coordinateList.add(card);

				CoordinateModel card2 = new CoordinateModel(
				rs2.getString("COORDINATE_ID"),
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
}





//引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(CoordinateModel card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "insert into COORDINATE (USER_ID, COORDINATE_ID, SEASON, ) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getNumber() != null && !card.getNumber().equals("")) {
				pStmt.setString(1, card.getNumber());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getName() != null && !card.getName().equals("")) {
				pStmt.setString(2, card.getName());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(3, card.getAddress());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getTell() != null && !card.getTell().equals("")) {
				pStmt.setString(4, card.getTell());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getGender() != null && !card.getGender().equals("")) {
				pStmt.setString(5, card.getGender());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getEmail() != null && !card.getEmail().equals("")) {
				pStmt.setString(6, card.getEmail());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(7, card.getCompany());
			}
			else {
				pStmt.setString(7, null);
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

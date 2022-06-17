package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CoordinateAndItemModel;

public class CoordinateDAO2 {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<CoordinateAndItemModel> select(CoordinateAndItemModel param) {
		Connection conn = null;
		List<CoordinateAndItemModel> CoordinateList = new ArrayList<CoordinateAndItemModel>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "SELECT c.coordinate_id, season, purpose, coordinate_image, i.item_id, item_image, category, brand, size, remarks "
					 + "FROM used_item u RIGHT JOIN coordinate c ON u.coordinate_id = c.coordinate_id RIGHT JOIN item i ON u.item_id = i.item_id "
					 + "WHERE user_id LIKE ? AND coordinate_id LIKE ? AND season LIKE ? AND purpose LIKE ? AND item_id LIKE ? "
					 + "AND category LIKE ? OR brand LIKE ? OR size LIKE ? OR remarks LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getCoordinate_id() != null) {
				pStmt.setString(2, param.getCoordinate_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getSeason() != null) {
				pStmt.setString(3, "%" + param.getSeason() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getPurpose() != null) {
				pStmt.setString(4, "%" + param.getPurpose() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getItem_id() != null) {
				pStmt.setString(5, param.getItem_id());
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getCategory() != null) {
				pStmt.setString(6, "%" + param.getCategory() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}
			if (param.getBrand() != null) {
				pStmt.setString(7, "%" + param.getBrand() + "%");
			}
			else {
				pStmt.setString(7, "%");
			}
			if (param.getSize() != null) {
				pStmt.setString(8, "%" + param.getSize() + "%");
			}
			else {
				pStmt.setString(8, "%");
			}
			if (param.getRemarks() != null) {
				pStmt.setString(9, "%" + param.getRemarks() + "%");
			}
			else {
				pStmt.setString(9, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CoordinateAndItemModel Coordinate = new CoordinateAndItemModel(
						rs.getString("user_id"),
						rs.getString("coordinate_id"),
						rs.getString("season"),
						rs.getString("purpose"),
						rs.getString(""),
						rs.getString("item_id"),
						rs.getString(""),
						rs.getString("category"),
						rs.getString("brand"),
						rs.getString("size"),
						rs.getString(""),
						rs.getString("remarks")
				);
				CoordinateList.add(Coordinate);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			CoordinateList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			CoordinateList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					CoordinateList = null;
				}
			}
		}

		// 結果を返す
		return CoordinateList;
	}
}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Coordinate;
import model.CoordinateInsertModel;
import model.CoordinateModel;

public class CoordinateDAO{
	//季節にあった服装をランダムで3件ずつ選択する。
	//日付取得CAST(GETDATE() as date)、日付に関するソート　 DATE_SUB(CAST(GETDATE() as date), INTERVAL 3 DAY)
	public List<Coordinate> homeSelectB(Coordinate param) {
		Connection conn = null;
		List<Coordinate> coordinateListB = new ArrayList<Coordinate>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SELECT文を準備する
			String sql ="select COORDINATE.USER_ID, COORDINATE.COORDINATE_ID, PURPOSE, COORDINATE_IMAGE, day "
					+ "FROM ((COORDINATE left outer join USED_ITEM on COORDINATE.COORDINATE_ID = USED_ITEM.COORDINATE_ID) left outer join ITEM on USED_ITEM.ITEM_ID = ITEM.ITEM_ID) "
					+ "where USED_ITEM.user_id LIKE ? AND SEASON like ? and PURPOSE = 'ビジネス' or USED_ITEM.user_id LIKE ? AND SEASON like ? and PURPOSE = '兼用' ORDER BY RAND() LIMIT 3";
			//SQLで日付取得
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if(param.getSeason() != null) {
				pStmt.setString(2,"%" + param.getSeason() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getUser_id() != null) {
				pStmt.setString(3, param.getUser_id());
			}
			else {
				pStmt.setString(3, "%");
			}
			if(param.getSeason() != null) {
				pStmt.setString(4,"%" + param.getSeason() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Coordinate card = new Coordinate(
				param.getUser_id(),
				rs.getString("coordinate_id"),
				param.getSeason(),
				rs.getString("purpose"),
				rs.getString("coordinate_image")
				);
				coordinateListB.add(card);

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			coordinateListB = null;
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			coordinateListB = null;
		}

			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						coordinateListB = null;
					}
				}
			}
		// 結果を返す
				return coordinateListB;
	}

	public List<Coordinate> homeSelectP(Coordinate param) {
		Connection conn = null;
		List<Coordinate> coordinateListP = new ArrayList<Coordinate>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SELECT文を準備する
			String sql ="select COORDINATE.USER_ID, COORDINATE.COORDINATE_ID, PURPOSE, COORDINATE_IMAGE, day "
					+ "FROM ((COORDINATE left outer join USED_ITEM on COORDINATE.COORDINATE_ID = USED_ITEM.COORDINATE_ID) left outer join ITEM on USED_ITEM.ITEM_ID = ITEM.ITEM_ID) "
					+ "where USED_ITEM.user_id LIKE ? AND SEASON like ? and PURPOSE = 'プライベート' or USED_ITEM.user_id LIKE ? AND SEASON like ? and PURPOSE = '兼用' ORDER BY RAND() LIMIT 3";
			//SQLで日付取得
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if(param.getSeason() != null) {
				pStmt.setString(2,"%" + param.getSeason() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getUser_id() != null) {
				pStmt.setString(3, param.getUser_id());
			}
			else {
				pStmt.setString(3, "%");
			}
			if(param.getSeason() != null) {
				pStmt.setString(4,"%" + param.getSeason() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Coordinate card = new Coordinate(
				param.getUser_id(),
				rs.getString("coordinate_id"),
				param.getSeason(),
				rs.getString("purpose"),
				rs.getString("coordinate_image")
				);
				coordinateListP.add(card);

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			coordinateListP = null;
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			coordinateListP = null;
		}

			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						coordinateListP = null;
					}
				}
			}
		// 結果を返す
				return coordinateListP;
	}

	public List<Coordinate> CoordinateSearch(Coordinate param) {
		Connection conn = null;
		List<Coordinate> CoordinateList = new ArrayList<Coordinate>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "SELECT coordinate_id, season, purpose, coordinate_image "
					 + "FROM coordinate WHERE user_id LIKE ? AND coordinate_id LIKE ? AND season LIKE ? AND purpose LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getCoordinate_id() != null) {
				pStmt.setString(2, "%" + param.getCoordinate_id() + "%");
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
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Coordinate Coordinate = new Coordinate(
						param.getUser_id(),
						rs.getString("coordinate_id"),
						rs.getString("season"),
						rs.getString("purpose"),
						rs.getString("coordinate_image")
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


	//コーディネートの検索(広渕さんやってくれてる）
	//日付取得CAST(GETDATE() as date)
	public List<CoordinateModel> search(CoordinateModel param) {
		Connection conn = null;
		List<CoordinateModel> CoordinateList = new ArrayList<CoordinateModel>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "SELECT c.coordinate_id, season, purpose, coordinate_image, i.item_id, item_image, category, brand, size, flag, remarks, day "
					 + "FROM used_item u RIGHT JOIN coordinate c ON u.coordinate_id = c.coordinate_id RIGHT JOIN item i ON u.item_id = i.item_id "
					 + "WHERE u.user_id LIKE ? AND c.coordinate_id LIKE ? AND season LIKE ? AND purpose LIKE ? AND i.item_id LIKE ? "
					 + "AND remarks LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1,param.getUser_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getCoordinate_id() != null) {
				pStmt.setString(2,param.getCoordinate_id());
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
				pStmt.setString(5, "%" + param.getItem_id() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getRemarks() != null) {
				pStmt.setString(6, "%" + param.getRemarks() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				CoordinateModel Coordinate = new CoordinateModel(
						param.getUser_id(),
						rs.getString("coordinate_id"),
						rs.getString("season"),
						rs.getString("purpose"),
						rs.getString("coordinate_image"),
						rs.getString("item_id"),
						rs.getString("item_image"),
						rs.getString("category"),
						rs.getString("brand"),
						rs.getString("size"),
						rs.getString("flag"),
						rs.getString("remarks"),
						rs.getString("day")
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


	//コーディネートの登録
	public boolean insert(CoordinateInsertModel card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

			// SQL文を準備する
			String sql = "insert into COORDINATE(USER_ID,COORDINATE_ID,SEASON,PURPOSE,COODINATE_IMAGE) values (?, ?, ?, ?, ?)";
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




	//コーディネートの削除
		public boolean delete(Coordinate Coordinate_ID) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/CCC", "sa", "ccc");

				// SQL文を準備する
				String sql = "delete from coordinate where user_id=? and COORDINATE_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, Coordinate_ID.getUser_id());
				pStmt.setString(2, Coordinate_ID.getCoordinate_id());

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


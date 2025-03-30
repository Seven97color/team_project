package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.TweetBean;

public class TweetDAO {
	/**
	 * tweetリスト取得する
	 * @return tweetリスト
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<TweetBean> getTweetList() throws ClassNotFoundException, SQLException {
		// リストの初期化
		List<TweetBean> tweetList = new ArrayList<>();

		// SQL文
		String sql = "SELECT id, name, message, update_date FROM tweet";

		// データベース接続
		// PreparedStatementでSQL実行の準備
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// SQL実行し、実行結果の表と現在の行を指しているカーソルを取得
			ResultSet res = pstmt.executeQuery();

			// 実行結果の表から順番に値を取得
			// nextでカーソルを1行ずつ移動させる
			while (res.next()) {
				int id = res.getInt("id"); // tweetテーブルidカラムの値
				String name = res.getString("name"); // tweetテーブルnameカラムの値
				String message = res.getString("message"); // tweetテーブルmessageカラムの値
				Date updateDate = res.getDate("update_date"); // tweetテーブルupdate_dateカラムの値

				// DBから取得した値を初期値として、TweetBeanのインスタンス生成
				TweetBean todo = new TweetBean(id, name, message, updateDate);

				// tweetListにインスタンスを追加
				tweetList.add(todo);
			}
		}
		return tweetList;
	}
}


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TweetDTO;
import util.DBConnector;

public class TweetDAO {

	public int insert(String loginId,String userName,String title,String text){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql="insert into tweet(user_id,user_name,title,text,update_date) values(?,?,?,?,now())";
		int count = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, userName);
			ps.setString(3, title);
			ps.setString(4, text);

			System.out.println(loginId);
			System.out.println(userName);
			System.out.println(title);
			System.out.println(text);

			count = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	public List<TweetDTO> getTweet(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql ="select user_name,title,text from tweet";

		List<TweetDTO> tweetList = new ArrayList<TweetDTO>();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//データベースのデータを列ごとにdtoに入れて取得
			while(rs.next()){
				TweetDTO dto = new TweetDTO();
				dto.setUserName(rs.getString("user_name"));
				dto.setText(rs.getString("text"));
				dto.setTitle(rs.getString("title"));
				tweetList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tweetList;

	}
}

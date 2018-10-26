package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.UserInfoDTO;
import util.DBConnector;

public class UserDAO {

	public int Login(String loginId,String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update user_info set logined=1 where user_id=? and password=?";
		int result =0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;

	}

	public int Logout(String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update user_info set logined=0 where user_id=?";
		int result =0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;

	}

	public UserInfoDTO getUserInfo(String loginId,String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from user_info where user_id=? and password=?";
		UserInfoDTO dto = new UserInfoDTO();

		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			//データベースから取り出したユーザーデータをUserInfoDTOへ
			if(rs.next()){
				dto.setUserName(rs.getString("user_name"));
				dto.setLoginId(rs.getString("user_id"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	public int createUser(String loginId,String password,String userName){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into user_info(user_id,password,user_name,logined) values(?,?,?,?)";
		int count = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, userName);
			ps.setInt(4, 1);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public List<UserInfoDTO> getUserNames(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from user_info";
		List<UserInfoDTO> uidtoList = new ArrayList<UserInfoDTO>();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				UserInfoDTO uidto = new UserInfoDTO();
				uidto.setUserName(rs.getString("user_name"));
				uidtoList.add(uidto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return uidtoList;

	}

}

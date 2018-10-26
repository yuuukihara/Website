package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.UserInfoDTO;
import util.DBConnector;

public class createUserDAO {

	public int createUser(String loginId,String userName,String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count=0;
		String sql = "insert into user_info(user_id,user_name,password)values(?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, userName);
			ps.setString(3, password);
			count = ps.executeUpdate();

			if(count>0){
				UserInfoDTO dto = new UserInfoDTO();
				dto.setLoginId(loginId);
				dto.setPassword(password);
				dto.setUserName(userName);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}

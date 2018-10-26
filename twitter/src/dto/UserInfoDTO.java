package dto;

public class UserInfoDTO {

	private String loginId;
	private String password;
	private String userName;
	private int loginFlg;

	public String getloginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public int getLoginFlg(){
		return loginFlg;
	}

	public void setLoginFlg(int loginFlg){
		this.loginFlg = loginFlg;
	}

}

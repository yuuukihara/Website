package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import util.InputChecker;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String loginId;
	private String password;
	private String userName;

	public String execute(){

		InputChecker ic = new InputChecker();
		if(ic.doCheck("loginId", loginId, 1, 16)=="成功" && ic.doCheck("password", password, 1, 16)=="成功" && ic.doCheck("userName", userName, 1, 16)=="成功"){
			session.put("loginId",loginId);
			session.put("password", password);
			session.put("userName", userName);
			session.put("logined", 1);
			return SUCCESS;
		}
		return ERROR;
	}

	public String getLoginId(){
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


	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}

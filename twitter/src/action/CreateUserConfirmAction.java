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
	private String errorMassage;

	public String execute(){

		String result;

		//エラーチェック、文字数が適切ならnullを返す
		InputChecker ip = new InputChecker();
		errorMassage = ip.doCreateUserCheck(loginId, password, userName);

		if(errorMassage==null){
			session.put("loginId",loginId);
			session.put("password", password);
			session.put("userName", userName);
			session.put("logined", 1);
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
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

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}

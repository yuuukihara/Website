package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){

		String result;
		int count = 0;

		//データベースに新規登録＆ログインフラグを立てる
		UserDAO dao = new UserDAO();
		count = dao.createUser(String.valueOf(session.get("loginId")), String.valueOf(session.get("password")), String.valueOf(session.get("userName")));
		result = SUCCESS;


		return result;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}

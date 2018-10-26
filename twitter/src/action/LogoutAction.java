package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;

public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){

		String result;
		int count = 0;
		UserDAO dao = new UserDAO();

		//loginedフラグを0へ
		count = dao.Logout(String.valueOf(session.get("loginId")));
		System.out.println(String.valueOf(session.get("loginId")));

		//sessionを削除
		session.clear();
		result = SUCCESS;

		return result;
	}
	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}

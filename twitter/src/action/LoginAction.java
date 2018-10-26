package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){

		String result = ERROR;

		//ログインしていない時
		if(!session.containsKey("loginId")){
			result = SUCCESS;
		}
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

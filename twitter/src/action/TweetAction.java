package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TweetAction extends ActionSupport implements SessionAware{

	private String text;
	private String title;
	private Map<String, Object> session;

	public String execute(){

		String result = SUCCESS;

		if(!session.containsKey("loginId")){
			result = ERROR;
		}
		return result;
	}

	public String getText(){
		return text;
	}
	public void setText(String Text){
		this.text = Text;
	}

	public String getTitle(){
		return title;
	}
	public void setTitle(String Title){
		this.title = Title;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}

package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;
import dto.UserInfoDTO;

public class SeeUserInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){
		String result;

		//ログインしていなければloginActionに飛ばす
		if(!session.containsKey("loginId")){
			return ERROR;
		}

		//ユーザー名一覧を取得
		List<UserInfoDTO> uidtoList = new ArrayList<UserInfoDTO>();
		UserDAO udao = new UserDAO();
		uidtoList = udao.getUserNames();
		session.put("uidtoList", uidtoList);
		result = SUCCESS;

		return result;

	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}

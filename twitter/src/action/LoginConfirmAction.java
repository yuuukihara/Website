package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;
import dto.UserInfoDTO;
import util.InputChecker;

public class LoginConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String loginId;
	private String password;
	private String checkMassage;

	public String execute(){

		String result;
		UserDAO udao = new UserDAO();

		//入力された値の文字数が正しいかをチェック
		InputChecker ic = new InputChecker();
		checkMassage = ic.doLoginCheck(loginId, password);

		//文字数制限に引っかかったらエラー文、引っかからない場合nullを返す
		if(checkMassage==null){

			//アカウントが存在するかを確認.確認できたらフラグを立てる
			int count = udao.Login(loginId, password);
			//ログイン出来たかを確認
			if(count>0){
				//ログインに成功したら1を入れる
				session.put("logined", 1);
				//ログイン中のアカウント情報(userName,loginId)を取り出し、userInfoDTOへセットそしてDTO型で返す
				UserInfoDTO uidto = new UserInfoDTO();
				uidto = udao.getUserInfo(loginId,password);

				//UserInfoDTOにセットした値をsessionでput
				session.put("loginId",uidto.getloginId());
				session.put("userName", uidto.getUserName());
				result = SUCCESS;
			}else{
				result = ERROR;
			}
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

	public Map<String, Object> getSession(){
		return session;
	}

	public String getCheckMassage() {
		return checkMassage;
	}

	public void setCheckMassage(String checkMassage) {
		this.checkMassage = checkMassage;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}

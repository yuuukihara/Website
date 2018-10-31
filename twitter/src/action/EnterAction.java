package action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.TweetDAO;
import dto.TweetDTO;

public class EnterAction extends ActionSupport implements SessionAware{

	private Map<String, Object>session;

	public String execute(){

		String result = SUCCESS;

		//商品確認画面で戻るを押した時にCreateUserConfirmで入れたsessionを消してホームへ返す
		if(session.containsKey("loginId")){
			session.remove("loginId");
			session.remove("password");
			session.remove("userName");
			session.remove("logined");
			session.remove("errorMassage");
		}
		//つぶやきをput
		List<TweetDTO> tweetDTOList = new ArrayList<TweetDTO>();
		TweetDAO tdao = new TweetDAO();
		tweetDTOList = tdao.getTweet();
		Collections.reverse(tweetDTOList);
		session.put("tweetDTOList",tweetDTOList);

		//EnterActionを使う時はログインしていないので、loginedに０を入れている
		session.put("logined",0);

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

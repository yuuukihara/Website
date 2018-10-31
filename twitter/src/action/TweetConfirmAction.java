package action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.TweetDAO;
import dto.TweetDTO;
import util.InputChecker;

public class TweetConfirmAction extends ActionSupport implements SessionAware{

	private String text;
	private String title;
	private Map<String, Object> session;
	private String ErrorMassage = "";

	public String execute(){

		String result=ERROR;

		//エラーチェック
		InputChecker ip = new InputChecker();
		String errorMassage = ip.doTweetCheck(title,text);

		//入力した値が文字数制限に引っかかった場合
		if(!(errorMassage.equals(""))){
			if(session.containsKey("errorMassage")){
				session.remove("errorMassage");
			}
			session.put("errorMassage", errorMassage);
			result = ERROR;
		}else{
			//データベースにタイトルと本文を格納(引数は:loginId,userName,title,text)
			TweetDAO tweetDAO = new TweetDAO();
			int count = tweetDAO.insert(String.valueOf(session.get("loginId")),String.valueOf(session.get("userName")), title, text);

			//データベースに呟きが格納されたら
			if(count>0){

				List<TweetDTO> tweetDTOList = new ArrayList<TweetDTO>();
				tweetDTOList = tweetDAO.getTweet();

				//Listを逆に
				Collections.reverse(tweetDTOList);
				session.put("tweetDTOList", tweetDTOList);
				result = SUCCESS;
			}
		}
		return result;
	}

	public String getErrorMassage(){
		return ErrorMassage;
	}

	public void setErrorMassage(String ErrorMassage){
		this.ErrorMassage = ErrorMassage;
	}

	public String getText(){
		return text;
	}
	public void setText(String text){
		this.text = text;
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
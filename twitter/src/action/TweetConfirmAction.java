package action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.TweetDAO;
import dto.TweetDTO;

public class TweetConfirmAction extends ActionSupport implements SessionAware{

	private String text;
	private String title;
	private Map<String, Object> session;
	private List<TweetDTO> tweetDTOList = new ArrayList<TweetDTO>();
	private String ErrorMassage = "";

	public String execute(){

		String result = ERROR;

		//エラーチェック
		if(title=="" && text==""){
			ErrorMassage += "タイトルと本文が記入されていません";
		}else if(title.length()<1){
			ErrorMassage += "タイトルが記入されていません";
		}else if(text.length() <1){
			ErrorMassage += "本文が記入されていません";
		}

		if(title.length()>15 && text.length() >140){
			ErrorMassage += "タイトルを15文字以内、本文を140字以内で書き込んでください";
		}else if(title.length()>15){
			ErrorMassage += "タイトルを15文字以内で書き込んでください";
		}else if(text.length() >140){
			ErrorMassage += "本文は140字以内で書き込んでください";
		}


		//title15字以内で、かつ、本文が140字以内の場合
		if(title.length()<=15 && text.length() <=140){

			//データベースにタイトルと本文を格納(引数は:loginId,userName,title,text)
			TweetDAO tweetDAO = new TweetDAO();
			int count = tweetDAO.insert(String.valueOf(session.get("loginId")),String.valueOf(session.get("userName")), title, text);

			//データベースに呟きが格納されたら
			if(count>0){

				//フィールドでインスタンス化しとる
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

	public List<TweetDTO> getTweetDTOList(){
		return tweetDTOList;
	}

	public void setTweetDTOList(List<TweetDTO> tweetDTOList){
		this.tweetDTOList = tweetDTOList;
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
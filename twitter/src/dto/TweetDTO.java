package dto;

public class TweetDTO {

	private String userName;
	private String loginId;
	private String text;
	private String title;

	public String getloginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getText(){
		return text;
	}
	public void setText(String Text){
		this.text = Text;
	}

}

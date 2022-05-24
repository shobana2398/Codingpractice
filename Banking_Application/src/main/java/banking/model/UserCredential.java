package banking.model;

public class UserCredential {
	private int userid;
	private String password;
	public UserCredential()
	{
		
	}
	public UserCredential(int userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

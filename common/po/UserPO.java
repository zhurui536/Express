package po;

/**
 * Created by Away
 * 2015/10/26
 */

public class UserPO {
	private String id;
	private String password;
	
	public UserPO(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	public String getid(){
		return this.id;
	}
	
	public String getPassword(){
		return this.password;
	}
}

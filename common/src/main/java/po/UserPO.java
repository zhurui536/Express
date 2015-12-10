package po;

import java.io.Serializable;

/**
 * Created by Away
 * 2015/10/26
 */

public class UserPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -411840993352320771L;
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

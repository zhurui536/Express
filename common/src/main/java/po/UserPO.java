package po;

import java.io.Serializable;

import util.AuthorityLevel;

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
	private String staffid;
	private AuthorityLevel lv;
	
	public UserPO(String id, String password, String staffid, AuthorityLevel lv){
		this.id = id;
		this.password = password;
		this.staffid = staffid;
		this.lv = lv;
	}
	
	public String getid(){
		return this.id;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getStaffid(){
		return this.staffid;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setStaffid(String id){
		this.staffid = id;
	}
	
	public void setLevel(AuthorityLevel lv){
		this.lv = lv;
	}
	
	public AuthorityLevel getLevel(){
		return this.lv;
	}
}

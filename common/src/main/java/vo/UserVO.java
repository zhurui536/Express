package vo;

import po.UserPO;
import util.AuthorityLevel;

/**
 * Created by Away
 * 2015/10/26
 */

public class UserVO {
	private String userid;
	private String staffid;
	private String password;
	private AuthorityLevel lv;
	
	public UserVO(UserPO user){
		this.userid = user.getid();
		this.staffid = user.getStaffid();
		this.password = user.getPassword();
		this.lv = user.getLevel();
	}
	
	public UserVO(String userid, String staffid, String password, AuthorityLevel lv){
		this.userid = userid;
		this.staffid = staffid;
		this.password = password;
		this.lv = lv;
	}

	public String getUserid() {
		return userid;
	}

	public String getStaffid() {
		return staffid;
	}

	public String getPassword() {
		return password;
	}
	
	public AuthorityLevel getLevel(){
		return lv;
	}
}

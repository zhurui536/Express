package vo;

import po.UserPO;

/**
 * Created by Away
 * 2015/10/26
 */

public class UserVO {
	private String userid;
	private String staffid;
	private String password;
	
	public UserVO(UserPO user){
		this.userid = user.getid();
		this.staffid = user.getStaffid();
		this.password = user.getPassword();
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
}

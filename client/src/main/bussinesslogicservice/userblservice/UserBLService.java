package main.bussinesslogicservice.userblservice;

import main.bussinesslogic.util.ResultMessage;
/*
 * Created By ZHR
 * 2015/10/26
 */
public interface UserBLService {
	public ResultMessage login(String id, String password);
}

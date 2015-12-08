package main.bussinesslogic.userbl;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.userblservice.UserBLService;

public class UserBLServiceImpl implements UserBLService {

	@Override
	public ResultMessage login(String id, String password) {
		if(id.equals(password)){
			return new ResultMessage("success", null);
		}
		
		return new ResultMessage("fail", null);
	}

}

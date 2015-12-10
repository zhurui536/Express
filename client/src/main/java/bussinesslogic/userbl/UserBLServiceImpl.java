package bussinesslogic.userbl;

import bussinesslogicservice.userblservice.UserBLService;
import util.ResultMessage;

public class UserBLServiceImpl implements UserBLService {

	@Override
	public ResultMessage login(String id, String password) {
		if(id.equals(password)){
			return new ResultMessage("success", null);
		}
		
		return new ResultMessage("fail", null);
	}

}

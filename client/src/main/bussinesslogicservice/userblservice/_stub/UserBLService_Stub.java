package main.bussinesslogicservice.userblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.userblservice.UserBLService;

public class UserBLService_Stub implements UserBLService{

	@Override
	public ResultMessage login(String id, String password) {
		// TODO Auto-generated method stub
		
		if(password.equals("10010")&&id.equals("10086")){
			System.out.println("correct password!");
			return new ResultMessage("success", null);
		}
		else{
			System.out.println("wrong password!");
			return new ResultMessage("fail", null);
		}
	}

}

package main.bussinesslogicservice.userblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.userblservice.UserBLService;

public class UserBLService_Stub implements UserBLService{

	@Override
	public ResultMessage login(long id, String password) {
		// TODO Auto-generated method stub
		long passwords = Long.parseLong(password);
		
		if(passwords-id == 1){
			System.out.println("correct password!");
			return new ResultMessage("success", null);
		}
		else{
			System.out.println("wrong password!");
			return new ResultMessage("fail", null);
		}
	}

}

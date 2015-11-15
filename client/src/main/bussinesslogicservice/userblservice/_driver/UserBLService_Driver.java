package main.bussinesslogicservice.userblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.userblservice.UserBLService;
import main.bussinesslogicservice.userblservice._stub.UserBLService_Stub;

public class UserBLService_Driver {
	public static void main(String[] args){
		UserBLService ubs = new UserBLService_Stub();
		
		drive(ubs);
	}

	public static void drive(UserBLService ubs){
		ResultMessage result = null;
		
		result = ubs.login("10010", "10011");
		System.out.println(result.getKey());
		
		result = ubs.login("10086", "10086");
		System.out.println(result.getKey());
	}
}

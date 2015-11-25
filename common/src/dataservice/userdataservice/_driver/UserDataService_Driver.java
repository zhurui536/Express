package dataservice.userdataservice._driver;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice._stub.UserDataService_Stub;
import main.bussinesslogic.util.ResultMessage;

public class UserDataService_Driver {
	public static void main(String[] args) throws RemoteException{
		UserDataService uds = new UserDataService_Stub();
		
		drive(uds);
	}
	public static void drive(UserDataService uds) throws RemoteException{
		ResultMessage result = null;
		
		result = uds.find(1001100000, "1001100001");
		System.out.println(result.getKey());
		
		result = uds.find(1001000000, "1001100001");
		System.out.println(result.getKey());
		
		result = uds.find(10086, "10086");
		System.out.println(result.getKey());
	}

}

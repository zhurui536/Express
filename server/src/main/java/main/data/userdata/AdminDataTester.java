package main.data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import util.AuthorityLevel;
import util.ResultMessage;

public class AdminDataTester {
	public static void main(String[] args){
		try {
			AdminDataServiceImpl test = new AdminDataServiceImpl();
			ArrayList<UserPO> users = new ArrayList<UserPO>();
			
			users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
			
			ResultMessage result = test.saveUser(users);
			
			System.out.println(result.getKey());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

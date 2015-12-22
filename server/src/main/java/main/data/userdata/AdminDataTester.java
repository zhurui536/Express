package main.data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import main.data.infodata.StaffMessageMaintenanceDataServiceImpl;
import po.StaffMessagePO;
import po.UserPO;
import util.AuthorityLevel;
import util.Job;
import util.ResultMessage;
import util.SalaryType;

public class AdminDataTester {
	public static void main(String[] args){
		try {
			AdminDataServiceImpl test = new AdminDataServiceImpl();
			ArrayList<UserPO> users = new ArrayList<UserPO>();
			
			users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
			
			ResultMessage result = test.saveUser(users);
			
			System.out.println(result.getKey());
			
			StaffMessageMaintenanceDataServiceImpl staffdata = new StaffMessageMaintenanceDataServiceImpl();
			staffdata.insert(new StaffMessagePO("141250212", "朱浩然", "admin", Job.MANAGER, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("admin", "admin", "admin", Job.ADMIN, SalaryType.MONTHLY, 0));
			System.out.println(result.getKey());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

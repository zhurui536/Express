package data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.infodata.InstitutionMessageMaintenanceDataServiceImpl;
import data.infodata.StaffMessageMaintenanceDataServiceImpl;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import po.InstitutionMessagePO;
import po.StaffMessagePO;
import po.UserPO;
import util.AuthorityLevel;
import util.City;
import util.InstitutionType;
import util.Job;
import util.ResultMessage;
import util.SalaryType;

public class AdminDataTester {
	
//	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		try {
			AdminDataServiceImpl test = new AdminDataServiceImpl();
			ArrayList<UserPO> users = new ArrayList<UserPO>();
			
			users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
			users.add(new UserPO("1", "1", "1", AuthorityLevel.HIGH));
			users.add(new UserPO("2", "2", "141250212", AuthorityLevel.HIGH));
			users.add(new UserPO("3", "3", "3", AuthorityLevel.HIGH));
			users.add(new UserPO("4", "4", "4", AuthorityLevel.HIGH));
			users.add(new UserPO("5", "5", "5", AuthorityLevel.HIGH));
			users.add(new UserPO("6", "6", "6", AuthorityLevel.HIGH));
			
			ResultMessage result = test.saveUser(users);
			
			System.out.println(result.getKey());

			StaffMessageMaintenanceDataServiceImpl staffdata = new StaffMessageMaintenanceDataServiceImpl();
			staffdata.insert(new StaffMessagePO("admin", "admin", "admin", Job.ADMIN, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("1", "1", "admin", Job.FINANCEMAN, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("141250212", "朱浩然", "admin", Job.MANAGER, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("3", "3", "admin", Job.COURIER, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("4", "4", "admin", Job.SALESOFOFFICE, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("5", "5", "admin", Job.SALESOFCENTRE, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("6", "6", "admin", Job.STOCKMAN, SalaryType.MONTHLY, 0));
			InstitutionMessageMaintenanceDataService institution = new InstitutionMessageMaintenanceDataServiceImpl();
			institution.insert(new InstitutionMessagePO("哈哈哈", "025000", InstitutionType.BUSINESS_HALL, City.BEIJING));
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
//		try {
//			InstitutionMessageMaintenanceDataService institution = new InstitutionMessageMaintenanceDataServiceImpl();
//			
//			ArrayList<InstitutionMessagePO> pos = (ArrayList<InstitutionMessagePO>) institution.get().getValue();
//			for(int i=0;i<pos.size();i++)
//				System.out.println(pos.get(i).getId()+" "+pos.get(i).getName() + " "+pos.get(i).getInstitutionType());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}

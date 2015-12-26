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
	private static final String PATH = "src/main/java/save/logisticsdata/sendBillPO.dat";
	
	public static void main(String[] args){
		try {
			AdminDataServiceImpl test = new AdminDataServiceImpl();
			ArrayList<UserPO> users = new ArrayList<UserPO>();
			
			users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
			users.add(new UserPO("1", "1", "1", AuthorityLevel.HIGH));
			ResultMessage result = test.saveUser(users);
			
			System.out.println(result.getKey());

			StaffMessageMaintenanceDataServiceImpl staffdata = new StaffMessageMaintenanceDataServiceImpl();
			staffdata.insert(new StaffMessagePO("141250212", "朱浩然", "admin", Job.MANAGER, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("admin", "admin", "admin", Job.ADMIN, SalaryType.MONTHLY, 0));
			staffdata.insert(new StaffMessagePO("1", "1", "admin", Job.FINANCEMAN, SalaryType.MONTHLY, 0));
			
			InstitutionMessageMaintenanceDataService institution = new InstitutionMessageMaintenanceDataServiceImpl();
			institution.insert(new InstitutionMessagePO("哈哈哈", "025000", InstitutionType.BUSINESS_HALL, City.BEIJING));
//			ReceivingDataServiceImpl receidata = new ReceivingDataServiceImpl();
//			PeopleMessagePO people = new PeopleMessagePO("朱浩然", "南京大学", "南京大学", "785693057", "785693057");
//			GoodsPO[] goods = new GoodsPO[10];
//			for(int i=0;i<10;i++){
//				goods[i] = new GoodsPO(141250212+i+"", "货物"+i, City.NANJING, City.BEIJING, 4, 6, PackageType.CARTONS, ExpressType.COURIER);
//				SendBillPO po = new SendBillPO(people, people, goods[i], "1222"+i, "141250212");
//				receidata.insertBill(po);
//			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

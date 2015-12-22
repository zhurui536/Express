package main.data.userdata;

import java.rmi.RemoteException;

import main.data.logisticsdata.ReceivingDataServiceImpl;
import po.GoodsPO;
import po.logisticpo.PeopleMessagePO;
import po.logisticpo.SendBillPO;
import util.ExpressType;
import util.PackageType;

public class AdminDataTester {
	private static final String PATH = "src/main/java/save/logisticsdata/sendBillPO.dat";
	
	public static void main(String[] args){
		try {
//			AdminDataServiceImpl test = new AdminDataServiceImpl();
//			ArrayList<UserPO> users = new ArrayList<UserPO>();
			
//			users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
			
//			ResultMessage result = test.saveUser(users);
			
//			System.out.println(result.getKey());
			

//			StaffMessageMaintenanceDataServiceImpl staffdata = new StaffMessageMaintenanceDataServiceImpl();
//			staffdata.insert(new StaffMessagePO("141250212", "朱浩然", "admin", Job.MANAGER, SalaryType.MONTHLY, 0));
//			staffdata.insert(new StaffMessagePO("admin", "admin", "admin", Job.ADMIN, SalaryType.MONTHLY, 0));
			ReceivingDataServiceImpl receidata = new ReceivingDataServiceImpl();
			PeopleMessagePO people = new PeopleMessagePO("朱浩然", "南京大学", "南京大学", "785693057", "785693057");
			GoodsPO[] goods = new GoodsPO[10];
			for(int i=0;i<10;i++){
				goods[i] = new GoodsPO(141250212+i+"", "货物"+i, "南京大学", "北京大学", 4, 6, PackageType.CARTONS, ExpressType.COURIER);
				SendBillPO po = new SendBillPO(people, people, goods[i], "1222"+i, "141250212");
				receidata.insertBill(po);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

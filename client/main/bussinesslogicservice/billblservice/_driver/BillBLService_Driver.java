package main.bussinesslogicservice.billblservice._driver;

import main.bussinesslogicservice.billblservice.BillBLService;
import main.bussinesslogicservice.billblservice._stub.BillBLService_Stub;
/**
 * Created By ZHR
 * 2015/10/26
 */
public class BillBLService_Driver {
	public static void main(String[] args){
		BillBLService bbls = new BillBLService_Stub();
		
		drive(bbls);
	}
	
	public static void drive(BillBLService bbls){
		
	}

}

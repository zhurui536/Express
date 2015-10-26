package main.dataservice.strategydataservice._drive;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;
import main.dataservice.strategydataservice.StrategyDataService;
import main.dataservice.strategydataservice._stub.StrategyDataService_Stub;
import main.po.StaffPO;


/**
 * Created by Wippy
 * 2015/10/26
 */

public class StrategyDataService_Driver {
	public static void main(String[] args) throws RemoteException{
		StrategyDataService sds = new StrategyDataService_Stub();
		
		drive(sds);
	}
	
	public static void drive(StrategyDataService sds) throws RemoteException{
		ResultMessage result = null;
		
		result = sds.find(1111111111);
		System.out.println(result.getKey());
		

	}

}

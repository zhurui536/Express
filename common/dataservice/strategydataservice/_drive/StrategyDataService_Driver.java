package dataservice.strategydataservice._drive;

import java.rmi.RemoteException;

import dataservice.strategydataservice._stub.StrategyDataService_Stub;
import dataservice.strategydataservice.StrategyDataService;


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
		

	}

}

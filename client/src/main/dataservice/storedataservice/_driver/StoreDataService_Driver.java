package main.dataservice.storedataservice._driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.dataservice.storedataservice.StoreDataService;
import main.dataservice.storedataservice._stub.StoreDataService_Stub;
import main.po.AdjustPO;
import main.po.InStorePO;
import main.po.OutStorePO;
import main.po.StorePlacePO;
import main.po.VerificationPO;

public class StoreDataService_Driver {
	public static void main(String[] args) throws RemoteException{
		StoreDataService sds = new StoreDataService_Stub();
		
		drive(sds);
	}
	
	public static void drive(StoreDataService sds) throws RemoteException{
		ResultMessage result = null;
		
		result = sds.find(1111111111);
		System.out.println(result.getKey());
		
		result = sds.find(new StorePlacePO(1, 1, 2, 2));
		System.out.println(result.getKey());
		
		result = sds.delete(null);
		System.out.println(result.getKey());
		
		result = sds.update(new StorePlacePO(1, 1, 2, 2), null);
		System.out.println(result.getKey());
		
		ArrayList<InStorePO> ipo = new ArrayList<InStorePO>();
		ipo.add(new InStorePO());
		result = sds.saveInStore(ipo);
		System.out.println(result.getKey());
		
		ArrayList<OutStorePO> opo = new ArrayList<OutStorePO>();
		opo.add(new OutStorePO());
		result = sds.saveOutStore(opo);
		System.out.println(result.getKey());
		
		result = sds.saveAdjust(new AdjustPO());
		System.out.println(result.getKey());
		
		result = sds.saveVerification(new VerificationPO());
		System.out.println(result.getKey());
	}

}

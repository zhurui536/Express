package main.dataservice.storedataservice._driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.dataservice.storedataservice.StoreDataService;
import main.dataservice.storedataservice._stub.StoreDataService_Stub;
import main.po.GoodsPO;
import main.po.storepo.AdjustPO;
import main.po.storepo.InStorePO;
import main.po.storepo.OutStorePO;
import main.po.storepo.StorePO;
import main.po.storepo.StorePlacePO;
import main.po.storepo.VerificationPO;

public class StoreDataService_Driver {
	public static void main(String[] args) throws RemoteException{
		StoreDataService sds = new StoreDataService_Stub();
		
		drive(sds);
	}
	
	public static void drive(StoreDataService sds) throws RemoteException{
		ResultMessage result = null;
		
		result = sds.find("1111111111");
		System.out.println(result.getKey());
		
		result = sds.find(new StorePlacePO(1, 1, 2, 2));
		System.out.println(result.getKey());
		
		result = sds.delete(null);
		System.out.println(result.getKey());
		
		result = sds.update(new StorePlacePO(1, 1, 2, 2), null);
		System.out.println(result.getKey());

		//为出库和入库创建货物
		GoodsPO goods = new GoodsPO("10010", "zhr", "nanjing", "sihong", 1, 3, PackageType.CARTONS, ExpressType.ECONOMIC);
		StorePlacePO place = new StorePlacePO(1, 1, 1, 1);
		
		ArrayList<InStorePO> ipo = new ArrayList<InStorePO>();
		ipo.add(new InStorePO(goods, goods.getDestination(), place));
		result = sds.saveInStore(ipo);
		System.out.println(result.getKey());
		
		ArrayList<OutStorePO> opo = new ArrayList<OutStorePO>();
		opo.add(new OutStorePO(goods, goods.getDestination(), Trans.TRAIN, "1008610010"));
		result = sds.saveOutStore(opo);
		System.out.println(result.getKey());
		
//		result = sds.saveAdjust(new AdjustPO());
		System.out.println(result.getKey());
		
		result = sds.saveVerification(new VerificationPO(new StorePO(2, 3, 4, 5)));
		System.out.println(result.getKey());
	}

}

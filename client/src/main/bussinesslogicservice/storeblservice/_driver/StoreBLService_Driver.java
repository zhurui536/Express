package main.bussinesslogicservice.storeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import main.bussinesslogicservice.storeblservice._stub.StoreBLService_Stub;
import main.po.storepo.StorePlacePO;

/**
 * Created By ZHR
 * 2015/10/26
 */

public class StoreBLService_Driver {
	public static void main(String[] args){
		StoreBLService sbls = new StoreBLService_Stub();
		
		drive(sbls);
	}
	public static void drive(StoreBLService sbls){
		ResultMessage result = null;
		
		//入库部分
		sbls.newInStore();
		
		result = sbls.addInStoreGoods(1000000000, new StorePlacePO(1, 1, 1, 1), "北京");
		System.out.println(result.getKey());
		
		result = sbls.delInStoreGoods(1111111111);
		System.out.println(result.getKey());
		
		sbls.endIntStore(0);
		
		//出库部分
		sbls.newOutStore();
		
		result = sbls.addOutStoreGoods(1000000000, null, "北京");
		System.out.println(result.getKey());
		
		result = sbls.delOutStoreGoods(1111111111);
		System.out.println(result.getKey());
		
		sbls.endOutStore(0);
		
		//库存盘点部分
		result = sbls.verification();
		System.out.println(result.getKey());
		
		sbls.endVerification(0);
		
		//库存查看部分
		
		//库存调整部分
		sbls.newAdjust();
		
		result = sbls.addAdjust(new StorePlacePO(2, 2, 2, 2), new StorePlacePO(1, 1, 1, 1));
		
		sbls.endAdjust(1);
	}
}

package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.AdjustBLService;
import main.data.storedata.StoreDataServiceImpl;
import po.GoodsPO;
import po.UserPO;
import po.storepo.AdjustPO;
import po.storepo.StorePlacePO;

public class AdjustBL implements AdjustBLService {
	private StoreDataService dataservice;
	private ArrayList<AdjustPO> adjusts;
	private UserPO user;
	
	public AdjustBL(UserPO user){
		dataservice = new StoreDataServiceImpl();
		this.user = user;
	}

	@Override
	public ResultMessage newAdjust() {
		adjusts = new ArrayList<AdjustPO>();
		
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end) {
		try {
			ResultMessage result = dataservice.find(start);
			GoodsPO goodsOfStart = (GoodsPO) result.getValue();
			if(goodsOfStart == null){
				return new ResultMessage("emptystart", adjusts);
			}
			result = dataservice.find(end);
			GoodsPO goodsOfEnd = (GoodsPO) result.getValue();
			if(goodsOfEnd != null){
				return new ResultMessage("usedend", adjusts);
			}
			
			adjusts.add(new AdjustPO(start, end, user));
			
			return new ResultMessage("success", adjusts);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
	
	@Override
	public ResultMessage delAdjust(int i) {
		adjusts.remove(i);
		
		return new ResultMessage("success", adjusts);
	}

	@Override
	public ResultMessage endAdjust(int condition) {
		try {
			dataservice.saveAdjust(adjusts);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		return new ResultMessage("success", null);

	}
}

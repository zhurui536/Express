package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.storedataservice.StoreDataService;
import dataservice.storedataservice._stub.StoreDataService_Stub;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.AdjustBLService;
import main.data.storedata.StoreDataServiceImpl;
import main.vo.storevo.StorePlaceVO;
import po.GoodsPO;
import po.UserPO;
import po.storepo.AdjustPO;
import po.storepo.StorePlacePO;

public class AdjustBL implements AdjustBLService {
	private StoreDataService dataservice;
	private ArrayList<AdjustPO> adjusts;
	private UserPO user;
	
	public AdjustBL(UserPO user){
		dataservice = new StoreDataService_Stub();
		this.user = user;
	}

	@Override
	public ResultMessage newAdjust() {
		adjusts = new ArrayList<AdjustPO>();
		
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage addAdjust(StorePlaceVO s, StorePlaceVO e) {
		StorePlacePO start = new StorePlacePO(s.getArea(), s.getRow(), s.getShelf(), s.getPlace());
		StorePlacePO end = new StorePlacePO(e.getArea(), e.getRow(), e.getShelf(), e.getPlace());
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
		} catch (RemoteException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
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

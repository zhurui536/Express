package main.bussinesslogic.storebl;

import java.rmi.RemoteException;

import po.UserPO;
import po.storepo.StorePO;
import po.storepo.VerificationPO;
import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.VerificationBLService;
import main.data.storedata.StoreDataServiceImpl;
import main.vo.storevo.StoreVO;

public class VerificationBL implements VerificationBLService {
	private StoreDataService dataservice;
	private UserPO user;
	private StoreVO store;
	private VerificationPO po;
	
	public VerificationBL(UserPO user){
		this.user = user;
		dataservice = new StoreDataServiceImpl();
	}
	
	@Override
	public ResultMessage verification() {
		ResultMessage result;
		try {
			result = dataservice.getStore();
			StorePO store = (StorePO) result.getValue();
			this.store = new StoreVO(store);
			this.po = new VerificationPO(store, user);
			
			return new ResultMessage("success", this.store);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		
	}

	@Override
	public ResultMessage endVerification(int condition) {
		if(condition == 0){
			try {
				dataservice.saveVerification(po);
				return new ResultMessage("success", null);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
		}
		else if(condition == 1){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("unknown operation", null);
		}
	}

}

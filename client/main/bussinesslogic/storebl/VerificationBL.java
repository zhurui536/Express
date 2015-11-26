package main.bussinesslogic.storebl;

import java.util.ArrayList;

import po.UserPO;
import po.storepo.AdjustPO;
import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.VerificationBLService;
import main.data.storedata.StoreDataServiceImpl;

public class VerificationBL implements VerificationBLService {
	private StoreDataService dataservice;
	private UserPO user;
	private ArrayList<AdjustPO> goodslist;
	
	public VerificationBL(UserPO user){
		this.user = user;
		dataservice = new StoreDataServiceImpl();
	}
	
	@Override
	public ResultMessage verification() {
		
		return null;
	}

	@Override
	public void endVerification(int condition) {
		// TODO Auto-generated method stub

	}

}

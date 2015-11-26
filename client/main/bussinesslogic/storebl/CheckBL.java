package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.Calendar;

import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.CheckBLService;
import main.data.storedata.StoreDataServiceImpl;

public class CheckBL implements CheckBLService {
	private StoreDataService dataservice;
	
	public CheckBL(){
		dataservice = new StoreDataServiceImpl();
	}
	
	@Override
	public void newCheck() {
		
	}

	@Override
	public ResultMessage check(Calendar start, Calendar end) {
		
		try {
			return dataservice.finds(start, end);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

}

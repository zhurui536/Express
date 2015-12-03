package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.Calendar;

import po.storepo.IORecordPO;
import po.storepo.StorePO;
import dataservice.storedataservice.StoreDataService;
import dataservice.storedataservice._stub.StoreDataService_Stub;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.CheckBLService;
import main.data.storedata.StoreDataServiceImpl;
import main.vo.storevo.CheckVO;

public class CheckBL implements CheckBLService {
	private StoreDataService dataservice;
	private CheckVO vo;
	
	public CheckBL(){
		dataservice = new StoreDataService_Stub();
	}
	
	@Override
	public ResultMessage newCheck() {
		vo = null;
		return new ResultMessage("success", vo);
		
	}

	@Override
	public ResultMessage check(Calendar start, Calendar end) {
		
		try {
			ResultMessage result =  dataservice.finds(start, end);
			IORecordPO record = (IORecordPO) result.getValue();
			vo = new CheckVO(record);
			
			StorePO store = (StorePO) dataservice.getStore().getValue();
			vo.setNumOfEmpty(store.getNumOfEmpty());
			vo.setNumOfUsed(store.getNumOfUsed());
			
			return new ResultMessage("success", vo);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public void endCheck() {
		
	}

}

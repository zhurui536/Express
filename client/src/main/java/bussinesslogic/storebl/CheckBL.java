package bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import bussinesslogicservice.storeblservice.CheckBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;
import po.storepo.IORecordPO;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import po.storepo.StorePO;
import util.ResultMessage;
import vo.storevo.CheckVO;

public class CheckBL implements CheckBLService {
	private StoreDataService dataservice;
	private CheckVO vo;
	
	public CheckBL(){
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
	}
	
	@Override
	public ResultMessage newCheck() {
		vo = null;
		return new ResultMessage("success", vo);
	}

	@Override
	public ResultMessage check(Calendar start, Calendar end) {
		
		try {//若查找成功，将结果返回
			ResultMessage result =  dataservice.finds(start, end);
			if(result.getKey().equals("success")){
				IORecordPO record = (IORecordPO) result.getValue();
				vo = new CheckVO(record);
				
				StorePO store = (StorePO) dataservice.getStore().getValue();
				vo.setNumOfEmpty(store.getNumOfEmpty());
				vo.setNumOfUsed(store.getNumOfUsed());
				
				return new ResultMessage("success", vo);
			}
			else{//查找失败时，返回错误类型
				return result;
			}
			
		} catch (RemoteException e) {//网络出错时，返回网络错误
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public void endCheck() {
		vo = null;
	}

	@Override
	public ResultMessage checkStore() {
		StoreDataService dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
		try {
			ResultMessage result = dataservice.getStore();
			if(result.getKey().equals("success")){
				return new ResultMessage("success", result.getValue());
			}
			else{
				return result;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage checkInStore() {
		StoreDataService dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
		
		try {
			ResultMessage result = dataservice.getIntStoreBill();
			if(result.getKey().equals("success")){
				ArrayList<InStoreBillPO> bills = (ArrayList<InStoreBillPO>) result.getValue();
				return new ResultMessage("success", bills);
			}
			else{
				return result;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage checkOutStore() {
		StoreDataService dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
		try {
			ResultMessage result = dataservice.getOutStoreBill();
			if(result.getKey().equals("success")){
				ArrayList<OutStoreBillPO> bills = (ArrayList<OutStoreBillPO>) result.getValue();
				return new ResultMessage("success", bills);
			}
			else{
				return result;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		
	}

}

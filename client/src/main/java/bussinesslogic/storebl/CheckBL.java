package bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.Calendar;

import po.storepo.IORecordPO;
import po.storepo.StorePO;
import util.ResultMessage;
import vo.storevo.CheckVO;
import bussinesslogicservice.storeblservice.CheckBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;

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
		dataservice = null;
		vo = null;
	}

}

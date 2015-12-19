package bussinesslogic.storebl;

import java.rmi.RemoteException;

import po.storepo.StorePO;
import po.storepo.VerificationPO;
import util.PublicMessage;
import util.ResultMessage;
import vo.storevo.VerificationVO;
import bussinesslogicservice.storeblservice.VerificationBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;

public class VerificationBL implements VerificationBLService {
	private StoreDataService dataservice;
	private String user;
	private VerificationVO vo;
	private VerificationPO po;
	
	public VerificationBL(){
		this.user = PublicMessage.userID;
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
	}
	
	@Override
	public ResultMessage verification() {
		ResultMessage result;
		try {
			result = dataservice.getStore();
			if(result.getKey().equals("success")){
				StorePO store = (StorePO) result.getValue();
				this.vo = new VerificationVO(store);
				this.po = new VerificationPO(store, user);
				
				return new ResultMessage("success", this.vo);
			}
			else{
				return result;
			}
			
		} catch (RemoteException e) {
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

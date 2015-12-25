package bussinesslogic.storebl;

import bussinesslogicservice.storeblservice.VerificationBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;
import po.storepo.StorePO;
import po.storepo.VerificationPO;
import util.PublicMessage;
import util.ResultMessage;
import vo.storevo.VerificationVO;

import java.rmi.RemoteException;

import javax.swing.JTable;

public class VerificationBL implements VerificationBLService {
	private StoreDataService dataservice;
	private String user;
	private VerificationVO vo;
	private VerificationPO po;
	
	public VerificationBL(){
		ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
		this.user = PublicMessage.staffID;
		dataservice = (StoreDataService) clientRMIHelper.getServiceByName("StoreDataServiceImpl");
	}
	
	@Override
	public ResultMessage verification() {
		ResultMessage result;
		try {
			result = dataservice.getPihao();
			if(result.getKey().equals("success")){
				int pihao = (int) result.getValue();
				result = dataservice.getStore();
				if(result.getKey().equals("success")){
					StorePO store = (StorePO) result.getValue();
					this.po = new VerificationPO(store, user, pihao);
					this.vo = new VerificationVO(store, po.getPici(), po.getPihao());
					
					return new ResultMessage("success", this.vo);
				}
				else{
					return result;
				}
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

	@Override
	public ResultMessage exportVerification(JTable table) {
		TableExport exportor = new TableExport(table);
		if(exportor.export()){
			return new ResultMessage("success", null);
		}
		return new ResultMessage("failed", null);
	}

}

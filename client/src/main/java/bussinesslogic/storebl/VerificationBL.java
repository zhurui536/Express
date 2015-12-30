package bussinesslogic.storebl;

import java.rmi.RemoteException;

import javax.swing.JTable;

import bussinesslogicservice.storeblservice.VerificationBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;
import po.storepo.StorePO;
import po.storepo.VerificationPO;
import util.PublicMessage;
import util.ResultMessage;
import vo.storevo.VerificationVO;

public class VerificationBL implements VerificationBLService {
	private StoreDataService dataservice;
	private String user;
	private VerificationVO vo;
	private VerificationPO po;
	
	public VerificationBL(){
		this.user = PublicMessage.staffID;
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
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
		//0代表结束盘点，保存库存盘点记录
		if(condition == 0){
			try {
				dataservice.saveVerification(po);
				return new ResultMessage("success", null);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
		}
		//1代表取消盘点
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

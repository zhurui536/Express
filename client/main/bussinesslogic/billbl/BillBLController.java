package main.bussinesslogic.billbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.billdataservice.BilldataService;
import po.BillPO;
import po.UserPO;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.billblservice.BillBLService;
import main.connection.ClientRMIHelper;
import main.vo.BillVO;

public class BillBLController implements BillBLService{
	private UserPO user;
	private BilldataService dataservice;
	private final BillType[] types = {
			BillType.OUTSTORE, BillType.INSTORE, BillType.PAYMENT, BillType.RECEIPT
	};
	ArrayList<BillPO> bills;
	ArrayList<BillVO> vos;
	
	public BillBLController(UserPO user){
		this.user = user;
		dataservice = (BilldataService) ClientRMIHelper.getServiceByName("BillDataServiceImpl");
		vos = new ArrayList<BillVO>();
		bills = new ArrayList<BillPO>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getBills() {
		for(int i=0;i<types.length;i++){
			ResultMessage result;
			try {
				result = dataservice.getBills(types[i]);
				if(result.getKey().equals("success")){
					if(i==0){
						ArrayList<OutStoreBillPO> temp = new ArrayList<OutStoreBillPO>();
						OutStoreBillPO bill = null;
						
						for(int j=0;i<temp.size();i++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==1){
						ArrayList<InStoreBillPO> temp = new ArrayList<InStoreBillPO>();
						InStoreBillPO bill = null;
						
						for(int j=0;i<temp.size();i++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==2){
						ArrayList<PayBillPO> temp = new ArrayList<PayBillPO>();
						PayBillPO bill = null;
						
						for(int j=0;i<temp.size();i++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==3){
						ArrayList<ReceiptBillPO> temp = new ArrayList<ReceiptBillPO>();
						ReceiptBillPO bill = null;
						
						for(int j=0;i<temp.size();i++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
				}
				else{
					return new ResultMessage(result.getKey(), vos);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				
				return new ResultMessage("internet error", null);
			}
			
		}
		
		for(int j=0;j<bills.size();j++){
			vos.add(bills.get(j).toVO());
		}
		
		return new ResultMessage("success", vos);
		
		
	}

	@Override
	public ResultMessage chooseBill(String id, BillType type) {
		ResultMessage result;
		try {
			result = dataservice.getBills(type);
			if(result.getKey().equals("success")){
				if(type == BillType.INSTORE){
					ArrayList<InStoreBillPO> temp = (ArrayList<InStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.OUTSTORE){
					ArrayList<OutStoreBillPO> temp = (ArrayList<OutStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.PAYMENT){
					ArrayList<PayBillPO> temp = (ArrayList<PayBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.RECEIPT){
					ArrayList<ReceiptBillPO> temp = (ArrayList<ReceiptBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
			}
			
			return new ResultMessage(result.getKey(), vos);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public ResultMessage approve(String id, BillType type) {
		ResultMessage result;
		try {
			result = dataservice.getBills(type);
			if(result.getKey().equals("success")){
				if(type == BillType.INSTORE){
					ArrayList<InStoreBillPO> temp = (ArrayList<InStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.OUTSTORE){
					ArrayList<OutStoreBillPO> temp = (ArrayList<OutStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.PAYMENT){
					ArrayList<PayBillPO> temp = (ArrayList<PayBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.RECEIPT){
					ArrayList<ReceiptBillPO> temp = (ArrayList<ReceiptBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
			}
			
			return new ResultMessage(result.getKey(), vos);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> types) {
		ResultMessage result = null;
		
		for(int i=0;i<ids.size();i++){
			result = this.approve(ids.get(i), types.get(i));
			
			if(result.getKey().equals("success")){
				continue;
			}
			else if(result.getKey().equals("noexist")){
				continue;
			}
			else{
				return result;
			}
		}
		
		return new ResultMessage("success", null);
	}

	@Override
	public void end() {
		dataservice = null;
		user = null;
	}

}

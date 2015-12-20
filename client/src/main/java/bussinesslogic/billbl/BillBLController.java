package bussinesslogic.billbl;

import bussinesslogicservice.billblservice.BillBLService;
import connection.ClientRMIHelper;
import dataservice.billdataservice.BilldataService;
import po.BillPO;
import po.financepo.PayBillPO;
import po.logisticpo.*;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import util.BillState;
import util.BillType;
import util.ResultMessage;
import vo.BillVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
//处理单据审批
public class BillBLController implements BillBLService {
	private BilldataService dataservice;
	private final BillType[] types = {
			BillType.OUTSTORE, BillType.INSTORE, BillType.PAYMENT, BillType.RECEIPT, BillType.ARRIVAL, BillType.DELIVERY,
			BillType.LOADING, BillType.SEND, BillType.TRANSIT
	};
	ArrayList<BillPO> bills;
	ArrayList<BillVO> vos;
	
	public BillBLController(){
		ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
		dataservice = (BilldataService) clientRMIHelper.getServiceByName("BillDataServiceImpl");
		vos = new ArrayList<BillVO>();
		bills = new ArrayList<BillPO>();
	}
//获得所有未审批单据
	@Override
	public ResultMessage getBills() {
		vos = new ArrayList<BillVO>();
		bills = new ArrayList<BillPO>();
		for(int i=0;i<types.length;i++){
			ResultMessage result;
			try {
				result = dataservice.getBills(types[i]);
				if(result.getKey().equals("success")){
					if(i==0){
						ArrayList<OutStoreBillPO> temp = new ArrayList<OutStoreBillPO>();
						OutStoreBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==1){
						ArrayList<InStoreBillPO> temp = new ArrayList<InStoreBillPO>();
						InStoreBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==2){
						ArrayList<PayBillPO> temp = new ArrayList<PayBillPO>();
						PayBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==3){
						ArrayList<ReceiptBillPO> temp = new ArrayList<ReceiptBillPO>();
						ReceiptBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==4){
						ArrayList<ArrivalBillPO> temp = new ArrayList<ArrivalBillPO>();
						ArrivalBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==5){
						ArrayList<DeliveryBillPO> temp = new ArrayList<DeliveryBillPO>();
						DeliveryBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==6){
						ArrayList<LoadingBillPO> temp = new ArrayList<LoadingBillPO>();
						LoadingBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==7){
						ArrayList<SendBillPO> temp = new ArrayList<SendBillPO>();
						SendBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() == BillState.DRAFT){
								bills.add(bill);
							}
						}
					}
					if(i==8){
						ArrayList<TransferBillPO> temp = new ArrayList<TransferBillPO>();
						TransferBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
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
//获得某个被选中的单据
	@SuppressWarnings("unchecked")
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
				else if(type == BillType.ARRIVAL){
					ArrayList<ArrivalBillPO> temp = (ArrayList<ArrivalBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.DELIVERY){
					ArrayList<DeliveryBillPO> temp = (ArrayList<DeliveryBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.LOADING){
					ArrayList<LoadingBillPO> temp = (ArrayList<LoadingBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.SEND){
					ArrayList<SendBillPO> temp = (ArrayList<SendBillPO>) result.getValue();

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
//审批单个单据
	@SuppressWarnings("unchecked")
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
				else if(type == BillType.ARRIVAL){
					ArrayList<ArrivalBillPO> temp = (ArrayList<ArrivalBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.DELIVERY){
					ArrayList<DeliveryBillPO> temp = (ArrayList<DeliveryBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.LOADING){
					ArrayList<LoadingBillPO> temp = (ArrayList<LoadingBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.SEND){
					ArrayList<SendBillPO> temp = (ArrayList<SendBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).setState(BillState.APPROVED);
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.TRANSIT){
					ArrayList<TransferBillPO> temp = (ArrayList<TransferBillPO>) result.getValue();
					
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
			
			return new ResultMessage(result.getKey(), null);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
//批量审批
	@Override
	public ResultMessage approves() {
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<BillType> types = new ArrayList<BillType>();
		
		for(int i=0;i<bills.size();i++){
			BillPO bill = bills.get(i);
			ids.add(bill.getBillID());
			types.add(bill.getType());
		}
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
//结束审批
	@Override
	public void end() {
		dataservice = null;
	}

}

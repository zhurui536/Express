package main.data.billdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.BillPO;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import dataservice.billdataservice.BilldataService;

public class BillDataServiceImpl extends UnicastRemoteObject implements BilldataService {
	
	protected BillDataServiceImpl() throws RemoteException {
		super();
	}

	private final String instorebill = "server/save/storedata/instoreBillPO.dat";
	private final String outstorebill = "server/save/storedata/outstoreBillPO.dat";
	private final String paybill = "server/save/financedata/payBillPO.dat";
	private final String receiptbill = "server/save/logisticsdata/receiptBillPO.dat";

	@Override
	public ResultMessage find(String id, BillType type) {
		try{
			if(type == BillType.INSTORE){
				ArrayList<InStoreBillPO> bills = (ArrayList<InStoreBillPO>) this.readBill(instorebill);
				
				for(int i=0;i<bills.size();i++){
					if(bills.get(i).getBillID().equals(id)){
						return new ResultMessage("success", bills.get(i));
					}
				}
			}
			
			if(type == BillType.OUTSTORE){
				ArrayList<OutStoreBillPO> bills = (ArrayList<OutStoreBillPO>) this.readBill(outstorebill);
				
				for(int i=0;i<bills.size();i++){
					if(bills.get(i).getBillID().equals(id)){
						return new ResultMessage("success", bills.get(i));
					}
				}
			}
			
			if(type == BillType.PAYMENT){
				ArrayList<PayBillPO> bills = (ArrayList<PayBillPO>) this.readBill(paybill);
				
				for(int i=0;i<bills.size();i++){
					if(bills.get(i).getBillID().equals(id)){
						return new ResultMessage("success", bills.get(i));
					}
				}
			}
			
			if(type == BillType.RECEIPT){
				ArrayList<ReceiptBillPO> bills = (ArrayList<ReceiptBillPO>) this.readBill(receiptbill);
				
				for(int i=0;i<bills.size();i++){
					if(bills.get(i).getBillID().equals(id)){
						return new ResultMessage("success", bills.get(i));
					}
				}
			}
			
			return new ResultMessage("noexist", null);
		}catch(Exception e){
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage approve(String id, BillType type) {
		try{
			String path = null;
			
			if(type == BillType.INSTORE){
				path = instorebill;
			}
			else if(type == BillType.OUTSTORE){
				path = outstorebill;
			}
			else if(type == BillType.PAYMENT){
				path = paybill;
			}
			else if(type == BillType.RECEIPT){
				path = receiptbill;
			}
			
			ArrayList<BillPO> bills = (ArrayList<BillPO>) this.readBill(path);
			
			for(int i=0;i<bills.size();i++){
				BillPO bill = bills.get(i);
				if(bill.getBillID().equals(id)){
					bill.setState(BillState.APPROVED);
					this.writeBill(instorebill, bills);
					
					return new ResultMessage("success", null);
				}
			}
			
			return new ResultMessage("noexist", null);
		}catch(Exception e){
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage getBills() {
		try{
			ArrayList<InStoreBillPO> instore = (ArrayList<InStoreBillPO>) readBill(instorebill);
			ArrayList<OutStoreBillPO> outstore = (ArrayList<OutStoreBillPO>) readBill(outstorebill);
			ArrayList<PayBillPO> pay = (ArrayList<PayBillPO>) readBill(paybill);
			ArrayList<ReceiptBillPO> receipt = (ArrayList<ReceiptBillPO>) readBill(receiptbill);
			
			ArrayList<BillPO> bills = new ArrayList<BillPO>();
			for(int i=0;i<instore.size();i++){
				BillPO bill = instore.get(i);
				if(bill.getState() == BillState.DRAFT){
					bills.add(bill);
				}
			}
			
			for(int i=0;i<outstore.size();i++){
				BillPO bill = outstore.get(i);
				if(bill.getState() == BillState.DRAFT){
					bills.add(bill);
				}
			}
			
			for(int i=0;i<pay.size();i++){
				BillPO bill = pay.get(i);
				if(bill.getState() == BillState.DRAFT){
					bills.add(bill);
				}
			}
			
			for(int i=0;i<receipt.size();i++){
				BillPO bill = receipt.get(i);
				if(bill.getState() == BillState.DRAFT){
					bills.add(bill);
				}
			}
			
			return new ResultMessage("success", bills);
		}catch(Exception e){
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> type) {
		for(int i=0;i<ids.size();i++){
			ResultMessage result = this.approve(ids.get(i), type.get(i));
			if(result.getKey().equals("success")){
				continue;
			}
			else{
				return result;
			}
		}
		return new ResultMessage("success", null);
	}
	
	private Object readBill(String path) throws Exception{
		Object bills;
		
		FileInputStream in = new FileInputStream(path);
		ObjectInputStream objin = new ObjectInputStream(in);
		bills = objin.readObject();
		objin.close();
			
		return bills;
	}
	
	private void writeBill(String path, Object bills) throws Exception{
		//将新的库存写入文件
		FileOutputStream out = new FileOutputStream(path);
		ObjectOutputStream objout = new ObjectOutputStream(out);
		objout.writeObject(bills);
		objout.close();
	}
}

package main.data.billdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import dataservice.billdataservice.BillDataService;

public class BillDataServiceImpl implements BillDataService {
	private final String instorebill = "server/save/storedata/instoreBillPO.dat";
	private final String outstorebill = "server/save/storedata/outstoreBillPO.dat";
	private final String paybill = "server/save/financedata/payBillPO.dat";
	private final String receiptbill = "server/save/logisticsdata/receiptBillPO.dat";

	@Override
	public ResultMessage find(String id, BillType type) {
		try{
			ArrayList<InStoreBillPO> instore = (ArrayList<InStoreBillPO>) readBill(instorebill);
			for(int i=0;i<instore.size();i++){
				InStoreBillPO temp = instore.get(i);
				if(temp.getBill().equals(id)){
					return new ResultMessage("exist", temp);
				}
			}
			
			ArrayList<OutStoreBillPO> outstore = (ArrayList<OutStoreBillPO>) readBill(outstorebill);
			for(int i=0;i<instore.size();i++){
				OutStoreBillPO temp = outstore.get(i);
				if(temp.getBill().equals(id)){
					return new ResultMessage("exist", temp);
				}
			}
			
			ArrayList<PayBillPO> pay = (ArrayList<PayBillPO>) readBill(paybill);
			for(int i=0;i<pay.size();i++){
				PayBillPO temp = pay.get(i);
				if(temp.getId().equals(id)){
					return new ResultMessage("exist", temp);
				}
			}
			
			ArrayList<ReceiptBillPO> receipt = (ArrayList<ReceiptBillPO>) readBill(paybill);
			for(int i=0;i<receipt.size();i++){
				ReceiptBillPO temp = receipt.get(i);
				if(temp.getBill().equals(id)){
					return new ResultMessage("exist", temp);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> type) {
		
		return null;
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

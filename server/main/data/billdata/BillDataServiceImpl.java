package main.data.billdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import main.bussinesslogic.util.ResultMessage;
import dataservice.billdataservice.BillDataService;

public class BillDataServiceImpl implements BillDataService {
	private final String instorebill = "server/save/storedata/instoreBillPO.dat";
	private final String outstorebill = "server/save/storedata/outstoreBillPO.dat";
	private final String paybill = "server/save/financedata/PayBillPO.dat";
	private final String receiptbill = "server/save/logisticsdata/receiptBillPO.dat";

	@Override
	public ResultMessage find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Object readBill(String path){
		Object bills;
		
		try {
			FileInputStream in = new FileInputStream(path);
			ObjectInputStream objin = new ObjectInputStream(in);
			bills = objin.readObject();
			objin.close();
			
			return bills;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void writeBill(String path, Object bills){
		//将新的库存写入文件
		FileOutputStream out;
		try {
			out = new FileOutputStream(path);
			ObjectOutputStream objout = new ObjectOutputStream(out);
			objout.writeObject(bills);
			objout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

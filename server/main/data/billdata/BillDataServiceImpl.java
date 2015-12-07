package main.data.billdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.BillPO;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import dataservice.billdataservice.BilldataService;

public class BillDataServiceImpl extends UnicastRemoteObject implements BilldataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8882526534904249002L;

	public BillDataServiceImpl() throws RemoteException {
		super();
	}

	private final String instorebill = "server/save/storedata/instoreBillPO.dat";
	private final String outstorebill = "server/save/storedata/outstoreBillPO.dat";
	private final String paybill = "server/save/financedata/payBillPO.dat";
	private final String receiptbill = "server/save/logisticsdata/receiptBillPO.dat";
	
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
	
	private String getPathByType(BillType type){
		if(type == BillType.INSTORE)
			return this.instorebill;
		if(type == BillType.OUTSTORE)
			return this.outstorebill;
		if(type == BillType.RECEIPT)
			return this.receiptbill;
		if(type == BillType.PAYMENT)
			return this.paybill;
		
		return null;
	}

	@Override
	public ResultMessage getBills(BillType type) {
		String path = this.getPathByType(type);
		try {
			Object object = this.readBill(path);
			return new ResultMessage("success", object);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage saveBills(ArrayList<? extends BillPO> bills, BillType type) {
		String path = this.getPathByType(type);
		try {
			this.writeBill(path, bills);
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
}

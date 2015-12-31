package data.billdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.billdataservice.BilldataService;
import po.BillPO;
import po.financepo.PayBillPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.ReceiptBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import util.BillType;
import util.ResultMessage;

public class BillDataServiceImpl extends UnicastRemoteObject implements BilldataService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8882526534904249002L;
	

	//入库单
	private String instorebill = "save/storedata/instoreBillPO.dat";
	//出库单
	private String outstorebill = "save/storedata/outstoreBillPO.dat";
	//付款单
	private String paybill = "save/financedata/payBillPO.dat";
	//收款单
	private String receiptbill = "save/logisticsdata/receiptBillPO.dat";
	//到达单
	private String arrivalbill = "save/logisticsdata/arrivalBillPO.dat";
	//派件单
	private String deliverybill = "save/logisticsdata/deliveryBillPO.dat";
	//装车单
	private String loadingbill = "save/logisticsdata/loadingBillPO.dat";
	//寄件单
	private String sendbill = "save/logisticsdata/sendBillPO.dat";
	//中转单
	private String transferbill = "save/logisticsdata/transferBillPO.dat";

	public BillDataServiceImpl() throws RemoteException {
		super();
		try {
			FileInputStream in = new FileInputStream(instorebill);
			if(in.available()==0){
				in.close();
				
				ArrayList<InStoreBillPO> bills = new ArrayList<InStoreBillPO>();
				this.writeBill(instorebill, bills);
			}
			
			in = new FileInputStream(outstorebill);
			if(in.available()==0){
				in.close();
				
				ArrayList<OutStoreBillPO> bills = new ArrayList<OutStoreBillPO>();
				this.writeBill(outstorebill, bills);
			}
			
			in = new FileInputStream(paybill);
			if(in.available()==0){
				in.close();
				
				ArrayList<PayBillPO> bills = new ArrayList<PayBillPO>();
				this.writeBill(paybill, bills);
			}
			
			in = new FileInputStream(receiptbill);
			if(in.available()==0){
				in.close();
				
				ArrayList<ReceiptBillPO> bills = new ArrayList<ReceiptBillPO>();
				this.writeBill(receiptbill, bills);
			}
			
			in = new FileInputStream(arrivalbill);
			if(in.available()==0){
				in.close();
				
				ArrayList<ArrivalBillPO> bills = new ArrayList<ArrivalBillPO>();
				this.writeBill(arrivalbill, bills);
			}
			
			in = new FileInputStream(deliverybill);
			if(in.available()==0){
				in.close();
				
				ArrayList<DeliveryBillPO> bills = new ArrayList<DeliveryBillPO>();
				this.writeBill(deliverybill, bills);
			}
			
			in = new FileInputStream(loadingbill);
			if(in.available()==0){
				in.close();
				
				ArrayList<LoadingBillPO> bills = new ArrayList<>();
				this.writeBill(loadingbill, bills);
			}
			
			in = new FileInputStream(sendbill);
			if(in.available()==0){
				in.close();
				
				ArrayList<SendBillPO> bills = new ArrayList<SendBillPO>();
				this.writeBill(sendbill, bills);
			}
			
			in = new FileInputStream(transferbill);
			if(in.available()==0){
				in.close();
				
				ArrayList<TransferBillPO> bills = new ArrayList<TransferBillPO>();
				this.writeBill(transferbill, bills);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	
	private String getPathByType(BillType type){
		if(type == BillType.INSTORE)
			return this.instorebill;
		if(type == BillType.OUTSTORE)
			return this.outstorebill;
		if(type == BillType.RECEIPT)
			return this.receiptbill;
		if(type == BillType.PAYMENT)
			return this.paybill;
		if(type == BillType.ARRIVAL)
			return this.arrivalbill;
		if(type == BillType.DELIVERY)
			return this.deliverybill;
		if(type == BillType.LOADING)
			return this.loadingbill;
		if(type == BillType.SEND)
			return this.sendbill;
		if(type == BillType.TRANSIT)
			return this.transferbill;
		
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

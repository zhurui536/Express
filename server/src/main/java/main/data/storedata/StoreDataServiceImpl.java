package main.data.storedata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import path.PathMaker;
import po.logisticpo.SendBillPO;
import po.storepo.AdjustPO;
import po.storepo.IORecordPO;
import po.storepo.InStoreBillPO;
import po.storepo.InStorePO;
import po.storepo.OutStoreBillPO;
import po.storepo.OutStorePO;
import po.storepo.StorePO;
import po.storepo.VerificationPO;
import util.ResultMessage;
import dataservice.storedataservice.StoreDataService;

public class StoreDataServiceImpl extends UnicastRemoteObject implements StoreDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2094560624032926398L;
	
	private String storerecord;
	private String instorerecord;
	private String outstorerecord;
	private String adjustrecord;
	private String verificationrecord;
	private String instorebill;
	private String outstorebill;
	private String sendbill;
	
	private void generatePath(){
		storerecord = "src/main/java/save/storedata/storePO.dat";
		instorerecord = "src/main/java/save/storedata/instorePO.dat";
		outstorerecord = "src/main/java/save/storedata/outstorePO.dat";
		adjustrecord = "src/main/java/save/storedata/adjustPO.dat";
		verificationrecord = "src/main/java/save/storedata/verificationPO.dat";
		instorebill = "src/main/java/save/storedata/instoreBillPO.dat";
		outstorebill = "src/main/java/save/storedata/outstoreBillPO.dat";
		sendbill = "src/main/java/save/logisticsdata/sendBillPO.dat";
	}
	
	public StoreDataServiceImpl() throws RemoteException {
		this.generatePath();
		try {//将所有空文件进行初始化
			FileInputStream in = new FileInputStream(storerecord);
			//判断文档是否为空，如果是空的，那么新建一个对象，并将其写入文件中
			if(in.available() == 0){
				StorePO store = new StorePO(4, 10, 10, 10);
				in.close();
				
				//写回文件中
				this.writeList(storerecord, store);
			}
			
			in = new FileInputStream(instorerecord);
			if(in.available() == 0){
				ArrayList<InStorePO> records = new ArrayList<InStorePO>();
				in.close();

				//接着将对象写回文件中
				this.writeList(instorerecord, records);
			}
			
			in = new FileInputStream(outstorerecord);
			if(in.available() == 0){
				ArrayList<OutStorePO> records = new ArrayList<OutStorePO>();
				in.close();
				
				//写入文件
				this.writeList(outstorerecord, records);
			}
			
			in = new FileInputStream(adjustrecord);
			if(in.available() == 0){
				ArrayList<AdjustPO> records = new ArrayList<AdjustPO>();
				in.close();
				
				//写入文件
				this.writeList(adjustrecord, records);
			}
			
			in = new FileInputStream(verificationrecord);
			if(in.available() == 0){
				ArrayList<VerificationPO> records = new ArrayList<VerificationPO>();
				in.close();
				
				//写入文件
				this.writeList(verificationrecord, records);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage find(String id) throws RemoteException {
		try {
			ArrayList<SendBillPO> bills = (ArrayList<SendBillPO>) this.readList(sendbill);
			
			for(int i=0;i<bills.size();i++){
				SendBillPO bill = bills.get(i);
				if(bill.getGoodsPO().getId().equals(id)){
					return new ResultMessage("exist", bill.getGoodsPO());
				}
			}
			return new ResultMessage("noexist", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	//保存入库记录的同时更新库存
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage saveInStore(ArrayList<InStorePO> po)
			throws RemoteException {
		ArrayList<InStorePO> records = null;
		
		try {
			//读入入库记录数据
			records = (ArrayList<InStorePO>) this.readList(instorerecord);
			
			//将记录加到现有记录的后面
			for(int i=0;i<po.size();i++){
				records.add(po.get(i));
			}
			
			//接着将对象写回文件中
			this.writeList(instorerecord, records);
			
			//接着保存入库单
			if(po.size()>0){//暂时现将第一个货物的编号作为入库单id
				InStoreBillPO bill = new InStoreBillPO(po.get(0).getUser(), po, df.format(Calendar.getInstance().getTime()));
				ArrayList<InStoreBillPO> temp;
				
				//读入已有的单据数据
				temp = (ArrayList<InStoreBillPO>) this.readList(instorebill);
				temp.add(bill);

				//接着将对象写回文件中
				this.writeList(instorebill, temp);
			}
				
			return new ResultMessage("success", null);
			
		} catch (Exception e) {//出错后返回出错
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	//保存出库记录的同时更新库存
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po)
			throws RemoteException {
		ArrayList<OutStorePO> records = null;
		
		try {
			//读入出库记录数据
			records = (ArrayList<OutStorePO>) this.readList(outstorerecord);
			
			//将记录加到现有记录的后面
			for(int i=0;i<po.size();i++){
				records.add(po.get(i));
			}
			
			//接着将对象写回文件中
			this.writeList(outstorerecord, records);
			
			//接着保存出库单
			if(po.size()>0){//暂时现将第一个货物的编号作为出库单id
				OutStoreBillPO bill = new OutStoreBillPO(po.get(0).getUser(), po, df.format(Calendar.getInstance().getTime()));
				ArrayList<OutStoreBillPO> temp;
				
				//读入已有的单据数据
				temp = (ArrayList<OutStoreBillPO>) this.readList(outstorebill);
				temp.add(bill);

				//接着将对象写回文件中
				this.writeList(outstorebill, temp);
			}
				
			return new ResultMessage("success", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage saveVerification(VerificationPO po)
			throws RemoteException {
		ArrayList<VerificationPO> records = null;
		
		try {//读入出库记录数据
			records = (ArrayList<VerificationPO>) this.readList(verificationrecord);
			
			//将记录加到现有记录的后面
			records.add(po);
			
			//接着将对象写回文件中
			this.writeList(verificationrecord, records);
			
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	

	//保存调整记录的同时更新库存
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage saveAdjust(ArrayList<AdjustPO> po) throws RemoteException {
		ArrayList<AdjustPO> records = null;
		
		try {
			//读入调整记录数据
			records = (ArrayList<AdjustPO>) this.readList(adjustrecord);
			
			//将记录加到现有记录的后面
			for(int i=0;i<po.size();i++){
				records.add(po.get(i));
			}
			
			//接着将对象写回文件中
			this.writeList(adjustrecord, records);
				
			return new ResultMessage("success", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage finds(Calendar start, Calendar end)
			throws RemoteException {
		//总的出入库记录
		ArrayList<InStorePO> instore = null;
		ArrayList<OutStorePO> outstore = null;
		//筛选出来的出入库记录
		ArrayList<InStorePO> ins = new ArrayList<InStorePO>();
		ArrayList<OutStorePO> outs = new ArrayList<OutStorePO>();
		
		try {//分别读取所有出库和入库记录
			instore = (ArrayList<InStorePO>) this.readList(instorerecord);
			outstore = (ArrayList<OutStorePO>) this.readList(outstorerecord);
			
			//对对象中的时间进行比较，如果在范围内，则加入返回结果
			for(int i=0;i<instore.size();i++){
				InStorePO temp = instore.get(i);
				
				if(start.compareTo(temp.getDate())<=0&&end.compareTo(temp.getDate())>=0){
					ins.add(temp);
				}
			}
			
			for(int i=0;i<outstore.size();i++){
				OutStorePO temp = outstore.get(i);
				
				if(start.compareTo(temp.getDate())<=0&&end.compareTo(temp.getDate())>=0){
					outs.add(temp);
				}
			}
			
			return new ResultMessage("success", new IORecordPO(ins, outs));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	

	@Override
	public ResultMessage getStore() {
		StorePO store = null;
		
		try {//读入库存数据
			store = (StorePO) this.readList(storerecord);
			
			store.show();
			
			return new ResultMessage("success", store);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	
	@Override
	public ResultMessage saveStore(StorePO store) throws RemoteException {
		
		try {
			this.writeList(storerecord, store);
			
			store.show();
			
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	
	
	private Object readList(String path) throws Exception{
		Object list;
		
		FileInputStream in = new FileInputStream(path);
		ObjectInputStream objin = new ObjectInputStream(in);
		list = objin.readObject();
		objin.close();
			
		return list;
	}
	
	
	private void writeList(String path, Object list) throws Exception{
		//将新的库存写入文件
		FileOutputStream out = new FileOutputStream(path);
		ObjectOutputStream objout = new ObjectOutputStream(out);
		objout.writeObject(list);
		objout.close();
	}
	
	private final SimpleDateFormat df= new SimpleDateFormat("yyyyMMddHHmmss");
}

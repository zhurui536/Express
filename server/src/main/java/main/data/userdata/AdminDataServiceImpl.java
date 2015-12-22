package main.data.userdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.userdataservice.AdminDataService;
import po.StaffMessagePO;
import po.UserPO;
import util.ResultMessage;

public class AdminDataServiceImpl extends UnicastRemoteObject implements AdminDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2560801151861337295L;
	
	public AdminDataServiceImpl() throws RemoteException{
		super();
		
//		this.generatePath();
		
		File file = new File(userrecord);
		
		if(file.exists()){
			try {
				FileInputStream in = new FileInputStream(file);
				if(in.available() == 0){
					in.close();
					ArrayList<UserPO> users = new ArrayList<UserPO>();
					this.writeList(userrecord, users);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				file.createNewFile();
				ArrayList<UserPO> users = new ArrayList<UserPO>();
				this.writeList(userrecord, users);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ResultMessage getUser() throws RemoteException {
		ArrayList<UserPO> users;
		
		try {
			users = (ArrayList<UserPO>) this.readList(userrecord);
			
			return new ResultMessage("success", users);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage saveUser(ArrayList<UserPO> users)
			throws RemoteException {
		try {
			this.writeList(userrecord, users);
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	
	@Override
	public ResultMessage getStaff() throws RemoteException {
		ArrayList<StaffMessagePO> staff = null;
		
		try {
			staff = (ArrayList<StaffMessagePO>) this.readList(staffmessage);
			return new ResultMessage("success", staff);
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
	
	private String userrecord = "src/main/java/save/userdata/userPO.dat";
	private String staffmessage = "src/main/java/save/infodata/staffMessagePO.dat";

}

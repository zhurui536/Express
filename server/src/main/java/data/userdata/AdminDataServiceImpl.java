package data.userdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.infodata.StaffMessageMaintenanceDataServiceImpl;
import dataservice.userdataservice.AdminDataService;
import po.InstitutionMessagePO;
import po.StaffMessagePO;
import po.UserPO;
import util.AuthorityLevel;
import util.Job;
import util.ResultMessage;
import util.SalaryType;

public class AdminDataServiceImpl extends UnicastRemoteObject implements AdminDataService {

	private static final long serialVersionUID = 2560801151861337295L;
	
	public AdminDataServiceImpl() throws RemoteException{
		super();
		
		File file = new File(userrecord);
		
		if(file.exists()){
			try {
				FileInputStream in = new FileInputStream(file);
				if(in.available() == 0){
					in.close();
					ArrayList<UserPO> users = new ArrayList<UserPO>();
					users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
					users.add(new UserPO("2", "2", "141250212", AuthorityLevel.HIGH));
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
				users.add(new UserPO("admin", "admin", "admin", AuthorityLevel.HIGH));
				users.add(new UserPO("2", "2", "141250212", AuthorityLevel.HIGH));
				this.writeList(userrecord, users);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		file = new File(this.staffmessage);
		if(file.exists()){
			try {
				FileInputStream in = new FileInputStream(file);
				if(in.available() == 0){
					in.close();
					StaffMessageMaintenanceDataServiceImpl staffdata = new StaffMessageMaintenanceDataServiceImpl();
					staffdata.insert(new StaffMessagePO("admin", "admin", "admin", Job.ADMIN, SalaryType.MONTHLY, 0));
					staffdata.insert(new StaffMessagePO("141250212", "朱浩然", "admin", Job.MANAGER, SalaryType.MONTHLY, 0));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				file.createNewFile();
				StaffMessageMaintenanceDataServiceImpl staffdata = new StaffMessageMaintenanceDataServiceImpl();
				staffdata.insert(new StaffMessagePO("admin", "admin", "admin", Job.ADMIN, SalaryType.MONTHLY, 0));
				staffdata.insert(new StaffMessagePO("141250212", "朱浩然", "admin", Job.MANAGER, SalaryType.MONTHLY, 0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
	
	private String userrecord = "save/userdata/userPO.dat";
	private String staffmessage = "save/infodata/staffMessagePO.dat";
	private static final String INSTITUTION_MESSAGE_PATH = "save/infodata/institutionMessagePO.dat";

        @SuppressWarnings("unchecked")
        @Override
        public ResultMessage getInstitution(String institutionId)
                        throws RemoteException {
                ArrayList<InstitutionMessagePO> institutionMessagePOs = null;
                try {
                        institutionMessagePOs = (ArrayList<InstitutionMessagePO>) this.readList(INSTITUTION_MESSAGE_PATH);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResultMessage("dataerror", null);
                }
                for (InstitutionMessagePO institutionMessagePO : institutionMessagePOs) {
                        if(institutionMessagePO.getId().equals(institutionId)){
                                return new ResultMessage("success",institutionMessagePO);
                        }
                }
                return new ResultMessage("not_found");
        }

}

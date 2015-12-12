package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import util.ResultMessage;

public interface AdminDataService  extends Remote {
	public ResultMessage getUser() throws RemoteException;
	
	public ResultMessage getStaff() throws RemoteException;
	
	public ResultMessage saveUser(ArrayList<UserPO> users)throws RemoteException;
}

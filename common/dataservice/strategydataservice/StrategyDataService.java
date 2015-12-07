package dataservice.strategydataservice;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;
import po.StaffMessagePO;



/*
 * Created By Wippy
 * 2015/10/26
 */


public interface StrategyDataService {
	public ResultMessage find(long id) throws RemoteException;
	
	public ResultMessage finds(String Post) throws RemoteException;
	
	public void update(StaffMessagePO po) throws RemoteException;
	
	public void delete(StaffMessagePO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;
}
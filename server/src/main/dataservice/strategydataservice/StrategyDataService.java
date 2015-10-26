package main.dataservice.strategydataservice;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;
import main.po.StaffPO;


/*
 * Created By Wippy
 * 2015/10/26
 */


public interface StrategyDataService {
	public ResultMessage find(long id) throws RemoteException;
	
	public ResultMessage finds(String Post) throws RemoteException;
	
	public void update(StaffPO po) throws RemoteException;
	
	public void delete(StaffPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public void finish() throws RemoteException;
}
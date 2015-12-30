package dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DistancePO;
import po.StaffMessagePO;
import util.ResultMessage;



/*
 * Created By Wippy
 * 2015/10/26
 */


public interface StrategyDataService extends Remote {
	public ResultMessage getDistance() throws RemoteException;
	
	public ResultMessage SaveDistance(ArrayList<DistancePO> pos) throws RemoteException;
	
	public ResultMessage saveSalary(ArrayList<StaffMessagePO> pos) throws RemoteException;
	
	public ResultMessage savePrice(double price) throws RemoteException;
	
	public ResultMessage getPrice() throws RemoteException;
	
	public ResultMessage getSalary() throws RemoteException;
}
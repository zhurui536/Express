package dataservice.strategydataservice;

import main.bussinesslogic.util.ResultMessage;
import po.DistancePO;
import po.SalaryPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;



/*
 * Created By Wippy
 * 2015/10/26
 */


public interface StrategyDataService extends Remote {
	public ResultMessage getDistance() throws RemoteException;
	
	public ResultMessage SaveDistance(ArrayList<DistancePO> pos) throws RemoteException;
	
	public ResultMessage update(SalaryPO po) throws RemoteException;
	
	public ResultMessage savePrice(double price) throws RemoteException;
	
	public ResultMessage getPrice() throws RemoteException;
}
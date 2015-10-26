package main.dataservice.storedataservice;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.po.AdjustPO;
import main.po.GoodsPO;
import main.po.IORecordPO;
import main.po.InStorePO;
import main.po.OutStorePO;
import main.po.StorePlace;
import main.po.VerificationPO;


/**
 *Created by ZHR
 *2015年10月26日
 */

public interface StoreDataService {
	public ResultMessage find(long id) throws RemoteException;
	
	public ArrayList<IORecordPO> finds(Time start, Time end) throws RemoteException;
	
	public ResultMessage find(StorePlace place) throws RemoteException;
	
	public ResultMessage delete(GoodsPO po) throws RemoteException;
	
	public ResultMessage update(StorePlace place, GoodsPO po) throws RemoteException;
	
	public ResultMessage saveInStore(ArrayList<InStorePO>  po) throws RemoteException;
	
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po) throws RemoteException;
	
	public ResultMessage saveVerification(VerificationPO po) throws RemoteException;
	
	public ResultMessage saveAdjust(AdjustPO po) throws RemoteException;

}

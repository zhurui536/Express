package dataservice.storedataservice;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import po.GoodsPO;
import po.storepo.AdjustPO;
import po.storepo.IORecordPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;


/**
 *Created by ZHR
 *2015年10月26日
 */

public interface StoreDataService {
	public ResultMessage find(String id) throws RemoteException;
	
	public ArrayList<IORecordPO> finds(Time start, Time end) throws RemoteException;
	
	public ResultMessage find(StorePlacePO place) throws RemoteException;
	
	public ResultMessage delete(GoodsPO po) throws RemoteException;
	
	public ResultMessage update(StorePlacePO place, GoodsPO po) throws RemoteException;
	
	public ResultMessage saveInStore(ArrayList<InStorePO>  po) throws RemoteException;
	
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po) throws RemoteException;
	
	public ResultMessage saveVerification(VerificationPO po) throws RemoteException;
	
	public ResultMessage saveAdjust(AdjustPO po) throws RemoteException;

}

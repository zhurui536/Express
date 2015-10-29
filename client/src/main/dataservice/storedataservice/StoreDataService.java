package main.dataservice.storedataservice;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.po.GoodsPO;
import main.po.storepo.AdjustPO;
import main.po.storepo.IORecordPO;
import main.po.storepo.InStorePO;
import main.po.storepo.OutStorePO;
import main.po.storepo.StorePlacePO;
import main.po.storepo.VerificationPO;


/**
 *Created by ZHR
 *2015年10月26日
 */

public interface StoreDataService {
	public ResultMessage find(long id) throws RemoteException;
	
	public ArrayList<IORecordPO> finds(Time start, Time end) throws RemoteException;
	
	public ResultMessage find(StorePlacePO place) throws RemoteException;
	
	public ResultMessage delete(GoodsPO po) throws RemoteException;
	
	public ResultMessage update(StorePlacePO place, GoodsPO po) throws RemoteException;
	
	public ResultMessage saveInStore(ArrayList<InStorePO>  po) throws RemoteException;
	
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po) throws RemoteException;
	
	public ResultMessage saveVerification(VerificationPO po) throws RemoteException;
	
	public ResultMessage saveAdjust(AdjustPO po) throws RemoteException;

}

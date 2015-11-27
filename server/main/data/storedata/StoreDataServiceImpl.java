package main.data.storedata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import main.bussinesslogic.util.ResultMessage;
import po.GoodsPO;
import po.storepo.AdjustPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;
import dataservice.storedataservice.StoreDataService;

public class StoreDataServiceImpl implements StoreDataService {

	@Override
	public ResultMessage find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage find(StorePlacePO place) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(StorePlacePO place, GoodsPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveInStore(ArrayList<InStorePO> po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveVerification(VerificationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveAdjust(AdjustPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getGoods(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage finds(Calendar start, Calendar end)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getStore() {
		// TODO Auto-generated method stub
		return null;
	}

}

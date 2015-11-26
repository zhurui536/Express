package dataservice.storedataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import po.GoodsPO;
import po.storepo.AdjustPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;

public class StoreDataService_Stub implements StoreDataService {

	@Override
	public ResultMessage find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id.equals("111111111")){
			return new ResultMessage("exist", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}
	}

	@Override
	public ResultMessage find(StorePlacePO place) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("checking for the place "+place.getArea()+" "+place.getRow()+" "+place.getShelf()+" "+place.getPlace());
		
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete a goods!");
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage update(StorePlacePO place, GoodsPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update the place "+place.getArea()+" "+place.getRow()+" "+place.getShelf()+" "+place.getPlace()+" with a goods");
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage saveInStore(ArrayList<InStorePO> po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Saving " + po.size() + "InStore records!");
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Saving " + po.size() + "OutStore records!");
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage saveVerification(VerificationPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Saving Verification records!");
		
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage saveAdjust(AdjustPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Saving adjust records!");
		return new ResultMessage("success", null);
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

}

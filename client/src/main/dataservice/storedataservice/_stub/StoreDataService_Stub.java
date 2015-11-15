package main.dataservice.storedataservice._stub;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.dataservice.storedataservice.StoreDataService;
import main.po.GoodsPO;
import main.po.storepo.AdjustPO;
import main.po.storepo.IORecordPO;
import main.po.storepo.InStorePO;
import main.po.storepo.OutStorePO;
import main.po.storepo.StorePlacePO;
import main.po.storepo.VerificationPO;

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
	public ArrayList<IORecordPO> finds(Time start, Time end)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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

}

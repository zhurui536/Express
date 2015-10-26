package main.dataservice.storedataservice._stub;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.dataservice.storedataservice.StoreDataService;
import main.po.AdjustPO;
import main.po.GoodsPO;
import main.po.IORecordPO;
import main.po.InStorePO;
import main.po.OutStorePO;
import main.po.StorePlacePO;
import main.po.VerificationPO;

public class StoreDataService_Stub implements StoreDataService {

	@Override
	public ResultMessage find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=1000000000&&id<=Long.MAX_VALUE){
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
		return null;
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

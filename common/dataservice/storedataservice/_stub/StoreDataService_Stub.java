package dataservice.storedataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import po.GoodsPO;
import po.UserPO;
import po.storepo.AdjustPO;
import po.storepo.IORecordPO;
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
		
		return new ResultMessage("success", place);
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
	public ResultMessage saveAdjust(ArrayList<AdjustPO> po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Saving adjust records!");
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage getGoods(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new ResultMessage("success", new GoodsPO("111111111", "袁阳阳", "南京", "南京", 0, 0, null, null, 0));
	}

	@Override
	public ResultMessage finds(Calendar start, Calendar end)
			throws RemoteException {
		GoodsPO goods = new GoodsPO("111111111", "袁阳阳", "南京", "南京", 0, 0, null, null, 0);
		StorePlacePO place = new StorePlacePO(0, 0, 0 ,0);
		InStorePO in = new InStorePO(goods, goods.getDestination(), place, new UserPO("10086", "10010"));
		OutStorePO out = new OutStorePO(goods, place, goods.getDestination(), new UserPO("10086", "10010"), Trans.PLANE, "10010");
		ArrayList<InStorePO> listin = new ArrayList<InStorePO>();
		listin.add(in);
		ArrayList<OutStorePO> listout = new ArrayList<OutStorePO>();
		listout.add(out);
		
		return new ResultMessage("success", new IORecordPO(listin, listout));
	}

	@Override
	public ResultMessage getStore() {
		// TODO Auto-generated method stub
		return null;
	}

}

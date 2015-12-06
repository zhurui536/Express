package dataservice.storedataservice._stub;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import po.GoodsPO;
import po.UserPO;
import po.storepo.AdjustPO;
import po.storepo.IORecordPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;

public class StoreDataService_Stub implements StoreDataService {
	private final static String filename = "common/dataservice/storedataservice/_stub/storedata.txt";
	
	public StoreDataService_Stub(){
		
	}
	
//	public static void main(String[] args){
//		StorePO store = new StorePO(2, 3, 5, 6);
//		try {
//			FileOutputStream out = new FileOutputStream(filename);
//			ObjectOutputStream objout = new ObjectOutputStream(out);
//			objout.writeObject(store);
//			objout.close();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	}

	@Override
	public ResultMessage find(String id) throws RemoteException {
		if(Integer.parseInt(id)>=100000000&&Integer.parseInt(id)<=Integer.MAX_VALUE){
			return new ResultMessage("exist", new GoodsPO(id, "sb", "南京", "北京", 1, 1, PackageType.CARTONS, ExpressType.COURIER,100));
		}
		else{
			return new ResultMessage("noexist", null);
		}
	}

	@Override
	public ResultMessage find(StorePlacePO place) throws RemoteException{
		StorePO store = null;
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream objin = new ObjectInputStream(in);
			store = (StorePO) objin.readObject();
			
			objin.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("checking for the place "+place.getArea()+" "+place.getRow()+" "+place.getShelf()+" "+place.getPlace());
		store.show();
		return new ResultMessage("success", store.getStorePlace(place.getArea(), place.getRow(), place.getShelf(), place.getPlace()));
	}

	@Override
	public ResultMessage delete(GoodsPO po) throws RemoteException {
		StorePO store = null;
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream objin = new ObjectInputStream(in);
			store = (StorePO) objin.readObject();
			
			objin.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for(int a=0;a<store.getArea();a++){
			for(int r=0;r<store.getRow();r++){
				for(int s=0;s<store.getShelf();s++){
					for(int p=0;p<store.getPlace();p++){
						StorePlacePO temp = store.getStorePlace(a, r, s, p);
						if(temp.ifEmpty()){
							continue;
						}
						else if(temp.getGoods().getId().equals(po.getId())){
							temp.setGoods(null);
							store.setStorePlace(temp);
							store.show();
							return new ResultMessage("success", null);
						}
					}
				}
			}
		}
		
		try {
			FileOutputStream out = new FileOutputStream(filename);
			ObjectOutputStream objout = new ObjectOutputStream(out);
			objout.writeObject(store);
			objout.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		store.show();
		return new ResultMessage("noexist", null);
	}

	@Override
	public ResultMessage update(StorePlacePO place, GoodsPO po)
			throws RemoteException {
		StorePO store = null;
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream objin = new ObjectInputStream(in);
			store = (StorePO) objin.readObject();
			
			objin.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		place.setGoods(po);
		store.setStorePlace(place);
		
		try {
			FileOutputStream out = new FileOutputStream(filename);
			ObjectOutputStream objout = new ObjectOutputStream(out);
			objout.writeObject(store);
			objout.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		store.show();
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
		return new ResultMessage("success", new GoodsPO(id, "袁阳阳", "南京", "南京", 0, 0, null, null, 0));
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
		StorePO store = null;
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream objin = new ObjectInputStream(in);
			store = (StorePO) objin.readObject();
			
			objin.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ResultMessage("success", store);
	}

	@Override
	public ResultMessage ifInStore(String id) throws RemoteException {
		StorePO store = null;
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream objin = new ObjectInputStream(in);
			store = (StorePO) objin.readObject();
			
			objin.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for(int a=0;a<store.getArea();a++){
			for(int r=0;r<store.getRow();r++){
				for(int s=0;s<store.getShelf();s++){
					for(int p=0;p<store.getPlace();p++){
						StorePlacePO temp = store.getStorePlace(a, r, s, p);
						if(temp.ifEmpty()){
							continue;
						}
						else if(temp.getGoods().getId().equals(id)){
							store.show();
							return new ResultMessage("exist", temp.getGoods());
						}
					}
				}
			}
		}
		store.show();
		return new ResultMessage("noexist", null);
	}

}

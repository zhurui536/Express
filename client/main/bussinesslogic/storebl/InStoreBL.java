package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.storedataservice.StoreDataService;
import dataservice.storedataservice._stub.StoreDataService_Stub;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.InStoreBLService;
import main.data.storedata.StoreDataServiceImpl;
import main.vo.storevo.InStoreVO;
import main.vo.storevo.StorePlaceVO;
import po.GoodsPO;
import po.UserPO;
import po.storepo.InStorePO;
import po.storepo.StorePlacePO;

public class InStoreBL implements InStoreBLService {
	private StoreDataService dataservice;
	private UserPO user;
	private ArrayList<InStorePO> goodslist;
	
	public InStoreBL(UserPO user){
		this.user = user;
		dataservice = new StoreDataService_Stub();
	}

	@Override
	public ResultMessage newInStore() {
		goodslist = new ArrayList<InStorePO>();
		return new ResultMessage("success", goodslist);
	}

	@Override
	public ResultMessage addInStoreGoods(String id, StorePlaceVO p,
			String destination) {
		StorePlacePO place = new StorePlacePO(p.getArea(), p.getRow(), p.getShelf(), p.getPlace());
		try {
			ResultMessage result = dataservice.getGoods(id);
			if(result.getKey().equals("noexist")){
				return result;
			}
			else{
				GoodsPO goods = (GoodsPO) result.getValue();
				result = dataservice.find(place);
				StorePlacePO theplace = (StorePlacePO) result.getValue();
				if(!theplace.ifEmpty()){
					return new ResultMessage("usedplace", null);
				}
				else{
					goodslist.add(new InStorePO(goods, destination, place, user));
					return new ResultMessage("success", new InStoreVO(goodslist));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public ResultMessage delInStoreGoods(String id) {
		for(int i=0;i<goodslist.size();i++){
			if(id.equals(goodslist.get(i).getGoodsID())){
				goodslist.remove(i);
				return new ResultMessage("success", new InStoreVO(goodslist));
			}
		}
		return new ResultMessage("noexist", new InStoreVO(goodslist));
	}

	@Override
	public ResultMessage endInStore(int condition) {
		if(condition == 0){
			for(int i=0;i<goodslist.size();i++){
				try {
					dataservice.update(goodslist.get(i).getStorePlace(), goodslist.get(i).getGoods());
				} catch (RemoteException e) {
					e.printStackTrace();
					return new ResultMessage("internet error", null);
				}
			}
			
			try {
				dataservice.saveInStore(goodslist);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
			
			return new ResultMessage("success", null);
		}
		else if(condition == 1){
			return new ResultMessage("success", null);
		}
		
		return new ResultMessage("unknown operation", null);

	}

}

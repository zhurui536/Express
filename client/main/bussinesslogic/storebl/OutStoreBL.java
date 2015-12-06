package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import po.UserPO;
import po.storepo.OutStorePO;
import dataservice.storedataservice.StoreDataService;
import dataservice.storedataservice._stub.StoreDataService_Stub;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.OutStoreBLService;
import main.data.storedata.StoreDataServiceImpl;
import main.vo.storevo.OutStoreVO;

public class OutStoreBL implements OutStoreBLService {
	
	private StoreDataService dataservice;
	private UserPO user;
	private ArrayList<OutStorePO> goodslist;
	
	public OutStoreBL(UserPO user){
		dataservice = new StoreDataService_Stub();
		this.user = user;
		
	}
	
	@Override
	public ResultMessage newOutStore() {
		goodslist = new ArrayList<OutStorePO>();
		return new ResultMessage("success", new OutStoreVO(goodslist));
	}

	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination) {
		try {
			ResultMessage result = dataservice.ifInStore(id);
			if(result.getKey().equals("exist")){
				GoodsPO thegoods = (GoodsPO) result.getValue();
				goodslist.add(new OutStorePO(thegoods, null, Destination, user, trans, Destination));
				
				return new ResultMessage("success", new OutStoreVO(goodslist));
			}
			else{
				return new ResultMessage("noexist", new OutStoreVO(goodslist));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage("internet error", new OutStoreVO(goodslist));
		}
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		for(int i=0;i<goodslist.size();i++){
			if(id.equals(goodslist.get(i).getGoodsID())){
				goodslist.remove(i);
				return new ResultMessage("success", new OutStoreVO(goodslist));
			}
		}
		return new ResultMessage("noexist", new OutStoreVO(goodslist));
	}

	@Override
	public ResultMessage endOutStore(int condition) {
		if(condition == 0){
			for(int i=0;i<goodslist.size();i++){
				try {
					dataservice.delete(goodslist.get(i).getGoods());
				} catch (RemoteException e) {
					e.printStackTrace();
					return new ResultMessage("internet error", new OutStoreVO(goodslist));
				}
			}
			
			try {
				dataservice.saveOutStore(goodslist);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage("internet error", new OutStoreVO(goodslist));
			}
			
			return new ResultMessage("success", new OutStoreVO(goodslist));
		}
		else if(condition == 1){
			return new ResultMessage("success", new OutStoreVO(goodslist));
		}
		
		return new ResultMessage("unknown operation", new OutStoreVO(goodslist));

	}

}
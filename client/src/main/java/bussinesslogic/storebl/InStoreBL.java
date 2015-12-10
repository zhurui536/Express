package bussinesslogic.storebl;

import bussinesslogicservice.storeblservice.InStoreBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;
import po.GoodsPO;
import po.UserPO;
import po.storepo.InStorePO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.ResultMessage;
import vo.storevo.InStoreVO;
import vo.storevo.StorePlaceVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class InStoreBL implements InStoreBLService {
	private StoreDataService dataservice;
	private UserPO user;
	private ArrayList<InStorePO> goodslist;
	
	public InStoreBL(UserPO user){
		this.user = user;
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
	}

	@Override
	public ResultMessage newInStore() {
		goodslist = new ArrayList<InStorePO>();
		return new ResultMessage("success", goodslist);
	}

	@Override
	public ResultMessage addInStoreGoods(String id, StorePlaceVO p,
			String destination) {
		if(ifAppear(p)){
			return new ResultMessage("usedplace", null);
		}
		StorePlacePO place = new StorePlacePO(p.getArea(), p.getRow(), p.getShelf(), p.getPlace());
		try {
			ResultMessage result = dataservice.find(id);
			if(result.getKey().equals("noexist")){//货物不存在时，返回不存在
				return new ResultMessage("noexist", null);
			}
			else{//货物存在时，继续检查该位置
				GoodsPO goods = (GoodsPO) result.getValue();
				result = dataservice.getStore();
				if(result.getKey().equals("success")){
					StorePO store = (StorePO) result.getValue();
					
					StorePlacePO theplace = store.getStorePlace(p.getArea(), p.getRow(), p.getShelf(), p.getPlace());
					if(!theplace.ifEmpty()){//该位置有货物时，返回对应的结果
						return new ResultMessage("usedplace", null);
					}
					else{//该位置没有货物时，返回输入成功
						goodslist.add(new InStorePO(goods, destination, place, user));
						return new ResultMessage("success", new InStoreVO(goodslist));
					}
				}
				else{//返回其他查找结果
					return result;
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
		if(condition == 0){//0表示确定结束入库
			try {
				ResultMessage result = dataservice.getStore();
				
				if(result.getKey().equals("success")){
					StorePO store = (StorePO) result.getValue();
					
					for(int i=0;i<goodslist.size();i++){//进行改写
						InStorePO temp = goodslist.get(i);
						StorePlacePO place = temp.getStorePlace();
						place.setGoods(temp.getGoods());
						store.setStorePlace(place);
					}
					
					result = dataservice.saveStore(store);
					
					if(!result.getKey().equals("success")){
						return new ResultMessage("dataerror", new InStoreVO(goodslist));
					}
				}
				dataservice.saveInStore(goodslist);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
			
			return new ResultMessage("success", null);
		}
		else if(condition == 1){//1表示取消入库
			return new ResultMessage("success", null);
		}
		
		return new ResultMessage("unknown operation", null);

	}
	
	//检查新的位置是否已经出现过
	private boolean ifAppear(StorePlaceVO newplace){
		for(int i=0;i<goodslist.size();i++){
			InStorePO temp = goodslist.get(i);
			StorePlacePO place = temp.getStorePlace();
			
			if(place.getArea()==newplace.getArea()&&place.getRow()==newplace.getRow()&&place.getShelf()==newplace.getShelf()&&place.getPlace()==newplace.getPlace())
				return true;
		}
		
		return false;
	}

}

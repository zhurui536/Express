package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import po.UserPO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;
import dataservice.storedataservice.StoreDataService;
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
		dataservice = new StoreDataServiceImpl();
		this.user = user;
		
	}
	
	@Override
	public ResultMessage newOutStore() {
		goodslist = new ArrayList<OutStorePO>();
		return new ResultMessage("success", new OutStoreVO(goodslist));
	}

	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination, String billid) {
		//检查该货物的id是否已经输入
		for(int i=0;i<goodslist.size();i++){
			OutStorePO temp = goodslist.get(i);
			if(temp.getGoodsID().equals(id)){
				return new ResultMessage("inputedid", null);
			}
		}
		try {//id无误之后检查该id是否在库存中
			ResultMessage result = dataservice.ifInStore(id);
			if(result.getKey().equals("exist")){
				StorePlacePO place = (StorePlacePO) result.getValue();
				goodslist.add(new OutStorePO(place.getGoods(), place, Destination, user, trans, billid));
				
				return new ResultMessage("success", new OutStoreVO(goodslist));
			}
			else if(result.getKey().equals("noexist")){
				return new ResultMessage("noexist", new OutStoreVO(goodslist));
			}
			else{
				return result;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", new OutStoreVO(goodslist));
		}
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		for(int i=0;i<goodslist.size();i++){//检查书否有该货物，如果有则删除
			if(id.equals(goodslist.get(i).getGoodsID())){
				goodslist.remove(i);
				return new ResultMessage("success", new OutStoreVO(goodslist));
			}
		}
		return new ResultMessage("noexist", new OutStoreVO(goodslist));
	}

	@Override
	public ResultMessage endOutStore(int condition) {
		if(condition == 0){//0代表确定结束出库
			//保存出库记录
			try {
				dataservice.saveOutStore(goodslist);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", new OutStoreVO(goodslist));
			}
			
			return new ResultMessage("success", new OutStoreVO(goodslist));
		}
		else if(condition == 1){//1代表取消出库
			return new ResultMessage("success", new OutStoreVO(goodslist));
		}
		
		return new ResultMessage("unknown operation", new OutStoreVO(goodslist));

	}

}

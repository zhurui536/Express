package bussinesslogic.storebl;

import bussinesslogicservice.storeblservice.AdjustBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;
import po.GoodsPO;
import po.storepo.AdjustPO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.PublicMessage;
import util.ResultMessage;
import vo.storevo.AdjustVO;
import vo.storevo.StorePlaceVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class AdjustBL implements AdjustBLService {
	private StoreDataService dataservice;
	private ArrayList<AdjustPO> adjusts;
	private String user;
	
	public AdjustBL(){
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
		this.user = PublicMessage.staffID;
	}

	@Override
	public ResultMessage newAdjust() {
		adjusts = new ArrayList<AdjustPO>();
		
		return new ResultMessage("success", new AdjustVO(adjusts));
	}

	@Override
	public ResultMessage addAdjust(StorePlaceVO s, StorePlaceVO e) {
		//检查该位置在之前的输入中是否已经出现
		if(ifAppear(s))
			return new ResultMessage("appearedplace", new AdjustVO(adjusts));
		if(ifAppear(e))
			return new ResultMessage("appearedplace", new AdjustVO(adjusts));
		
		//将VO转换成对应的PO
		StorePlacePO start = new StorePlacePO(s.getArea(), s.getRow(), s.getShelf(), s.getPlace());
		StorePlacePO end = new StorePlacePO(e.getArea(), e.getRow(), e.getShelf(), e.getPlace());
		
		try {
			ResultMessage result = dataservice.getStore();
			if(result.getKey().equals("success")){//如果成功获得库存，则检查开始与结束位置
				StorePO store = (StorePO) result.getValue();
				start = store.getStorePlace(s.getArea(), s.getRow(), s.getShelf(), s.getPlace());
				if(start.ifEmpty()){
					return new ResultMessage("emptystart", null);
				}
				
				end = store.getStorePlace(e.getArea(), e.getRow(), e.getShelf(), e.getPlace());
				if(!end.ifEmpty()){
					return new ResultMessage("usedend", null);
				}
				
				adjusts.add(new AdjustPO(start, end, user));
				
				return new ResultMessage("success", new AdjustVO(adjusts));
			}
			else{
				return new ResultMessage(result.getKey(), null);
			}
		} catch (RemoteException exception) {
			exception.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
	
	@Override
	public ResultMessage delAdjust(int i) {
		adjusts.remove(i);
		
		return new ResultMessage("success", new AdjustVO(adjusts));
	}

	@Override
	public ResultMessage endAdjust(int condition) {
		if(condition == 0){
			try {//存储调整记录
				ResultMessage result = dataservice.getStore();
				if(result.getKey().equals("success")){//如果成功获得库存，则对库存进行改写
					StorePO store = (StorePO) result.getValue();

					//将所有的调整项对库存进行实现
					for(int i=0;i<adjusts.size();i++){
						AdjustPO temp = adjusts.get(i);
						StorePlacePO start = temp.getStart();
						StorePlacePO end = temp.getEnd();
						
						start = store.getStorePlace(start.getArea(), start.getRow(), start.getShelf(), start.getPlace());
						end = store.getStorePlace(end.getArea(), end.getRow(), end.getShelf(), end.getPlace());
						
						GoodsPO goods = start.getGoods();
						start.setGoods(end.getGoods());
						end.setGoods(goods);
						
						store.setStorePlace(start);
						store.setStorePlace(end);
					}
					
					result = dataservice.saveStore(store);
					if(result.getKey().equals("success")){
						return new ResultMessage("success", null);
					}
					else{
						return new ResultMessage(result.getKey(), null);
					}
				}
				else{
					return new ResultMessage(result.getKey(), null);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
		}
		else{
			return new ResultMessage("success", null);
		}
	}
	
	private boolean ifAppear(StorePlaceVO place){
		for(int i=0;i<adjusts.size();i++){
			AdjustPO temp = adjusts.get(i);
			StorePlacePO start = temp.getStart();
			StorePlacePO end = temp.getEnd();
			
			if(place.getArea()==start.getArea()&&place.getRow()==start.getRow()&&place.getShelf()==start.getShelf()&&place.getPlace()==start.getPlace())
				return true;
			if(place.getArea()==end.getArea()&&place.getRow()==end.getRow()&&place.getShelf()==end.getShelf()&&place.getPlace()==end.getPlace())
				return true;	
		}
		
		return false;
	}
}

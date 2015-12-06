package main.bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.storedataservice.StoreDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.AdjustBLService;
import main.data.storedata.StoreDataServiceImpl;
import main.vo.storevo.AdjustVO;
import main.vo.storevo.StorePlaceVO;
import po.GoodsPO;
import po.UserPO;
import po.storepo.AdjustPO;
import po.storepo.StorePlacePO;

public class AdjustBL implements AdjustBLService {
	private StoreDataService dataservice;
	private ArrayList<AdjustPO> adjusts;
	private UserPO user;
	
	public AdjustBL(UserPO user){
		dataservice = new StoreDataServiceImpl();
		this.user = user;
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
			ResultMessage result = dataservice.find(start);
			//如果查找成功，则继续检查end
			if(result.getKey().equals("success")){
				start = (StorePlacePO) result.getValue();
				GoodsPO goodsOfStart = start.getGoods();
				if(goodsOfStart == null){
					return new ResultMessage("emptystart", new AdjustVO(adjusts));
				}
				
				//检查end，如果end也符合条件，则操作成功，否则操作失败
				result = dataservice.find(end);
				if(result.getKey().equals("success")){
					end = (StorePlacePO) result.getValue();
					GoodsPO goodsOfEnd = end.getGoods();
					if(goodsOfEnd != null){
						return new ResultMessage("usedend", new AdjustVO(adjusts));
					}
					
					adjusts.add(new AdjustPO(start, end, user));
					
					return new ResultMessage("success", new AdjustVO(adjusts));
				}
				else{
					return new ResultMessage(result.getKey(), new AdjustVO(adjusts));
				}
			}
			else{
				return new ResultMessage(result.getKey(), new AdjustVO(adjusts));
			}
			
		} catch (RemoteException exception) {
			exception.printStackTrace();
			return new ResultMessage("internet error", new AdjustVO(adjusts));
		}
	}
	
	@Override
	public ResultMessage delAdjust(int i) {
		adjusts.remove(i);
		
		return new ResultMessage("success", new AdjustVO(adjusts));
	}

	@Override
	public ResultMessage endAdjust(int condition) {
		try {//存储调整记录
			dataservice.saveAdjust(adjusts);
			return new ResultMessage("success", null);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", new AdjustVO(adjusts));
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

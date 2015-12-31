package bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.storeblservice.InStoreBLService;
import connection.ClientRMIHelper;
import dataservice.storedataservice.StoreDataService;
import po.GoodsPO;
import po.storepo.InStoreBillPO;
import po.storepo.InStorePO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.PublicMessage;
import util.ResultMessage;
import vo.storevo.InStoreVO;
import vo.storevo.StorePlaceVO;

public class InStoreBL implements InStoreBLService {
	private StoreDataService dataservice;
	private String user;
	private ArrayList<InStorePO> goodslist;
//	private DeliveryDataService goodsdata;
	
	public InStoreBL(){
		this.user = PublicMessage.staffID;
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
//		goodsdata = (DeliveryDataService) ClientRMIHelper.getServiceByName("DeliveryDataServiceImpl");
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
		for(int i=0;i<goodslist.size();i++){
			if(goodslist.get(i).getGoodsID().equals(id)){
				return new ResultMessage("inputedid", null);
			}
		}
		if(p.getArea()<0||p.getRow()<0||p.getShelf()<0||p.getPlace()<0){
			return new ResultMessage("wrongplace", null);
		}
		StorePlacePO place = new StorePlacePO(p.getArea(), p.getRow(), p.getShelf(), p.getPlace());
		try {
			ResultMessage result = dataservice.find(id);
			if(result.getKey().equals("noexist")){//货物不存在时，返回不存在
				return new ResultMessage("noexist", null);
			}
			else if(result.getKey().equals("exist")){//货物存在时，继续检查该位置
				GoodsPO goods = (GoodsPO) result.getValue();
				result = dataservice.getStore();
				if(result.getKey().equals("success")){
					StorePO store = (StorePO) result.getValue();
					
					if(p.getArea()>store.getArea()||p.getRow()>store.getRow()||p.getShelf()>store.getShelf()||p.getPlace()>store.getPlace()){
						return new ResultMessage("wrongplace", null);
					}
					
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
			else{
				return result;
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
//				ResultMessage result = dataservice.getStore();
//				//改写库存
//				if(result.getKey().equals("success")){
//					StorePO store = (StorePO) result.getValue();
//					
//					for(int i=0;i<goodslist.size();i++){//进行改写
//						InStorePO temp = goodslist.get(i);
//						StorePlacePO place = temp.getStorePlace();
//						place.setGoods(temp.getGoods());
//						store.setStorePlace(place);
//						
//						//更新货物的货运状态
//						goodslist.get(i).getGoods().addLocation(new Time().toString()
//	                            + " "
//	                            + PublicMessage.location
//	                            + " "
//	                            + InstitutionType
//	                                            .typeTpString(PublicMessage.institutionType)
//	                                            + " " + "已入库");
//						goodsdata.updateGoods(goodslist.get(i).getGoods());
//					}
//					//保存新的库存
//					result = dataservice.saveStore(store);
//					
//					if(!result.getKey().equals("success")){
//						return new ResultMessage("dataerror", new InStoreVO(goodslist));
//					}
//				}
				//提交入库单，等待审批
				InStoreBillPO bill = new InStoreBillPO(PublicMessage.staffID, goodslist);
				ResultMessage result = dataservice.saveInStore(bill);
				if(result.getKey().equals("success")){
					return new ResultMessage(result.getKey(), null);
				}
				else{
					return new ResultMessage(result.getKey(), new InStoreVO(goodslist));
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
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

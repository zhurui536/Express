package bussinesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.storeblservice.OutStoreBLService;
import connection.ClientRMIHelper;
import dataservice.billdataservice.BilldataService;
import dataservice.storedataservice.StoreDataService;
import po.logisticpo.TransferBillPO;
import po.storepo.OutStoreBillPO;
import po.storepo.OutStorePO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.BillType;
import util.PublicMessage;
import util.ResultMessage;
import util.Trans;
import vo.storevo.OutStoreVO;

public class OutStoreBL implements OutStoreBLService {
	
	private StoreDataService dataservice;
//	private DeliveryDataService goodsdata;
	private String user;
	private ArrayList<OutStorePO> goodslist;
	private BilldataService billdata;
	
	public OutStoreBL(){
		dataservice = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
		billdata = (BilldataService) ClientRMIHelper.getServiceByName("BillDataServiceImpl");
//		goodsdata = (DeliveryDataService) ClientRMIHelper.getServiceByName("DeliveryDataServiceImpl");
		this.user = PublicMessage.staffID;
	}
	
	@Override
	public ResultMessage newOutStore() {
		goodslist = new ArrayList<OutStorePO>();
		return new ResultMessage("success", new OutStoreVO(goodslist));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination, String billid) {
		//检查该货物的id是否已经输入
		for(int i=0;i<goodslist.size();i++){
			OutStorePO temp = goodslist.get(i);
			if(temp.getGoodsID().equals(id)){
				return new ResultMessage("inputedid", new OutStoreVO(goodslist));
			}
		}
		
		try {
			//检查中转单编号是否存在
			ResultMessage result = billdata.getBills(BillType.TRANSIT);
			if(result.getKey().equals("success")){
				
				ArrayList<TransferBillPO> bills = (ArrayList<TransferBillPO>) result.getValue();
				for(int i=0;i<bills.size();i++){
					
					if(bills.get(i).getBillID().equals(billid)){
						//检查该货物id是否在库存中
						result = dataservice.getStore();
						if(result.getKey().equals("success")){
							StorePO store = (StorePO) result.getValue();
							
							for(int a=0;a<store.getArea();a++){
								for(int r=0;r<store.getRow();r++){
									for(int s=0;s<store.getShelf();s++){
										for(int p=0;p<store.getPlace();p++){
											//找到对应的库存位置
											StorePlacePO temp = store.getStorePlace(a, r, s, p);
											if(temp.ifEmpty()){//该位置为空时直接跳过
												continue;
											}
											else if(temp.getGoods().getId().equals(id)){
												this.goodslist.add(new OutStorePO(temp.getGoods(), temp, Destination, this.user, trans, billid));
												return new ResultMessage("success", new OutStoreVO(goodslist));
											}
										}
									}
								}
							}
							
							return new ResultMessage("noexist", new OutStoreVO(goodslist));
						}
						else{
							return result;
						}
					}
				}
				//如果中转单不存在，返回错误信息
				return new ResultMessage("nobillid", new OutStoreVO(goodslist));
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
//				ResultMessage result = dataservice.getStore();
//				
//				if(result.getKey().equals("success")){
//					StorePO store = (StorePO) result.getValue();
//					
//					for(int i=0;i<goodslist.size();i++){//改写库存
//						OutStorePO temp = goodslist.get(i);
//						StorePlacePO place = temp.getStorePlace();
//						StorePlacePO newplace = new StorePlacePO(place.getArea(), place.getRow(), place.getShelf(), place.getPlace());
//						store.setStorePlace(newplace);
//
//						//更新货物的货运状态
//						goodslist.get(i).getGoods().addLocation(new Time().toString()
//	                            + " "
//	                            + PublicMessage.location
//	                            + " "
//	                            + InstitutionType
//	                                            .typeTpString(PublicMessage.institutionType)
//	                                            + " " + "已出库");
//						goodsdata.updateGoods(goodslist.get(i).getGoods());
//					}
//					
//					result = dataservice.saveStore(store);
//					
//					if(!result.getKey().equals("success")){
//						return new ResultMessage("dataerror", new OutStoreVO(goodslist));
//					}
//					
//				}
//				else{
//					return new ResultMessage("dataerror", new OutStoreVO(goodslist));
//				}
				OutStoreBillPO bill = new OutStoreBillPO(PublicMessage.staffID, goodslist);
				ResultMessage result = dataservice.saveOutStore(bill);
				if(result.getKey().equals("success")){
					return new ResultMessage(result.getKey(), null);
				}
				else{
					return new ResultMessage(result.getKey(), new OutStoreVO(goodslist));
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", new OutStoreVO(goodslist));
			}
		}
		else if(condition == 1){//1代表取消出库
			return new ResultMessage("success", new OutStoreVO(goodslist));
		}
		
		return new ResultMessage("unknown operation", new OutStoreVO(goodslist));

	}
}

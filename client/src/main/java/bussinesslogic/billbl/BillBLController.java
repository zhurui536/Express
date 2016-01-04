package bussinesslogic.billbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.billblservice.BillBLService;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.billdataservice.BilldataService;
import dataservice.logisticsdataservice.DeliveryDataService;
import dataservice.storedataservice.StoreDataService;
import po.BillPO;
import po.GoodsPO;
import po.financepo.PayBillPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.ReceiptBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import po.storepo.InStoreBillPO;
import po.storepo.InStorePO;
import po.storepo.OutStoreBillPO;
import po.storepo.OutStorePO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.BillState;
import util.BillType;
import util.InstitutionType;
import util.LogFactory;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;
import vo.BillVO;
import vo.SystemlogVO;
//处理单据审批
public class BillBLController implements BillBLService {
	private BilldataService dataservice;
	//编写系统日志
	private SystemlogMaintenanceBLService logservice;
	
	private final BillType[] types = {
			BillType.OUTSTORE, BillType.INSTORE, BillType.PAYMENT, BillType.RECEIPT, BillType.ARRIVAL, BillType.DELIVERY,
			BillType.LOADING, BillType.SEND, BillType.TRANSIT
	};
	ArrayList<BillPO> bills;
	ArrayList<BillVO> vos;
	
	public BillBLController(){
		dataservice = (BilldataService) ClientRMIHelper.getServiceByName("BillDataServiceImpl");
		logservice = LogFactory.getInstance();
		vos = new ArrayList<BillVO>();
		bills = new ArrayList<BillPO>();
	}
//获得所有未审批单据
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getBills() {
		vos = new ArrayList<BillVO>();
		bills = new ArrayList<BillPO>();
		this.logservice.addSystemlog(new SystemlogVO("查看所有未审批单据"));
		for(int i=0;i<types.length;i++){
			ResultMessage result;
			try {
				result = dataservice.getBills(types[i]);
				if(result.getKey().equals("success")){
					if(i==0){
						ArrayList<OutStoreBillPO> temp = (ArrayList<OutStoreBillPO>) result.getValue();
						OutStoreBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==1){
						ArrayList<InStoreBillPO> temp = (ArrayList<InStoreBillPO>) result.getValue();
						InStoreBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==2){
						ArrayList<PayBillPO> temp = (ArrayList<PayBillPO>) result.getValue();
						PayBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==3){
						ArrayList<ReceiptBillPO> temp = (ArrayList<ReceiptBillPO>) result.getValue();
						ReceiptBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==4){
						ArrayList<ArrivalBillPO> temp = (ArrayList<ArrivalBillPO>) result.getValue();
						ArrivalBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==5){
						ArrayList<DeliveryBillPO> temp = (ArrayList<DeliveryBillPO>) result.getValue();
						DeliveryBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==6){
						ArrayList<LoadingBillPO> temp = (ArrayList<LoadingBillPO>) result.getValue();
						LoadingBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==7){
						ArrayList<SendBillPO> temp = (ArrayList<SendBillPO>) result.getValue();
						SendBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
					if(i==8){
						ArrayList<TransferBillPO> temp = (ArrayList<TransferBillPO>) result.getValue();
						TransferBillPO bill = null;
						
						for(int j=0;j<temp.size();j++){
							bill = temp.get(j);
							if(bill.getState() != BillState.APPROVED){
								bills.add(bill);
							}
						}
					}
				}
				else{
					return new ResultMessage(result.getKey(), vos);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				
				return new ResultMessage("internet error", null);
			}
			
		}
		
		for(int j=0;j<bills.size();j++){
			vos.add(bills.get(j).toVO());
		}
		return new ResultMessage("success", vos);
	}
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getBills(BillType type){
		ResultMessage result;
		this.logservice.addSystemlog(new SystemlogVO("筛选某类单据"));
		try {
			ArrayList<BillVO> bills = new ArrayList<BillVO>();
			result = dataservice.getBills(type);
			if(result.getKey().equals("success")){
				if(type == BillType.INSTORE){
					ArrayList<InStoreBillPO> temp = (ArrayList<InStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.OUTSTORE){
					ArrayList<OutStoreBillPO> temp = (ArrayList<OutStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.PAYMENT){
					ArrayList<PayBillPO> temp = (ArrayList<PayBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.RECEIPT){
					ArrayList<ReceiptBillPO> temp = (ArrayList<ReceiptBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.ARRIVAL){
					ArrayList<ArrivalBillPO> temp = (ArrayList<ArrivalBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.DELIVERY){
					ArrayList<DeliveryBillPO> temp = (ArrayList<DeliveryBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.LOADING){
					ArrayList<LoadingBillPO> temp = (ArrayList<LoadingBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.SEND){
					ArrayList<SendBillPO> temp = (ArrayList<SendBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
				else if(type == BillType.TRANSIT){
					ArrayList<TransferBillPO> temp = (ArrayList<TransferBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getState() != BillState.APPROVED){
							bills.add(temp.get(i).toVO());
						}
					}
					return new ResultMessage("success", bills);
				}
			}
			else{
				return result;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		return new ResultMessage("unknownerror", null);
	}
//获得某个被选中的单据
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage chooseBill(String id, BillType type) {
		ResultMessage result;
		this.logservice.addSystemlog(new SystemlogVO("查看单据"));
		try {
			result = dataservice.getBills(type);
			if(result.getKey().equals("success")){
				if(type == BillType.INSTORE){
					ArrayList<InStoreBillPO> temp = (ArrayList<InStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.OUTSTORE){
					ArrayList<OutStoreBillPO> temp = (ArrayList<OutStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.PAYMENT){
					ArrayList<PayBillPO> temp = (ArrayList<PayBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.RECEIPT){
					ArrayList<ReceiptBillPO> temp = (ArrayList<ReceiptBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.ARRIVAL){
					ArrayList<ArrivalBillPO> temp = (ArrayList<ArrivalBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.DELIVERY){
					ArrayList<DeliveryBillPO> temp = (ArrayList<DeliveryBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.LOADING){
					ArrayList<LoadingBillPO> temp = (ArrayList<LoadingBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.SEND){
					ArrayList<SendBillPO> temp = (ArrayList<SendBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.TRANSIT){
					ArrayList<TransferBillPO> temp = (ArrayList<TransferBillPO>) result.getValue();

					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							return new ResultMessage("success", temp.get(i));
						}
					}
					
					return new ResultMessage("noexist", null);
				}
			}
			
			return new ResultMessage(result.getKey(), vos);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
//审批单个单据
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage approve(String id, BillType type) {
		ResultMessage result;
		this.logservice.addSystemlog(new SystemlogVO("审批单据"+id));
		try {
			result = dataservice.getBills(type);
			if(result.getKey().equals("success")){
				if(type == BillType.INSTORE){
					StoreDataService storedata = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
					DeliveryDataService goodsdata = (DeliveryDataService) ClientRMIHelper.getServiceByName("DeliveryDataServiceImpl");
					ArrayList<InStoreBillPO> temp = (ArrayList<InStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						//查找与单据编号相同的单据
						if(temp.get(i).getBillID().equals(id)){
							//找到之后更改单据的审批状态
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							
							//对库存和货物的货运状态进行改写
							result = storedata.getStore();
							//改写库存
							if(result.getKey().equals("success")){
								StorePO store = (StorePO) result.getValue();
								ArrayList<InStorePO> goodslist = temp.get(i).getPOS();
								
								for(int j=0;j<goodslist.size();j++){//进行改写
									InStorePO ins = goodslist.get(j);
									
									//更新货物的货运状态
									GoodsPO goods = goodsdata.findGoods(ins.getGoodsID());
									goods.addLocation(new Time().toString()
				                            + " "
				                            + PublicMessage.location
				                            + " "
				                            + InstitutionType
				                                            .typeTpString(PublicMessage.institutionType)
				                                            + " " + "已入库");
									goodsdata.updateGoods(goods);
									
									StorePlacePO place = ins.getStorePlace();
									place.setGoods(goods);
									store.setStorePlace(place);
								}
								//保存新的库存
								result = storedata.saveStore(store);
								
								if(!result.getKey().equals("success")){
									return new ResultMessage("dataerror", null);
								}
							}
							else{//如果读取库存失败，需要报错
								return new ResultMessage("dataerror", null);
							}
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.OUTSTORE){
					StoreDataService storedata = (StoreDataService) ClientRMIHelper.getServiceByName("StoreDataServiceImpl");
					DeliveryDataService goodsdata = (DeliveryDataService) ClientRMIHelper.getServiceByName("DeliveryDataServiceImpl");
					ArrayList<OutStoreBillPO> temp = (ArrayList<OutStoreBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						//读取所有单据，查找到需要审批通过的单据
						if(temp.get(i).getBillID().equals(id)){
							//更改单据的审批状态并保存
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							
							result = storedata.getStore();
							
							if(result.getKey().equals("success")){
								StorePO store = (StorePO) result.getValue();
								ArrayList<OutStorePO> goodslist = temp.get(i).getPOS();
								
								for(int j=0;j<goodslist.size();j++){//改写库存
									OutStorePO tem = goodslist.get(j);
									StorePlacePO place = tem.getStorePlace();
									StorePlacePO newplace = new StorePlacePO(place.getArea(), place.getRow(), place.getShelf(), place.getPlace());
									store.setStorePlace(newplace);

									//更新货物的货运状态
									GoodsPO goods = goodsdata.findGoods(tem.getGoodsID());
									goods.addLocation(new Time().toString()
				                            + " "
				                            + PublicMessage.location
				                            + " "
				                            + InstitutionType
				                                            .typeTpString(PublicMessage.institutionType)
				                                            + " " + "已出库");
									goodsdata.updateGoods(goods);
								}
								
								result = storedata.saveStore(store);
								
								if(!result.getKey().equals("success")){
									return new ResultMessage("dataerror", null);
								}
							}
						else{//读去库存失败时，需要报错
							return new ResultMessage("dataerror", null);
						}
							
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.PAYMENT){
					ArrayList<PayBillPO> temp = (ArrayList<PayBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.RECEIPT){
					ArrayList<ReceiptBillPO> temp = (ArrayList<ReceiptBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.ARRIVAL){
					ArrayList<ArrivalBillPO> temp = (ArrayList<ArrivalBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.DELIVERY){
					ArrayList<DeliveryBillPO> temp = (ArrayList<DeliveryBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.LOADING){
					ArrayList<LoadingBillPO> temp = (ArrayList<LoadingBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.SEND){
					ArrayList<SendBillPO> temp = (ArrayList<SendBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						System.out.println(temp.get(i).getBillID());
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
				else if(type == BillType.TRANSIT){
					ArrayList<TransferBillPO> temp = (ArrayList<TransferBillPO>) result.getValue();
					
					for(int i=0;i<temp.size();i++){
						if(temp.get(i).getBillID().equals(id)){
							temp.get(i).approve();
							dataservice.saveBills(temp, type);
							return new ResultMessage("success", null);
						}
					}
					
					return new ResultMessage("noexist", null);
				}
			}
			
			return new ResultMessage(result.getKey(), null);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
	
//批量审批
	@Override
	public ResultMessage approves() {
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<BillType> types = new ArrayList<BillType>();
		
		for(int i=0;i<bills.size();i++){
			BillPO bill = bills.get(i);
			ids.add(bill.getBillID());
			types.add(bill.getType());
		}
		ResultMessage result = null;
		
		for(int i=0;i<ids.size();i++){
			result = this.approve(ids.get(i), types.get(i));
			
			if(result.getKey().equals("success")){
				continue;
			}
			else if(result.getKey().equals("noexist")){
				continue;
			}
			else{
				return result;
			}
		}
		
		return new ResultMessage("success", null);
	}
//结束审批
	@Override
	public void end() {}

}

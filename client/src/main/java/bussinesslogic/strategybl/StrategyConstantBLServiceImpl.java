package bussinesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import connection.ClientRMIHelper;
import dataservice.strategydataservice.StrategyDataService;
import po.DistancePO;
import util.ResultMessage;
import vo.DistanceVO;

public class StrategyConstantBLServiceImpl implements StrategyConstantBLService {
	private StrategyDataService dataservice;
	
	public StrategyConstantBLServiceImpl(){
		dataservice = (StrategyDataService) ClientRMIHelper.getServiceByName("StrategyDataServiceImpl");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage inputDistanceInfo(DistanceVO vo) {
		DistancePO po = new DistancePO(vo.getCityA(), vo.getCityB(), vo.getDistance());
		try {//首先读取所有距离信息
			ResultMessage result = dataservice.getDistance();
			
			if(result.getKey().equals("success")){//读取成功
				ArrayList<DistancePO> distances = (ArrayList<DistancePO>) result.getValue();
				
				for(int i=0;i<distances.size();i++){//查看这个距离是否之前已经制定
					if(distances.get(i).ifMatch(vo.getCityA(), vo.getCityB())){
						//已经制定则将原来的删除，将新的加入
						distances.remove(i);
						distances.add(po);
						
						//对新距离信息进行保存
						result = dataservice.SaveDistance(distances);
						if(result.getKey().equals("success")){//保存成功
							ArrayList<DistanceVO> vos = new ArrayList<DistanceVO>();
							
							//将新的距离信息返回
							for(int j=0;j<distances.size();j++){
								vos.add(new DistanceVO(distances.get(j).getCityA(), distances.get(j).getCityB(), distances.get(j).getDistance()));
							}
							
							return new ResultMessage("success", vos);
						}
						else{
							return result;
						}
					}
				}
				
				//如果距离之前没有被制定，则直接加入
				distances.add(po);
				result = dataservice.SaveDistance(distances);
				if(result.getKey().equals("success")){
					ArrayList<DistanceVO> vos = new ArrayList<DistanceVO>();
					
					//将新的距离信息返回
					for(int j=0;j<distances.size();j++){
						vos.add(new DistanceVO(distances.get(j).getCityA(), distances.get(j).getCityB(), distances.get(j).getDistance()));
					}
					
					return new ResultMessage("success", vos);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		
		return new ResultMessage("error", null);
	}

	@Override
	public ResultMessage inputPriceInfo(double price) {
		try {
			ResultMessage result = dataservice.savePrice(price);
			if(result.getKey().equals("success")){
				return new ResultMessage("success", null);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		return new ResultMessage("error", null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getDistanceInfo() {
		try {
			ResultMessage result = dataservice.getDistance();
			
			if(result.getKey().equalsIgnoreCase("success")){
				ArrayList<DistancePO> distances = (ArrayList<DistancePO>) result.getValue();
				ArrayList<DistanceVO> vos = new ArrayList<DistanceVO>();
				
				for(int i=0;i<distances.size();i++){
					vos.add(new DistanceVO(distances.get(i).getCityA(), distances.get(i).getCityB(), distances.get(i).getDistance()));
				}
				
				return new ResultMessage("success", vos);
			}
			else{
				return result;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public ResultMessage getPrice() {
		try {
			ResultMessage result = dataservice.getPrice();
			
			if(result.getKey().equalsIgnoreCase("success")){
				double price = (double) result.getValue();
				
				return new ResultMessage("success", price);
			}
			else{
				return result;
			}
		}catch(Exception ex){
			return new ResultMessage("internet error", null);
		}
	}

}
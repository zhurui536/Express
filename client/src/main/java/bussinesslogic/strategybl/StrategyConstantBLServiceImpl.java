package bussinesslogic.strategybl;

import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import connection.ClientRMIHelper;
import dataservice.strategydataservice.StrategyDataService;
import po.DistancePO;
import util.ResultMessage;
import vo.DistanceVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class StrategyConstantBLServiceImpl implements StrategyConstantBLService {
	private StrategyDataService dataservice;
	
	public StrategyConstantBLServiceImpl(){
		ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
		dataservice = (StrategyDataService) clientRMIHelper.getServiceByName("StrategyDataServiceImpl");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage inputDistanceInfo(DistanceVO vo) {
		DistancePO po = new DistancePO(vo.getCityA(), vo.getCityB(), vo.getDistance());
		try {
			ResultMessage result = dataservice.getDistance();
			
			if(result.getKey().equals("success")){
				ArrayList<DistancePO> distances = (ArrayList<DistancePO>) result.getValue();
				
				for(int i=0;i<distances.size();i++){
					if(distances.get(i).ifMatch(vo.getCityA(), vo.getCityB())){
						distances.remove(i);
						distances.add(po);
						
						result = dataservice.SaveDistance(distances);
						if(result.getKey().equals("success")){
							return new ResultMessage("success", null);
						}
						else{
							return result;
						}
					}
				}
				
				distances.add(po);
				result = dataservice.SaveDistance(distances);
				if(result.getKey().equals("success")){
					return new ResultMessage("success", null);
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
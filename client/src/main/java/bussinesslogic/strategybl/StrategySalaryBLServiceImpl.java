package bussinesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import connection.ClientRMIHelper;
import dataservice.strategydataservice.StrategyDataService;
import po.StaffMessagePO;
import util.ResultMessage;
import vo.StaffMessageVO;

public class StrategySalaryBLServiceImpl implements StrategySalaryBLService {
	private StrategyDataService dataservice;
	private ArrayList<StaffMessagePO> pos;
	
	public StrategySalaryBLServiceImpl(){
		dataservice = (StrategyDataService) ClientRMIHelper.getServiceByName("StrategyDataServiceImpl");
		pos = new ArrayList<StaffMessagePO>();
	}

	@Override
	public ResultMessage inputSalaryInfo(StaffMessageVO vo) {
		for(int i=0;i<pos.size();i++){
			if(vo.id.equals(pos.get(i).getId())){
				return new ResultMessage("existedstaff", null);
			}
		}
		
		StaffMessagePO po = new StaffMessagePO(vo);
		
		pos.add(po);
		
		return new ResultMessage("success", this.getVO());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getSalary() {
		try {
			ResultMessage result = dataservice.getSalary();
			
			if(result.getKey().equals("success")){
				pos = (ArrayList<StaffMessagePO>) result.getValue();
				
				return new ResultMessage("success", this.getVO());
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
	public ResultMessage endSalary(int condition) {
		if(condition == 0){
			try {
				ResultMessage result = dataservice.saveSalary(pos);
				if(result.getKey().equals("success")){
					return new ResultMessage("success", null);
				}
				else{
					return result;
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
	
	private ArrayList<StaffMessageVO> getVO(){
		ArrayList<StaffMessageVO> vos = new ArrayList<StaffMessageVO>();
		
		for(int i=0;i<pos.size();i++){
			vos.add(new StaffMessageVO(pos.get(i)));
		}
		
		return vos;
	}

	@Override
	public ResultMessage modifySalary(StaffMessageVO vo) {
		for(int i=0;i<pos.size();i++){
			if(vo.id.equals(pos.get(i).getId())){
				pos.remove(i);
				pos.add(new StaffMessagePO(vo));
				return new ResultMessage("success", this.getVO());
			}
		}
		
		return new ResultMessage("nostaff", this.getVO());
	}
}

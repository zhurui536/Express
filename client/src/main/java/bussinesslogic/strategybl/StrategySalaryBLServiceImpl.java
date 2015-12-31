package bussinesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import connection.ClientRMIHelper;
import dataservice.strategydataservice.StrategyDataService;
import po.StaffMessagePO;
import util.LogFactory;
import util.ResultMessage;
import vo.StaffMessageVO;
import vo.SystemlogVO;

public class StrategySalaryBLServiceImpl implements StrategySalaryBLService {
	private StrategyDataService dataservice;
	//编写系统日志
	private SystemlogMaintenanceBLService logservice;
	
	private ArrayList<StaffMessagePO> pos;
	
	public StrategySalaryBLServiceImpl(){
		dataservice = (StrategyDataService) ClientRMIHelper.getServiceByName("StrategyDataServiceImpl");
		pos = new ArrayList<StaffMessagePO>();
		logservice = LogFactory.getInstance();
	}

//	@Override
//	public ResultMessage inputSalaryInfo(StaffMessageVO vo) {
//		for(int i=0;i<pos.size();i++){
//			if(vo.id.equals(pos.get(i).getId())){
//				return new ResultMessage("existedstaff", null);
//			}
//		}
//		
//		StaffMessagePO po = new StaffMessagePO(vo);
//		
//		pos.add(po);
//		
//		return new ResultMessage("success", this.getVO());
//		
//	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getSalary() {
		try {
			ResultMessage result = dataservice.getSalary();
			
			this.logservice.addSystemlog(new SystemlogVO("读取员工薪水"));
			
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
					this.logservice.addSystemlog(new SystemlogVO("保存员工薪水"));
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
				this.logservice.addSystemlog(new SystemlogVO("修改员工薪水"));
				return new ResultMessage("success", this.getVO());
			}
		}
		
		return new ResultMessage("nostaff", this.getVO());
	}
}

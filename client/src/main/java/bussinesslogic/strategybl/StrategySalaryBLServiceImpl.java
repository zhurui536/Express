package bussinesslogic.strategybl;

import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import connection.ClientRMIHelper;
import dataservice.strategydataservice.StrategyDataService;
import po.SalaryPO;
import util.ResultMessage;
import vo.SalaryVO;

import java.rmi.RemoteException;

public class StrategySalaryBLServiceImpl implements StrategySalaryBLService {
	private StrategyDataService dataservice;
	public StrategySalaryBLServiceImpl(){
		dataservice = (StrategyDataService) ClientRMIHelper.getServiceByName("StrategyDataServiceImpl");
	}

	@Override
	public void newSalary() {

	}

	@Override
	public void endSalary() {

	}

	@Override
	public ResultMessage inputSalaryInfo(SalaryVO vo) {
		SalaryPO po = new SalaryPO(vo.getId(), vo.getJob(), vo.getSalary(), vo.getType());
		try {
			ResultMessage result = dataservice.update(po);
			if(result.getKey().equals("success")){
				return new ResultMessage("success", null);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
		return new ResultMessage("error", null);
	}

}

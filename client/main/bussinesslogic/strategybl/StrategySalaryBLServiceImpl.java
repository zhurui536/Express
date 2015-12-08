package main.bussinesslogic.strategybl;

import java.rmi.RemoteException;

import po.SalaryPO;
import dataservice.strategydataservice.StrategyDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import main.connection.ClientRMIHelper;
import main.vo.SalaryVO;

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

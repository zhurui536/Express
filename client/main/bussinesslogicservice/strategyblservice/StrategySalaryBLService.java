package main.bussinesslogicservice.strategyblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.SalaryVO;

/*
 * Created By Wippy
 * 2015/10/26
 */

public interface StrategySalaryBLService {
	public void newSalary();
	
	public ResultMessage inputSalaryInfo(SalaryVO vo);
	
	public void endSalary();
}

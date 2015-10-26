package main.bussinesslogicservice.strategyblservice;

import main.bussinesslogic.util.ResultMessage;

/*
 * Created By Wippy
 * 2015/10/26
 */

public interface StrategySalaryBLService {
	public void newSalary();
	
	public ResultMessage inputSalaryInfo(long id, String Post,int salary);
	
	public void endSalary();
}

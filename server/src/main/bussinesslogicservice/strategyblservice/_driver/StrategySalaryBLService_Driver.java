package main.bussinesslogicservice.strategyblservice._driver;

import main.bussinesslogic.util.ResultMessage;

import main.bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import main.bussinesslogicservice.strategyblservice._stub.StrategySalaryBLService_Stub;


/*
 * Created By Wippy
 * 2015/10/26
 */


public class StrategySalaryBLService_Driver {

	private static final String Manager = null;

	public static void main(String[] args){
		StrategySalaryBLService ssbls = new StrategySalaryBLService_Stub();
		
		drive(ssbls);
	}

	private static void drive(StrategySalaryBLService ssbls) {
		// TODO Auto-generated method stub
		
		ResultMessage result = null;
		
		ssbls.newSalary();
		
		result = ssbls.inputSalaryInfo(1111111111,Manager,10000);
		
		System.out.println(result.getKey());
		
		ssbls.endSalary();
	}
}

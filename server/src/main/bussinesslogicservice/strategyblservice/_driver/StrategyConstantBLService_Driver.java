package main.bussinesslogicservice.strategyblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import main.bussinesslogicservice.strategyblservice._stub.StrategyConstantBLService_Stub;



/*
 * Created By Wippy
 * 2015/10/26
 */


public class StrategyConstantBLService_Driver {
	public static void main(String[] args){
		
		StrategyConstantBLService scbls = new StrategyConstantBLService_Stub();
		
		drive(scbls);
	}

	private static void drive(StrategyConstantBLService scbls) {
		// TODO Auto-generated method stub
		ResultMessage result = null;
		
		scbls.newConstant();
		
		result = scbls.inputConstantInfo(10000,100);
		
		System.out.println(result.getKey());
		
		scbls.endConstant();
	}
}

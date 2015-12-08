package main.bussinesslogicservice.strategyblservice._driver;

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
	}
}

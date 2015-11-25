package main.bussinesslogicservice.strategyblservice;

import main.bussinesslogic.util.ResultMessage;

/*
 * Created By Wippy
 * 2015/10/26
 */

public interface StrategyConstantBLService {
	public void newConstant();
	
	public void selectCity();
	
	public ResultMessage inputConstantInfo(int distance,int price);
	
	public void endConstant();
}

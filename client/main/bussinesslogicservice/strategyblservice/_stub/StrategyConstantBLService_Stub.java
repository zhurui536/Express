package main.bussinesslogicservice.strategyblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import main.vo.DistanceVO;


/*
 * Created By Wippy
 * 2015/10/26
 */


public class StrategyConstantBLService_Stub implements StrategyConstantBLService{
	public void newConstant(){
		System.out.println("Ready to draft freight strategy!");
	}
	
	public void selectCity(){
		System.out.println("Choose the two cities!");
	}
	
	public ResultMessage inputConstantInfo(int distance,int price){
		if(price > 0){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("overflow", null);
		}
		
	}
	
	public void endConstant(){
		System.out.println("The freight strategy was drafted!");
	}

	@Override
	public ResultMessage inputDistanceInfo(DistanceVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage inputPriceInfo(double price) {
		// TODO Auto-generated method stub
		return null;
	}
}

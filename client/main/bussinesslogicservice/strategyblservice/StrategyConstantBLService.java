package main.bussinesslogicservice.strategyblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.DistanceVO;

/*
 * Created By Wippy
 * 2015/10/26
 */

public interface StrategyConstantBLService {
	
	public ResultMessage inputDistanceInfo(DistanceVO vo);
	
	public ResultMessage inputPriceInfo(double price);
}

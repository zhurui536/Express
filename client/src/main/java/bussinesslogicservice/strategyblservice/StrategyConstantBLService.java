package bussinesslogicservice.strategyblservice;

/*
 * Created By Wippy
 * 2015/10/26
 */

import util.ResultMessage;
import vo.DistanceVO;

public interface StrategyConstantBLService {
	
	public ResultMessage inputDistanceInfo(DistanceVO vo);
	
	public ResultMessage inputPriceInfo(double price);
	
	public ResultMessage getDistanceInfo();
	
	public ResultMessage getPrice();
}

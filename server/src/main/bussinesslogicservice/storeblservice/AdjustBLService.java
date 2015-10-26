package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.po.StorePlacePO;

public interface AdjustBLService {
	public void newAdjust();
	
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end);
	
	public void endAdjust(int condition);
}

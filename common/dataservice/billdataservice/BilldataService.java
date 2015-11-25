package dataservice.billdataservice;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import po.BillPO;

/**
 *Created by ZHR
 *2015年10月26日
 */

public interface BilldataService {
	public BillPO find(String id);
	
	public ResultMessage approve(String id);
	
	public ArrayList<BillPO> getBills();
	
	public ResultMessage approves(ArrayList<String> ids);
	
	

}

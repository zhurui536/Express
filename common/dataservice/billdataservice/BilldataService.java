package dataservice.billdataservice;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;

/**
 *Created by ZHR
 *2015年10月26日
 */

public interface BillDataService {
	public ResultMessage find(String id);
	
	public ResultMessage approve(String id);
	
	public ResultMessage getBills();
	
	public ResultMessage approves(ArrayList<String> ids);
	
	

}

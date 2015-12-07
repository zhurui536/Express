package dataservice.billdataservice;

import java.util.ArrayList;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;

/**
 *Created by ZHR
 *2015年10月26日
 */

public interface BilldataService {
	/*根据单据号和单据类型获得具体单据信息
	 * 
	 * 返回查找结果和对应的BillPO
	 */
	public ResultMessage find(String id, BillType type);
	
	/*根据单据号和单据类型审批单个单据
	 * 
	 * 返回审批结果和ArrayList<BillPO>
	 */
	public ResultMessage approve(String id, BillType type);
	
	/*获得剩余单据列表
	 * 
	 * 返回查找结果和ArrayList<BillPO>
	 */
	public ResultMessage getBills();
	
	/*对多个单据进行批量审批
	 * 
	 * 返回审批结果
	 */
	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> types);
	
	

}

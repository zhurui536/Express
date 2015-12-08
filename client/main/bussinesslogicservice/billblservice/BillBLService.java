package main.bussinesslogicservice.billblservice;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;

/**
 * Created By ZHR
 * 2015/10/26
 */

public interface BillBLService {
	/*获得所有未审批单据
	 * 无
	 * ResultMessage
	 */
	public ResultMessage getBills();
	
	/*返回选中单据的详细信息
	 * id
	 * BillVO
	 */
	public ResultMessage chooseBill(String id, BillType type);
	
	/*审批单个单据
	 * id
	 * ResultMessage
	 */
	public ResultMessage approve(String id, BillType type);
	
	/*批量审批单据
	 * ids
	 * ResultMessage
	 */
	public ResultMessage approves();
	
	/*结束审批
	 * 无
	 * 无
	 */
	public void end();
}

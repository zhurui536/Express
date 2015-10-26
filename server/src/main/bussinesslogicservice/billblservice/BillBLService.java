package main.bussinesslogicservice.billblservice;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.vo.BillVO;

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
	public BillVO chooseBill(String id);
	
	/*返回单据列表时调用的方法
	 * 无
	 * ArrayList<BillVO>
	 */
	public ArrayList<BillVO> back();
	
	/*审批单个单据
	 * id
	 * ResultMessage
	 */
	public ResultMessage approve(String id);
	
	/*批量审批单据
	 * ids
	 * ResultMessage
	 */
	public ResultMessage approves(ArrayList<String> ids);
	
	/*结束审批
	 * 无
	 * 无
	 */
	public void end();
}

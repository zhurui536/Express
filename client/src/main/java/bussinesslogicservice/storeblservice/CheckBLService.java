package bussinesslogicservice.storeblservice;

import java.util.Calendar;

import util.ResultMessage;


public interface CheckBLService {
	/*新建库存查看任务
	 * 无
	 * 无
	 */
	public ResultMessage newCheck();
	
		
	//获得整个库存的情况
	public ResultMessage checkStore();
	
	//查看入库单的审批状态
	public ResultMessage checkInStore();
	
	//查看出库单的审批状态
	public ResultMessage checkOutStore();
	
	/*查看时间段内的出入库记录
	 * start end
	 * ResultMessage
	 */
	public ResultMessage check(Calendar start, Calendar end);
	
	/*结束查看
	 * 
	 * 
	 */
	public void endCheck();
}

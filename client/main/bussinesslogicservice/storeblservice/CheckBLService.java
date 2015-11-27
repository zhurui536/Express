package main.bussinesslogicservice.storeblservice;

import java.util.Calendar;

import main.bussinesslogic.util.ResultMessage;

public interface CheckBLService {
	/*新建库存查看任务
	 * 无
	 * 无
	 */
	public void newCheck();
	
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

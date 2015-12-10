package bussinesslogicservice.storeblservice;

import util.ResultMessage;

import java.util.Calendar;


public interface CheckBLService {
	/*新建库存查看任务
	 * 无
	 * 无
	 */
	public ResultMessage newCheck();
	
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
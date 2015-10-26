package main.bussinesslogicservice.storeblservice;

import java.sql.Time;

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
	public ResultMessage check(Time start, Time end);
}

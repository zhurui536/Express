package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.po.storepo.StorePlacePO;

public interface AdjustBLService {
	/*新建新的调整任务
	 * 无
	 * 无
	 */
	public void newAdjust();
	
	/*增加调整项
	 * start end
	 * ResultMessage
	 */
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end);
	
	/*结束调整
	 * condition
	 * 无
	 */
	public void endAdjust(int condition);
}

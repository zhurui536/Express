package bussinesslogicservice.storeblservice;


import util.ResultMessage;
import vo.storevo.StorePlaceVO;

public interface AdjustBLService {
	/*新建新的调整任务
	 * 无
	 * ResultMessage
	 */
	public ResultMessage newAdjust();
	
	/*增加调整项
	 * start end
	 * ResultMessage
	 */
	public ResultMessage addAdjust(StorePlaceVO start, StorePlaceVO end);
	/*删除第i项调整项
	 * i
	 * ResultMessage
	 */
	public ResultMessage delAdjust(int i);
	/*结束调整
	 * condition
	 * 无
	 */
	public ResultMessage endAdjust(int condition);
}

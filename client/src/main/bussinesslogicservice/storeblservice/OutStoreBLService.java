package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;

public interface OutStoreBLService {
	/*新建出库任务
	 * 无
	 * 无
	 */
	public void newOutStore();
	
	/*增加出库货物
	 * id trans Destination
	 * ResultMessage
	 */
	public ResultMessage addOutStoreGoods(long id, Trans trans, String Destination);
	
	/*删除出库货物
	 * id
	 * ResultMessage
	 */
	public ResultMessage delOutStoreGoods(long id);
	
	/*结束出库任务
	 * condition
	 * 无
	 */
	public void endOutStore(int condition);
}

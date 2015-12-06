package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;

public interface OutStoreBLService {
	/*新建出库任务
	 * 无
	 * ResultMessage
	 */
	public ResultMessage newOutStore();
	
	/*增加出库货物
	 * id trans Destination
	 * ResultMessage
	 */
	public ResultMessage addOutStoreGoods(String id, Trans trans, String Destination);
	
	/*删除出库货物
	 * id
	 * ResultMessage
	 */
	public ResultMessage delOutStoreGoods(String id);
	
	/*结束出库任务
	 * condition
	 * 返回结束的结果
	 */
	public ResultMessage endOutStore(int condition);
}
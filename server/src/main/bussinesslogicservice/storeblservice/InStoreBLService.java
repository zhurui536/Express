package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.po.StorePlacePO;

/**
 * Created by ZHR
 * 2015/10/26
 */
public interface InStoreBLService {

	/*新建入库任务
	 * 无
	 * 无
	 */
	public void newInStore();
	
	/*增加入库货物
	 * id place destination
	 * ResultMessage
	 */
	public ResultMessage addInStoreGoods(long id, StorePlacePO place, String destination);
	
	/*删除之前输入的货物
	 * id
	 * ResultMessage
	 */
	public ResultMessage delInStoreGoods(long id);
	
	/*结束入库任务
	 * condition
	 * 无
	 */
	public void endIntStore(int condition);
}

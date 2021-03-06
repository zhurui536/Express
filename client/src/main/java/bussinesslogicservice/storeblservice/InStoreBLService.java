package bussinesslogicservice.storeblservice;

import util.ResultMessage;
import vo.storevo.StorePlaceVO;

/**
 * Created by ZHR
 * 2015/10/26
 */
public interface InStoreBLService {

	/*新建入库任务
	 * 无
	 * ResultMessage
	 */
	public ResultMessage newInStore();
	
	/*增加入库货物
	 * id place destination
	 * ResultMessage
	 */
	public ResultMessage addInStoreGoods(String id, StorePlaceVO place, String destination);
	/*删除之前输入的货物
	 * id
	 * ResultMessage
	 */
	public ResultMessage delInStoreGoods(String id);
	
	/*结束入库任务
	 * condition
	 * 无
	 */
	public ResultMessage endInStore(int condition);
}

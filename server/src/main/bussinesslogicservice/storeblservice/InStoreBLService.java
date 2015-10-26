package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.po.StorePlacePO;

/**
 * Created by ZHR
 * 2015/10/26
 */
public interface InStoreBLService {

	public void newInStore();
	
	public ResultMessage addInStoreGoods(long id, StorePlacePO place, String destination);
	
	public ResultMessage delInStoreGoods(long id);
	
	public void endIntStore(int condition);
}

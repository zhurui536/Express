package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.po.Trans;

public interface OutStoreBLService {
	
	public void newOutStore();
	
	public ResultMessage addOutStoreGoods(long id, Trans trans, String Destination);
	
	public ResultMessage delOutStoreGoods(long id);
	
	public void endOutStore(int condition);
}

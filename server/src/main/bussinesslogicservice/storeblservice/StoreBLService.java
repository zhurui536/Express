package main.bussinesslogicservice.storeblservice;

import java.sql.Time;

import main.bussinesslogic.util.ResultMessage;
import main.po.StorePlace;
import main.po.Trans;
import main.vo.IORecordVO;

/**
 * Created by ZHR
 * 2015/10/26
 */
public interface StoreBLService {

	//出库部分所用接口方法
	public void newInStore();
	
	public ResultMessage addInStoreGoods(long id, StorePlace place, String destination);
	
	public ResultMessage delInStoreGoods(long id);
	
	public void endIntStore(int condition);
	
	//入库部分所用接口方法
	public void newOutStore();
	
	public ResultMessage addOutStoreGoods(long id, Trans trans, String Destination);
	
	public ResultMessage delOutStoreGoods(long id);
	
	public void endOutStore(int condition);
	
	//库存盘点所用接口方法
	public ResultMessage verification();
	
	public void endVerification(int condition);
	
	//库存查看所用接口方法
	public void newCheck();
	
	public IORecordVO[] check(Time start, Time end);
	
	//库存调整所用接口方法
	public void newAdjust();
	
	public ResultMessage addAdjust(StorePlace start, StorePlace end);
	
	public void endAdjust(int condition);
}

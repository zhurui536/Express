package dataservice.storedataservice;

import po.storepo.*;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *Created by ZHR
 *2015年10月26日
 */

public interface StoreDataService extends Remote {
	/*根据货物id查找货物是否存在
	 * id
	 * 返回查找结果和GoodsPO，不存在的返回结果和null
	 * 查找结果：exist  noexist
	 */
	public ResultMessage find(String id) throws RemoteException;
	
	/*根据时间段查询货物出入库记录
	 * start end
	 * 返回查找结果和IORecordPO
	 * 查找结果：success  dataerror
	 */
	public ResultMessage finds(Calendar start, Calendar end) throws RemoteException;
	
	/*存储入库记录
	 * po
	 * 返回存储结果和null
	 * 存储结果：success  dataerror
	 */
	public ResultMessage saveInStore(ArrayList<InStorePO> po) throws RemoteException;
	
	/*保存出库记录
	 * po
	 * 返回存储结果和null
	 * 存储结果：success  dataerror
	 */
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po) throws RemoteException;
	
	/*获得货物的批号
	 * 无
	 * 返回查找结果和int型的批号
	 * success dataerror
	 */
	public ResultMessage getPihao() throws RemoteException;
	
	/*保存库存盘点记录
	 * po
	 * 返回存储结果和null
	 * 存储结果：success  dataerror
	 */
	public ResultMessage saveVerification(VerificationPO po) throws RemoteException;
	
	/*保存库存调整记录，并根据记录更新库存
	 * po
	 * 返回存储结果和null
	 * 存储结果：success  dataerror
	 */
	public ResultMessage saveAdjust(ArrayList<AdjustPO> po) throws RemoteException;
	
	/*获得当前库存情况
	 * 
	 * 返回结果以及StorePO
	 * 结果：success  dataerror
	 */
	public ResultMessage getStore()  throws RemoteException;
	
	/*保存新的库存对象
	 * 
	 * 返回存储结果
	 * 结果：success  dataerror
	 */
	public ResultMessage saveStore(StorePO store)  throws RemoteException;
}

package dataservice.storedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import main.bussinesslogic.util.ResultMessage;
import po.storepo.AdjustPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;


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
	
	/*根据位置查看库存上的货物情况
	 * place
	 * 返回查找结果和StorePlacePO，越界或者读写出错返回结果和null
	 * 查找结果：success  wrongplace  dataerror
	 */
	public ResultMessage find(StorePlacePO place) throws RemoteException;
	
	/*根据货物删除库存中的该货物
	 * po
	 * 返回删除结果和null
	 * 删除结果：success  noexist  dataerror
	 */
//	public ResultMessage delete(GoodsPO po) throws RemoteException;
	
	/*将该位置的货物更新为该货物
	 * place po
	 * 返回更新的结果和null
	 * 更新结果：wrongplace  success  dataerror
	 */
//	public ResultMessage update(StorePlacePO place, GoodsPO po) throws RemoteException;
	
	/*存储入库记录
	 * po
	 * 返回存储结果和null
	 * 存储结果：success  dataerror
	 */
	public ResultMessage saveInStore(ArrayList<InStorePO>  po) throws RemoteException;
	
	/*保存出库记录
	 * po
	 * 返回存储结果和null
	 * 存储结果：success  dataerror
	 */
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po) throws RemoteException;
	
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
	
	/*查看拥有该id的货物是否存在于库存中
	 * 
	 * 返回查找结果和StorePlacePO，不存在时返回null
	 * 查找结果：exist  noexist  dataerror
	 */
	public ResultMessage ifInStore(String id)  throws RemoteException;
}

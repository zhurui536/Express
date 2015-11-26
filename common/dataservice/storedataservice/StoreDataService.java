package dataservice.storedataservice;

import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import po.GoodsPO;
import po.storepo.AdjustPO;
import po.storepo.InStorePO;
import po.storepo.OutStorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;


/**
 *Created by ZHR
 *2015年10月26日
 */

public interface StoreDataService {
	/*根据货物id查找货物是否存在
	 * id
	 * 返回查找结果和货物的PO
	 */
	public ResultMessage find(String id) throws RemoteException;
	
	/*根据时间段查询货物出入库记录
	 * start end
	 * 返回查找结果和货物出入库记录的列表
	 */
	public ResultMessage finds(Time start, Time end) throws RemoteException;
	
	/*根据位置查看库存上的货物情况
	 * place
	 * 返回查找结果和该位置上的货物
	 */
	public ResultMessage find(StorePlacePO place) throws RemoteException;
	
	/*根据货物删除库存中的该货物
	 * po
	 * 返回删除结果
	 */
	public ResultMessage delete(GoodsPO po) throws RemoteException;
	
	/*将该位置的货物更新为该货物
	 * place po
	 * 返回更新的结果
	 */
	public ResultMessage update(StorePlacePO place, GoodsPO po) throws RemoteException;
	
	/*存储入库记录
	 * po
	 * 返回存储结果
	 */
	public ResultMessage saveInStore(ArrayList<InStorePO>  po) throws RemoteException;
	
	/*保存出库记录
	 * po
	 * 返回存储结果
	 */
	public ResultMessage saveOutStore(ArrayList<OutStorePO> po) throws RemoteException;
	
	/*保存库存盘点记录
	 * po
	 * 返回存储结果
	 */
	public ResultMessage saveVerification(VerificationPO po) throws RemoteException;
	
	/*保存库存调整记录
	 * po
	 * 返回存储结果
	 */
	public ResultMessage saveAdjust(AdjustPO po) throws RemoteException;
	
	/*根据id获得货物的所有信息
	 * id
	 * 返回查找结果以及货物的信息包
	 */
	public ResultMessage getGoods(String id) throws RemoteException;
}

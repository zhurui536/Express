package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BillPO;
import util.BillType;
import util.ResultMessage;

/**
 *Created by ZHR
 *2015年10月26日
 */

public interface BilldataService extends Remote{
	
	/*获得某种类型的单据的所有单据
	 * 无
	 * ResultMessage
	 */
	public ResultMessage getBills(BillType type) throws RemoteException;
	
	/*保存某种类型的单据
	 * ArrayList<BillPO>
	 * ResultMessage
	 */
	public ResultMessage saveBills(ArrayList<? extends BillPO> bills, BillType type) throws RemoteException;

}

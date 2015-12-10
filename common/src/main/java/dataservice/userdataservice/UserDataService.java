package dataservice.userdataservice;

import util.ResultMessage;

import java.rmi.RemoteException;
/*
 * Created By ZHR
 * 2015/10/26
 */
public interface UserDataService {
	/*查找id并比对密码，返回结果
	 * id password
	 * ResultMessage
	 */
	public ResultMessage find(long id, String password) throws RemoteException;
}

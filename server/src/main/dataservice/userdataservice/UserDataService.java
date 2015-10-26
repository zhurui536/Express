package main.dataservice.userdataservice;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;
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

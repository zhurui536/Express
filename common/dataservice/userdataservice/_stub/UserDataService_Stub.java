package dataservice.userdataservice._stub;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;
import main.bussinesslogic.util.ResultMessage;

public class UserDataService_Stub implements UserDataService {

	@Override
	public ResultMessage find(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=1000000000&&id<=Long.MAX_VALUE){
			long passwords = Long.parseLong(password);
			if(passwords-id == 1){
				return new ResultMessage("correct", null);
			}
			else{
				return new ResultMessage("wrongpassword", null);
			}
		}
		else{
			return new ResultMessage("noid", null);
		}
	}

}

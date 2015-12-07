package dataservice.strategydataservice._stub;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;
import dataservice.strategydataservice.StrategyDataService;
import po.StaffMessagePO;


/**
 * Created by Wippy
 * 2015/10/26
 */

public class StrategyDataService_Stub implements StrategyDataService {

    @Override
    public ResultMessage find(long id) throws RemoteException{
    	if(id>=1000000000&&id<=Long.MAX_VALUE){
    		
			return new ResultMessage("find success", null);
		}
		else{
			return new ResultMessage("cannot find", null);
		}

    }

    @Override
    public ResultMessage finds(String Post) throws RemoteException{
		return null;
    }

    @Override
    public void update(StaffMessagePO po) throws RemoteException{
    	System.out.println("update success!");
    }
    
    @Override
    public void delete(StaffMessagePO po) throws RemoteException{
    	System.out.println("delete success!");
    }
    
    @Override
    public void init() throws RemoteException {
    	System.out.println("init success!");
    }

    @Override
    public void finish() throws RemoteException {
    	System.out.println("finish success!");
    }
}

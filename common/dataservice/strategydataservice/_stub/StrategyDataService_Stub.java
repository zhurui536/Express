package dataservice.strategydataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import dataservice.strategydataservice.StrategyDataService;
import po.DistancePO;
import po.SalaryPO;


/**
 * Created by Wippy
 * 2015/10/26
 */

public class StrategyDataService_Stub implements StrategyDataService {

	@Override
	public ResultMessage getDistance() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage SaveDistance(ArrayList<DistancePO> pos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage savePrice(double price) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}

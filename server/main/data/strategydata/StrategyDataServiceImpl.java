package main.data.strategydata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import po.DistancePO;
import po.SalaryPO;
import dataservice.strategydataservice.StrategyDataService;

public class StrategyDataServiceImpl extends UnicastRemoteObject implements StrategyDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6454372370974129187L;

	public StrategyDataServiceImpl() throws RemoteException {
		super();
	}

	private final String price = "server/save/strategydata/price.dat";
	private final String distances = "server/save/strategydata/distancepo.dat";
	private final String salary = "server/save/strategydata/salarypo.dat";

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getDistance() throws RemoteException {
		try {
			ArrayList<DistancePO> pos = (ArrayList<DistancePO>) this.readList(distances);
			
			return new ResultMessage("success", pos);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage SaveDistance(ArrayList<DistancePO> pos)
			throws RemoteException {
		try {
			this.writeList(distances, pos);
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage savePrice(double price) throws RemoteException {
		try {
			this.writeList(this.price, price);
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}
	
	
	private Object readList(String path) throws Exception{
		Object list;
		
		FileInputStream in = new FileInputStream(path);
		ObjectInputStream objin = new ObjectInputStream(in);
		list = objin.readObject();
		objin.close();
			
		return list;
	}
	
	
	private void writeList(String path, Object list) throws Exception{
		//灏嗘柊鐨勫簱瀛樺啓鍏ユ枃浠�
		FileOutputStream out = new FileOutputStream(path);
		ObjectOutputStream objout = new ObjectOutputStream(out);
		objout.writeObject(list);
		objout.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage update(SalaryPO po) throws RemoteException {
		try {
			ArrayList<SalaryPO> pos = (ArrayList<SalaryPO>) this.readList(this.salary);
			
			for(int i=0;i<pos.size();i++){
				if(po.getId().equals(pos.get(i).getId())){
					pos.remove(i);
					pos.add(po);
					return new ResultMessage("success", null);
				}
			}
			
			pos.add(po);
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

}

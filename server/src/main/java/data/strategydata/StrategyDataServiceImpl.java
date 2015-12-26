package data.strategydata;

//github.com/awayz/Express.git
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.strategydataservice.StrategyDataService;
import po.DistancePO;
import po.SalaryPO;
import po.StaffMessagePO;
import util.ResultMessage;

public class StrategyDataServiceImpl extends UnicastRemoteObject implements StrategyDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6454372370974129187L;

	@SuppressWarnings("resource")
	public StrategyDataServiceImpl() throws RemoteException {
		super();
		try {
			FileInputStream in = new FileInputStream(price);
			if(in.available() == 0){
				double price = 23;
				this.writeList(this.price, price);
			}

			in = new FileInputStream(distances);
			if(in.available() == 0){
				ArrayList<DistancePO> list = new ArrayList<DistancePO>();
				this.writeList(distances, list);
			}

			in = new FileInputStream(salary);
			if(in.available() == 0){
				ArrayList<SalaryPO> list = new ArrayList<SalaryPO>();
				this.writeList(salary, list);
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private final String price = "src/main/java/save/strategydata/price.dat";
	private final String distances = "src/main/java/save/strategydata/distancepo.dat";
	private final String salary = "src/main/java/save/infodata/staffMessagePO.dat";

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

	@Override
	public ResultMessage saveSalary(ArrayList<StaffMessagePO> pos) throws RemoteException {
		try {
			this.writeList(salary, pos);
			return new ResultMessage("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage getPrice() throws RemoteException {
		try {
			double price = (double) this.readList(this.price);
			return new ResultMessage("success", price);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

	@Override
	public ResultMessage getSalary() throws RemoteException {
		try {
			ArrayList<StaffMessagePO> pos = (ArrayList<StaffMessagePO>) this.readList(salary);
			return new ResultMessage("success", pos);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMessage("dataerror", null);
		}
	}

}

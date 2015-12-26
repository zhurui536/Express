package dataservice.logisticsdataservice;

import po.logisticpo.LoadingBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GoodsLoadDataService extends Remote{

        public ResultMessage insertBill(LoadingBillPO bill) throws RemoteException;
        
        public ResultMessage insertBill(TransferBillPO bill) throws RemoteException;
        
        public ResultMessage findSendBills(ArrayList<String> ids) throws RemoteException;
        
        public ResultMessage updateSendBills(ArrayList<SendBillPO> newBills) throws RemoteException;
        
}

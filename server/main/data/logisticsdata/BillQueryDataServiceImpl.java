package main.data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.logisticpo.SendBillPO;

import dataservice.logisticsdataservice.BillQueryDataService;

public class BillQueryDataServiceImpl extends UnicastRemoteObject implements BillQueryDataService{

        private static final long serialVersionUID = 7499240604425522792L;

        private static final String PATH = "server/save/data/logistics/sendBillPO.dat";
        
        private List<SendBillPO> sendBillPOs;
        
        public BillQueryDataServiceImpl() throws RemoteException {
                super();
        }
        
        @Override
        public SendBillPO findBill(String id) throws RemoteException {
                // TODO Auto-generated method stub
                return null;
        }

}

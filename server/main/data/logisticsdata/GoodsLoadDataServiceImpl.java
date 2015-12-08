package main.data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.dao.Database;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;

import dataservice.logisticsdataservice.GoodsLoadDataService;

public class GoodsLoadDataServiceImpl extends UnicastRemoteObject implements GoodsLoadDataService{

        private static final long serialVersionUID = -8736571768693635155L;
        
        private static final String PATH_LOADING_BILL = "server/save/logisticsdata/loadingBillPO.dat";
        
        private static final String PATH_TRANSFER_BILL = "server/save/logisticsdata/transferBillPO.dat";

        private ArrayList<LoadingBillPO> loadingBillPOs;
        
        private ArrayList<TransferBillPO> transferBillPOs;
        
        public GoodsLoadDataServiceImpl() throws RemoteException {
                super();
                init();
        }
        
        @SuppressWarnings("unchecked")
        private void init() {
                loadingBillPOs = (ArrayList<LoadingBillPO>) Database.load(PATH_LOADING_BILL);
                if(loadingBillPOs == null)
                        loadingBillPOs = new ArrayList<>();
                transferBillPOs = (ArrayList<TransferBillPO>) Database.load(PATH_TRANSFER_BILL);
                if(transferBillPOs == null)
                        transferBillPOs = new ArrayList<>();
        }

        @Override
        public ResultMessage insertBill(LoadingBillPO bill)
                        throws RemoteException {
                for (LoadingBillPO loadingBillPO : loadingBillPOs) {
                        if(loadingBillPO.getTransferNum().equals(bill.getTransferNum())){
                                return new ResultMessage("EXIST");
                        }
                }
                loadingBillPOs.add(bill);
                Database.save(PATH_LOADING_BILL, loadingBillPOs);
                return new ResultMessage("SUCCESS");
        }

        @Override
        public ResultMessage insertBill(TransferBillPO bill)
                        throws RemoteException {
                for (TransferBillPO transferBillPO : transferBillPOs) {
                        if(transferBillPO.getTransferBillNum().equals(bill.getTransferBillNum())){
                                return new ResultMessage("EXIST");
                        }
                }
                transferBillPOs.add(bill);
                Database.save(PATH_TRANSFER_BILL, transferBillPOs);
                return new ResultMessage("SUCCESS");
        }

}

package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.Database;
import dataservice.logisticsdataservice.GoodsLoadDataService;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import util.ResultMessage;

public class GoodsLoadDataServiceImpl extends UnicastRemoteObject implements GoodsLoadDataService{

        private static final long serialVersionUID = -8736571768693635155L;
        
        private static final String PATH_LOADING_BILL = "save/logisticsdata/loadingBillPO.dat";
        
        private static final String PATH_TRANSFER_BILL = "save/logisticsdata/transferBillPO.dat";

        private static final String PATH_SEND_BILL = "save/logisticsdata/sendBillPO.dat";
        
        private ArrayList<LoadingBillPO> loadingBillPOs;
        
        private ArrayList<TransferBillPO> transferBillPOs;
        
        private ArrayList<SendBillPO> sendBillPOs;
        
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
                sendBillPOs = (ArrayList<SendBillPO>) Database.load(PATH_SEND_BILL);
                if(sendBillPOs == null)
                        sendBillPOs = new ArrayList<>();
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

        @Override
        public ResultMessage findSendBills(ArrayList<String> ids)
                        throws RemoteException {
                init();
                if(ids.size() == 0 || sendBillPOs.size() == 0)
                        return new ResultMessage("fail");
                ArrayList<SendBillPO> resultArrayList = new ArrayList<>();
                for (String string : ids) {
                        for (SendBillPO sendBillPO : sendBillPOs) {
                                if(string.equals(sendBillPO.getId()))
                                        resultArrayList.add(sendBillPO);
                        }
                }
                return new ResultMessage("success", resultArrayList);
        }

        @Override
        public ResultMessage updateSendBills(ArrayList<SendBillPO> newBills)
                        throws RemoteException {
                init();
                for (SendBillPO sendBillPO : newBills) {
                        for (SendBillPO sendBillPO1 : sendBillPOs) {
                                if(sendBillPO1.getId().equals(sendBillPO.getId()))
                                        sendBillPO1 = sendBillPO;
                        }
                }
                Database.save(PATH_SEND_BILL, sendBillPOs);
                return new ResultMessage("success");
        }

}

package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.Database;
import dataservice.logisticsdataservice.GoodsReceiptDataService;
import po.GoodsPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import util.ResultMessage;

public class GoodsReceiptDataServiceImpl extends UnicastRemoteObject implements GoodsReceiptDataService{

        private static final long serialVersionUID = 431203602157496993L;
        
        private static final String PATH_ARRIVAL_BILL = "save/logisticsdata/arrivalBillPO.dat";
        
        private static final String PATH_DELIEVRY_BILL = "save/logisticsdata/deliveryBillPO.dat";
        
        private static final String PATH_SEND_BILL  = "save/logisticsdata/sendBillPO.dat";
        
        private static final String PATH_LOADING_BILL = "save/logisticsdata/loadingBillPO.dat";
        
        private static final String PATH_TRANSFER_BILL = "save/logisticsdata/transferBillPO.dat";
        
        private ArrayList<ArrivalBillPO> arrivalBillPOs;
        
        private ArrayList<DeliveryBillPO> deliveryBillPOs;
        
        private ArrayList<SendBillPO> sendBillPOs;
        
        private ArrayList<LoadingBillPO> loadingBillPOs;
        
        private ArrayList<TransferBillPO> transferBillPOs;
        
        public GoodsReceiptDataServiceImpl() throws RemoteException {
                super();
                init();
        }

        @SuppressWarnings("unchecked")
        private void init(){
                deliveryBillPOs = (ArrayList<DeliveryBillPO>) Database.load(PATH_DELIEVRY_BILL);
                if (deliveryBillPOs == null) {
                        deliveryBillPOs = new ArrayList<>();
                }
                arrivalBillPOs = (ArrayList<ArrivalBillPO>) Database.load(PATH_ARRIVAL_BILL);
                if(arrivalBillPOs == null){
                        arrivalBillPOs = new ArrayList<>();
                }
                sendBillPOs = (ArrayList<SendBillPO>) Database.load(PATH_SEND_BILL);
                if (sendBillPOs == null) {
                        sendBillPOs = new ArrayList<>();
                }
                loadingBillPOs = (ArrayList<LoadingBillPO>) Database.load(PATH_LOADING_BILL);
                if (loadingBillPOs == null) {
                        loadingBillPOs = new ArrayList<>();
                }
                transferBillPOs = (ArrayList<TransferBillPO>) Database.load(PATH_TRANSFER_BILL);
                if (transferBillPOs == null) {
                        transferBillPOs = new ArrayList<>();
                }
        }
        
        @Override
        public ResultMessage findBill(String id) throws RemoteException {
                init();
                for (TransferBillPO transferBillPO : transferBillPOs) {
                        if(transferBillPO.getTransferBillNum().equals(id))
                                return new ResultMessage("FOUND_TransferBill",transferBillPO);
                }
                for (LoadingBillPO loadingBillPO : loadingBillPOs) {
                        if(loadingBillPO.getTransferNum().equals(id))
                                return new ResultMessage("FOUND_LoadingBill",loadingBillPO);
                }
                return new ResultMessage("NOT_FOUND");
        }

        @Override
        public GoodsPO findGoods(String id) throws RemoteException {
                init();
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getId().equals(id)){
                                return sendBillPO.getGoodsPO();
                        }
                }
                return null;
        }

        @Override
        public ResultMessage updateGoods(GoodsPO goodsPO)
                        throws RemoteException {
                init();
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getGoodsPO().getId().equals(goodsPO.getId())){
                                sendBillPO.setGoodsPO(goodsPO);
                                return new ResultMessage("SUCCESS");
                        }
                }
                Database.save(PATH_SEND_BILL, sendBillPOs);
                return new ResultMessage("NOT_FOUND");
        }

        @Override
        public ResultMessage insertBill(ArrivalBillPO bill)
                        throws RemoteException {
                for (ArrivalBillPO arrivalBillPO : arrivalBillPOs) {
                        if(arrivalBillPO.getTransferBillNum().equals(bill.getTransferBillNum()))
                                return new ResultMessage("EXIST");
                }
                arrivalBillPOs.add(bill);
                Database.save(PATH_ARRIVAL_BILL, arrivalBillPOs);
                return new ResultMessage("SUCCESS");
        }

        @Override
        public ResultMessage insertBill(DeliveryBillPO bill)
                        throws RemoteException {
                for (DeliveryBillPO deliveryBillPO : deliveryBillPOs) {
                        if(deliveryBillPO.getBillID().equals(bill.getBillID()))
                                return new ResultMessage("EXIST");
                }
                deliveryBillPOs.add(bill);
                Database.save(PATH_DELIEVRY_BILL, deliveryBillPOs);
                return new ResultMessage("SUCCESS");
        }


}

package main.bussinesslogic.logisticsbl;


import po.logisticpo.PeopleMessagePO;
import po.logisticpo.SendBillPO;
import dataservice.logisticsdataservice.ReceivingDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.ReceivingBLService;
import main.vo.GoodsVO;
import main.vo.logisticvo.SendBillVO;

public class ReceivingBL implements ReceivingBLService{

        private ReceivingDataService receivingDataService;
        
        @Override
        public ResultMessage addMessage(SendBillVO billVO) {
                //SendBillPO sendBillPO = new SendBillPO(senderPO, recipientPO, goodsPO, id)
                return null;
        }

        @Override
        public long getTime() {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public double getCharge(GoodsVO goods) {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public void endReceipt() {
                // TODO Auto-generated method stub
                
        }

}

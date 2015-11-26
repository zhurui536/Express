package main.bussinesslogic.logisticsbl;

import dataservice.logisticsdataservice.ReceivingDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.ReceivingBLService;
import main.vo.GoodsVO;
import main.vo.logisticvo.SendBillVO;

public class ReceivingBL implements ReceivingBLService{

        private ReceivingDataService receivingDataService;
        
        @Override
        public ResultMessage addMessage(SendBillVO billVO) {
                // TODO Auto-generated method stub
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

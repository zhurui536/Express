package main.bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.logisticpo.SendBillPO;
import dataservice.logisticsdataservice.BillQueryDataService;
import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.vo.logisticvo.SendBillVO;
/**
 * 
 * @author zhuding
 *
 */
public class BillQueryBL implements BillQueryBLService{

        private BillQueryDataService billQueryDataService;
        
        @Override
        public SendBillVO queryBill(String id) {
                SendBillPO sendBillPO = null;
                try {
                        sendBillPO = billQueryDataService.findBill(id);
                } catch (RemoteException e) {
                        e.printStackTrace();
                }
                return sendBillPO.poToVo();
        }

        @Override
        public void endQueryBill() {
                // TODO Auto-generated method stub
        }
        
}

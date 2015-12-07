package main.bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.logisticpo.SendBillPO;
import dataservice.logisticsdataservice.BillQueryDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
/**
 * 
 * @author zhuding
 *
 */
public class BillQueryBL implements BillQueryBLService{

        private BillQueryDataService billQueryDataService;
        
        @Override
        public ResultMessage queryBill(String id) {
                SendBillPO sendBillPO = null;
                try {
                        sendBillPO = billQueryDataService.findBill(id);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage("SUCCESS",sendBillPO.poToVo());
        }

}

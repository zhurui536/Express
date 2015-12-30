package bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import bussinesslogicservice.logisticsblservice.BillQueryBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.BillQueryDataService;
import po.logisticpo.SendBillPO;
import util.ResultMessage;

/**
 * 
 * @author zhuding
 * 
 */
public class BillQueryBL implements BillQueryBLService {

        private BillQueryDataService billQueryDataService;

        public BillQueryBL() {
                billQueryDataService = (BillQueryDataService) ClientRMIHelper
                                .getServiceByName("BillQueryDataServiceImpl");
        }

        @Override
        public ResultMessage queryBill(String id) {
                SendBillPO sendBillPO = null;
                try {
                        sendBillPO = billQueryDataService.findBill(id);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("internet error");
                }
                if(sendBillPO != null)
                        return new ResultMessage("SUCCESS",  sendBillPO.poToVo());
                else{
                        return new ResultMessage("FAIL");
                }
        }

}

package bussinesslogic.logisticsbl;

import bussinesslogicservice.logisticsblservice.BillQueryBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.BillQueryDataService;
import po.logisticpo.SendBillPO;
import util.ResultMessage;

import java.rmi.RemoteException;

/**
 * 
 * @author zhuding
 * 
 */
public class BillQueryBL implements BillQueryBLService {

        private BillQueryDataService billQueryDataService;

        public BillQueryBL() {
                ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
                billQueryDataService = (BillQueryDataService) clientRMIHelper
                                .getServiceByName("BillQueryDataServiceImpl");
        }

        @Override
        public ResultMessage queryBill(String id) {
                SendBillPO sendBillPO = null;
                try {
                        sendBillPO = billQueryDataService.findBill(id);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                if(sendBillPO != null)
                        return new ResultMessage("SUCCESS",  sendBillPO.poToVo());
                else{
                        return new ResultMessage("FAIL");
                }
        }

}

package bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import bussinesslogicservice.logisticsblservice.BillQueryBLService;
import connection.ClientRMIHelper;
import dataservice.billdataservice.BilldataService;
import dataservice.logisticsdataservice.BillQueryDataService;
import po.logisticpo.SendBillPO;
import util.BillType;
import util.ResultMessage;

/**
 * 
 * @author zhuding
 * 
 */
public class BillQueryBL implements BillQueryBLService {

        private BillQueryDataService billQueryDataService;
        private BilldataService billdata;

        public BillQueryBL() {
                billQueryDataService = (BillQueryDataService) ClientRMIHelper
                                .getServiceByName("BillQueryDataServiceImpl");
                billdata = (BilldataService) ClientRMIHelper
                        .getServiceByName("BillDataServiceImpl");
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

		@Override
		public ResultMessage queryBill(BillType type) {
			
			try {
				return billdata.getBills(type);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error");
			}
		}

}

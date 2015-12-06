package main.bussinesslogic.financebl;

import dataservice.financedataservice.ShowReceiptDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowReceiptBLService;
import main.connection.ClientRMIHelper;
import main.vo.logisticvo.ReceiptBillVO;
import po.logisticpo.ReceiptBillPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看收款单实现
 * Created by Away
 * 2015/11/15
 */

public class ShowReceiptBL implements ShowReceiptBLService {

    private ShowReceiptDataService showReceiptDataServiceImpl;

    public ShowReceiptBL() {
        showReceiptDataServiceImpl = (ShowReceiptDataService) ClientRMIHelper.
                getServiceByName("ShowReceiptDataServiceImpl");
    }

    @Override
    public ResultMessage showReceipt(Time time, String id) {
        try {
            ResultMessage msg = showReceiptDataServiceImpl.findAll();
            if (msg.getKey().equals("fail")) {
                return msg;
            }

            List<ReceiptBillVO> receiptBillVOs = new ArrayList<>();
            List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) msg.getValue();
            for (ReceiptBillPO po : receiptBillPOs) {
                if (isValid(po, time, id)) {
                    receiptBillVOs.add(po.poToVo());
                }
            }
            return new ResultMessage("success", receiptBillVOs);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    /**
     * // TODO 重写 equals方法
     * 检验是否符合搜索条件
     * @param po 带检查的收款单 po
     * @param time 搜索时间
     * @param id 营业厅 id
     * @return 符合为 true， 否则为 false
     */
    private boolean isValid(ReceiptBillPO po, Time time, String id) {
        return id.equals(po.getInstitutionID()) && time.equals(po.getTime());
    }
}

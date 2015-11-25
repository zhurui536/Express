package main.bussinesslogic.logisticsbl;

import main.bussinesslogic.util.GoodsState;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.vo.BillVO;
import main.vo.GoodsVO;

public class LogisticsBLController implements LogisticsBLService{

    @Override
    public ResultMessage addMessage(BillVO billVO) {
        // TODO Auto-generated method stub
        return new ResultMessage("success", null);
    }

    @Override
    public long getTime(String destination) {
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

    @Override
    public BillVO queryBill(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void endQueryBill() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ResultMessage addRecMessage(String Recipients, long id, long time) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void endDelivery() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ResultMessage produceLoadBill(BillVO billVO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void endGoodsLoad() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BillVO produceArrivalBill(BillVO transferBillVO,
            GoodsState goodsState) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BillVO produceSendBill(BillVO arrivalBillVO, long deliverManId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void endGoodsreceipt() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ResultMessage produceReceiptBill() {
        // TODO Auto-generated method stub
        return null;
    }

}

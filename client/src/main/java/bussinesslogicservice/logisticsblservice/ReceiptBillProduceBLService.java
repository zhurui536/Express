package bussinesslogicservice.logisticsblservice;


import util.ResultMessage;

/**
 * @author zhuding
 *
 */
public interface ReceiptBillProduceBLService {
        /**
         * 营业厅业务员要求生成收款单时调用
         * @return
         */
        public ResultMessage produceReceiptBill();
}

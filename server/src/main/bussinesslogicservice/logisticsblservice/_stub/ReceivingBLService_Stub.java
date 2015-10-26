package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.ReceivingBLService;
import main.vo.GoodsVO;
import main.vo.BillVO;
/**
 * @author zhuding
 *
 */
public class ReceivingBLService_Stub implements ReceivingBLService{

        private BillVO billVO;
        
        private GoodsVO goodsVO;
        
        public ReceivingBLService_Stub() {
        }
        
        
        
        @Override
        public ResultMessage addMessage(BillVO billVO) {
                this.billVO = billVO;
                return new ResultMessage("success", null);
        }

        @Override
        public long getTime(String destination) {
                String departurePlace = this.goodsVO.getDeparturePlace();
                //通过destination和departurePlace查文件获取平均时间
                System.out.println(departurePlace +" to "+ destination);
                return 100;
        }

        @Override
        public double getCharge(GoodsVO goods) {
                //实际应从billVO中获得
                this.goodsVO = goods;
                int tempDistance = 900;
                return PackageType.typeToCost(goods.getPackageType()) + goods.getWeight() * ExpressType.typeToCost(goodsVO.getExpressType(), tempDistance);
        }

        @Override
        public void endReceipt() {
                System.out.println("Success!");
        }

}

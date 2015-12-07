package po.logisticpo;

import java.util.ArrayList;

import po.BillPO;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.Time;

public class DeliveryBillPO extends BillPO{
        // 到达日期
        private Time time;
        // 托运订单条形码号
        private ArrayList<String> ids;
        // 派送员
        private String deliverManId;

        public DeliveryBillPO(Time time, ArrayList<String> ids,
                        String deliverManId) {
                super(null, BillType.DELIVERY, deliverManId);
                this.time = time;
                this.ids = ids;
                this.deliverManId = deliverManId;
        }

        public Time getTime() {
                return time;
        }

        public void setTime(Time time) {
                this.time = time;
        }

        public ArrayList<String> getIds() {
                return ids;
        }

        public void setIds(ArrayList<String> ids) {
                this.ids = ids;
        }

        public String getDeliverManId() {
                return deliverManId;
        }

        public void setDeliverManId(String deliverManId) {
                this.deliverManId = deliverManId;
        }

}

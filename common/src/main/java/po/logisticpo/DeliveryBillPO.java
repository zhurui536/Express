package po.logisticpo;

import po.BillPO;
import util.BillType;
import util.Time;

import java.util.ArrayList;

public class DeliveryBillPO extends BillPO {

        private static final long serialVersionUID = -2881503742972548225L;

        // 到达日期
        private Time time;
        // 托运订单条形码号
        private ArrayList<String> ids;
        // 派送员
        private String deliverManId;

        public DeliveryBillPO(Time time, ArrayList<String> ids,
                        String deliverManId) {
                super(BillType.DELIVERY, deliverManId);
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

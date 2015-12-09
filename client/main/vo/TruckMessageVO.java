package main.vo;

/**
 * @author zhuding
 * 
 */
public class TruckMessageVO {
        // 车辆编号
        public String id;

        // 车牌号
        public String plateNumber;

        // 服役时间
        public int time;

        public TruckMessageVO(String id, String plateNumber, int time) {
                super();
                this.id = id;
                this.plateNumber = plateNumber;
                this.time = time;
        }

        public TruckMessageVO() {

        }

}

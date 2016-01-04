package vo;

import util.PublicMessage;

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
        
        public String institutionID;

        public TruckMessageVO(String id, String plateNumber, int time) {
                super();
                this.id = id;
                this.plateNumber = plateNumber;
                this.time = time;
                this.institutionID = PublicMessage.institutionID;
        }

        public TruckMessageVO() {
                this.institutionID = PublicMessage.institutionID;
        }

}

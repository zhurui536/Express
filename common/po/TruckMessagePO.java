package po;

import java.io.Serializable;

/**
 * 车辆信息PO
 * Created by Away
 * 2015/10/26
 */

public class TruckMessagePO implements Serializable {

    private static final long serialVersionUID = -7361521750619540694L;
    
    // 车辆编号
    String id;

    // 车牌号
    String plateNumber;

    // 服役时间
    int time;

    public TruckMessagePO(String id, String plateNumber, int time) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

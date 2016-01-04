package po;


import java.io.Serializable;

import util.PublicMessage;
import vo.TruckMessageVO;

/**
 * 车辆信息PO
 * Created by Away
 * 2015/10/26
 */

public class TruckMessagePO implements Serializable {

    private static final long serialVersionUID = -7361521750619540694L;
    
    // 车辆编号
    private String id;

    // 车牌号
    private String plateNumber;

    // 服役时间
    private int time;
    
 // 所属营业厅ID
    private String institutionID;


    public TruckMessagePO(String id, String plateNumber, int time) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.time = time;
        this.setInstitutionID(PublicMessage.institutionID);
    }
    
    public TruckMessagePO(TruckMessageVO truckMessageVO) {
            this.id = truckMessageVO.id;
            this.plateNumber = truckMessageVO.plateNumber;
            this.time = truckMessageVO.time;
            this.setInstitutionID(PublicMessage.institutionID);
}

    public TruckMessageVO poToVo() {
        return new TruckMessageVO(id, plateNumber, time);
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

public String getInstitutionID() {
        return institutionID;
}

public void setInstitutionID(String institutionID) {
        this.institutionID = institutionID;
}
}

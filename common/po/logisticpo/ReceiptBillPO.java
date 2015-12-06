package po.logisticpo;

import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.infoblservice._driver.InstitutionMessageMaintenanceBLService_Driver;
import main.vo.StaffMessageVO;
import main.vo.logisticvo.ReceiptBillVO;
import po.StaffMessagePO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 收款单PO
 * 2015/12/6
 */

public class ReceiptBillPO implements Serializable {

        private static final long serialVersionUID = 1526637956814486761L;

        private Time time;

    private BigDecimal money;

    private String deliveryManID;
    
    private String institutionID;

    private List<String> barCodes;

    

    public ReceiptBillPO(Time time, BigDecimal money, String deliveryManID,
                String institutionID, List<String> barCodes) {
        super();
        this.time = time;
        this.money = money;
        this.deliveryManID = deliveryManID;
        this.institutionID = institutionID;
        this.barCodes = barCodes;
}

public ReceiptBillVO poToVo() {
        List<String> newBarCodes = new ArrayList<>(barCodes);
        return new ReceiptBillVO(time, money, deliveryManID, institutionID,newBarCodes);
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

  

    public String getDeliveryManID() {
        return deliveryManID;
}

public void setDeliveryManID(String deliveryManID) {
        this.deliveryManID = deliveryManID;
}

public String getInstitutionID() {
        return institutionID;
}

public void setInstitutionID(String institutionID) {
        this.institutionID = institutionID;
}

public List<String> getBarCodes() {
        return barCodes;
    }

    public void setBarCodes(List<String> barCodes) {
        this.barCodes = barCodes;
    }

}

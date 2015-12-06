package main.vo.logisticvo;

import main.bussinesslogic.util.Time;
import main.vo.StaffMessageVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Away
 * 2015/12/6
 */

public class ReceiptBillVO {

    public Time time;

    public BigDecimal money;

    public StaffMessageVO staffMessageVO;

    public List<String> barCodes;

    public ReceiptBillVO(Time time, BigDecimal money,
                         StaffMessageVO staffMessageVO, List<String> barCodes) {
        this.time = time;
        this.money = money;
        this.staffMessageVO = staffMessageVO;
        this.barCodes = barCodes;
    }
}

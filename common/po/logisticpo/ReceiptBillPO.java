package po.logisticpo;

import main.bussinesslogic.util.Time;
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

public class ReceiptBillPO implements Serializable, Comparable<ReceiptBillPO> {

    private Time time;

    private BigDecimal money;

    private StaffMessagePO staffMessagePO;

    private List<String> barCodes;

    public ReceiptBillPO(Time time, BigDecimal money,
                         StaffMessagePO staffMessagePO, List<String> barCodes) {
        this.time = time;
        this.money = money;
        this.staffMessagePO = staffMessagePO;
        this.barCodes = barCodes;
    }

    public ReceiptBillVO poToVo() {
        StaffMessageVO staffMessageVO = staffMessagePO.poToVo();
        List<String> newBarCodes = new ArrayList<>(barCodes);
        return new ReceiptBillVO(time, money, staffMessageVO, newBarCodes);
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

    public StaffMessagePO getStaffMessagePO() {
        return staffMessagePO;
    }

    public void setStaffMessagePO(StaffMessagePO staffMessagePO) {
        this.staffMessagePO = staffMessagePO;
    }

    public List<String> getBarCodes() {
        return barCodes;
    }

    public void setBarCodes(List<String> barCodes) {
        this.barCodes = barCodes;
    }

    @Override
    public int compareTo(ReceiptBillPO receiptBillPO) {
        return time.compareTo(receiptBillPO.time);
    }
}

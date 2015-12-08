package main.vo.financevo;

import main.bussinesslogic.util.PayItem;
import main.bussinesslogic.util.Time;
import main.vo.StaffMessageVO;

import java.math.BigDecimal;

/**
 * Created by Away
 * 2015/12/6
 */

public class PayBillVO {

    public Time time;

    public BigDecimal money;

    // 付款人
    public StaffMessageVO staffMessageVO;

    public BankAccountVO bankAccountVO;

    // 付款单编号
    public String id;

    // 付款条目
    public PayItem item;

    // 备注
    public String remark;

    public PayBillVO(Time time, BigDecimal money, StaffMessageVO staffMessageVO,
                     BankAccountVO bankAccountPO, String id, PayItem item, String remark) {
        this.time = time;
        this.money = money;
        this.staffMessageVO = staffMessageVO;
        this.bankAccountVO = bankAccountPO;
        this.id = id;
        this.item = item;
        this.remark = remark;
    }
}

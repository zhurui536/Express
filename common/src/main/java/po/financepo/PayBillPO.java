package po.financepo;

import java.math.BigDecimal;

import po.BillPO;
import util.BillType;
import util.PayItem;
import util.Time;
import vo.financevo.PayBillVO;

/**
 * 付款单PO
 * Created by Away
 * 2015/12/6
 */

public class PayBillPO extends BillPO {

    private static final long serialVersionUID = 2279200270601944748L;

    private Time time;

    private BigDecimal money;

    // 付款人ID
    public String staffID;

    // 付款账号
    private String bankAccountID;

    // 付款单编号
    private String id;

    // 付款条目
    private PayItem item;

    // 备注
    private String remark;

    public PayBillPO(Time time, BigDecimal money, String staffID,
                     String bankAccountID, String id, PayItem item, String remark) {
    	super(BillType.PAYMENT, staffID);
    	this.staffID = staffID;
        this.time = time;
        this.money = money;
        this.bankAccountID = bankAccountID;
        this.id = super.getBillID();
        this.item = item;
        this.remark = remark;
    }

    public PayBillPO(PayBillVO payBillVO) {
    	super(BillType.PAYMENT, payBillVO.staffID);
        
        this.time = payBillVO.time;
        this.money = payBillVO.money;
        this.staffID = payBillVO.staffID;
        this.bankAccountID = payBillVO.bankAccountID;
        this.id = super.getBillID();
        this.item = payBillVO.item;
        this.remark = payBillVO.remark;
    }

    public PayBillVO poToVo() {
        return new PayBillVO(time, money, staffID, bankAccountID, id, item, remark);
    }

    public Time getTime() {
        return time;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getBankAccountID() {
        return bankAccountID;
    }

    public String getId() {
        return id;
    }

    public PayItem getItem() {
        return item;
    }

    public String getRemark() {
        return remark;
    }
}
package po.financepo;

import po.BillPO;
import po.StaffMessagePO;
import util.BillType;
import util.PayItem;
import util.Time;
import vo.StaffMessageVO;
import vo.financevo.BankAccountVO;
import vo.financevo.PayBillVO;

import java.math.BigDecimal;

/**
 * 付款单PO
 * Created by Away
 * 2015/12/6
 */

public class PayBillPO extends BillPO {

    private static final long serialVersionUID = 2279200270601944748L;

    private Time time;

    private BigDecimal money;

    // 付款人
    private StaffMessagePO staffMessagePO;

    private BankAccountPO bankAccountPO;

    // 付款单编号
    private String id;

    // 付款条目
    private PayItem item;

    // 备注
    private String remark;

    public PayBillPO(Time time, BigDecimal money, StaffMessagePO staffMessagePO,
                     BankAccountPO bankAccountPO, String id, PayItem item, String remark) {
    	super(id, BillType.PAYMENT, staffMessagePO.getId());
        this.time = time;
        this.money = money;
        this.staffMessagePO = staffMessagePO;
        this.bankAccountPO = bankAccountPO;
        this.id = id;
        this.item = item;
        this.remark = remark;
    }

    public PayBillPO(PayBillVO payBillVO) {
    	super(payBillVO.id, BillType.PAYMENT, payBillVO.staffMessageVO.id);
        BankAccountVO bankAccountVO = payBillVO.bankAccountVO;
        StaffMessageVO staffMessageVO = payBillVO.staffMessageVO;
        
        this.time = payBillVO.time;
        this.money = payBillVO.money;
        this.staffMessagePO = new StaffMessagePO(staffMessageVO.id, staffMessageVO.name, id, null, null, 0);
        this.bankAccountPO = new BankAccountPO(bankAccountVO.name, bankAccountVO.balance, bankAccountVO.id);
        this.id = payBillVO.id;
        this.item = payBillVO.item;
        this.remark = payBillVO.remark;
    }

    public PayBillVO poToVo() {
        BankAccountVO bankAccountVO = bankAccountPO.poToVo();
        StaffMessageVO staffMessageVO = staffMessagePO.poToVo();
        return new PayBillVO(time, money, staffMessageVO, bankAccountVO, id, item, remark);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Time getTime() {
        return time;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public StaffMessagePO getStaffMessagePO() {
        return staffMessagePO;
    }

    public BankAccountPO getBankAccountPO() {
        return bankAccountPO;
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
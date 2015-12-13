package vo.financevo;

import java.math.BigDecimal;

import po.financepo.PayBillPO;
import util.PayItem;
import util.Time;
import vo.StaffMessageVO;

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
                     BankAccountVO bankAccountVO, String id, PayItem item, String remark) {
        this.time = time;
        this.money = money;
        this.staffMessageVO = staffMessageVO;
        this.bankAccountVO = bankAccountVO;
        this.id = id;
        this.item = item;
        this.remark = remark;
    }
    
    public PayBillVO(PayBillPO po){
    	this.time = po.getTime();
    	this.money = po.getMoney();
    	this.staffMessageVO = new StaffMessageVO(po.getStaffMessagePO());
    	this.bankAccountVO = new BankAccountVO(po.getBankAccountPO());
    	this.id = po.getId();
    	this.item = po.getItem();
    	this.remark = po.getRemark();
    }
}

package vo.financevo;

import java.math.BigDecimal;

import util.PayItem;
import util.Time;

/**
 * Created by Away
 * 2015/12/6
 */

public class PayBillVO {

    public Time time;

    public BigDecimal money;

    // 付款人ID
    public String staffID;

    // 付款账号
    public String bankAccountID;

    // 付款单编号
    public String id;

    // 付款条目
    public PayItem item;

    // 备注
    public String remark;

    public PayBillVO(Time time, BigDecimal money, String staffID,
                     String bankAccountID, String id, PayItem item, String remark) {
        this.time = time;
        this.money = money;
        this.staffID = staffID;
        this.bankAccountID = bankAccountID;
        this.id = id;
        this.item = item;
        this.remark = remark;
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

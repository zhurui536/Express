package po.financepo;

import java.math.BigDecimal;

/**
 * 成本收益表PO
 * Created by Away
 * 2015/10/26
 */

public class ProfitListPO {

    // 总收入
    private BigDecimal income;

    // 总支出
    private BigDecimal pay;

    public ProfitListPO(double income, double pay) {
        this.income = new BigDecimal(income);
        this.pay = new BigDecimal(pay);
    }

    public ProfitListPO(BigDecimal income, BigDecimal pay) {
        this.income = income;
        this.pay = pay;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }
}

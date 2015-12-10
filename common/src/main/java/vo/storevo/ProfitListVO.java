package vo.storevo;

import java.math.BigDecimal;

/**
 * 经营情况表 VO
 * Created by Away
 * 2015/12/7
 */

public class ProfitListVO {

    // 总收入
    public BigDecimal income;

    // 总支出
    public BigDecimal pay;

    // 利润
    public BigDecimal profit;

    public ProfitListVO(BigDecimal income, BigDecimal pay, BigDecimal profit) {
        this.income = income;
        this.pay = pay;
        this.profit = profit;
    }
}

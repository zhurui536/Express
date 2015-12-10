package vo.financevo;

import java.math.BigDecimal;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountVO {

    // 账户名称
    public String name;

    // 账户余额
    public BigDecimal balance;

    // 账户账号
    public String id;

    public BankAccountVO(String name, BigDecimal balance, String id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
    }

    public BankAccountVO() {
    }
}

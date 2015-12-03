package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountPO implements Serializable {

    // 账户名称
    private String name;

    // 账户余额
    private BigDecimal balance;

    // 账户账号
    private String id;

    public BankAccountPO(String name, BigDecimal balance, String id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
    }

    public BankAccountPO(String name, String id) {
        this.name = name;
        this.id = id;
        this.balance = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPO(BankAccountPO po) {
        this.name = po.name;
        this.balance = po.balance;
        this.id = po.id;
    }
}

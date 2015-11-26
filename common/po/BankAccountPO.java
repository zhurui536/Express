package po;

import java.io.Serializable;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountPO implements Serializable {

    // 账户名称
    private String name;

    // 账户余额
    private double balance;

    // 账户账号
    private String id;

    public BankAccountPO(String name, double balance, String id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
    }

    public BankAccountPO(String name, String id) {
        this.name = name;
        this.id = id;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}

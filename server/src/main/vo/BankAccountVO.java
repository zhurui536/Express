package main.vo;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountVO {

    // 账户名称
    private String name;

    // 账户余额
    private long balance;

    // 账户账号
    private long id;

    public BankAccountVO(String name, long balance, long id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

}

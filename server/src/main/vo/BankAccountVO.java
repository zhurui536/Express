package main.vo;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountVO {

    // 账户名称
    private String name;

    // 账户余额
    private double balance;

    // 账户账号
    private String id;

    public BankAccountVO(String name, long balance, String id) {
        this.name = name;
        this.balance = balance;
        this.id = id;
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

}

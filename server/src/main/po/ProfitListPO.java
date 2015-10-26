package main.po;

/**
 * 成本收益表PO
 * Created by Away
 * 2015/10/26
 */

public class ProfitListPO {

    // 总收入
    private double income;

    // 总支出
    private double pay;

    public ProfitListPO(double income, double pay) {
        this.income = income;
        this.pay = pay;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}

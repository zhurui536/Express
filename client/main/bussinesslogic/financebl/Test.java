package main.bussinesslogic.financebl;

import po.BankAccountPO;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Away
 * 2015/11/27
 */

public class Test {

    public static void main(String[] args) {
        ArrayList<BankAccountPO> bankAccountPOs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bankAccountPOs.add(new BankAccountPO("test", BigDecimal.valueOf(i), "id" + i));
        }
        BankAccountPO bankAccount = new BankAccountPO("test", BigDecimal.valueOf(5), "id" + 5);
//        Iterator<BankAccountPO> iter = bankAccountPOs.iterator();
//        while (iter.hasNext()) {
//            if (iter.next().equals(bankAccount)) {
//                iter.remove();
//                System.out.println("get");
//            }
//        }
        bankAccountPOs.remove(bankAccountPOs.get(4));

        for (BankAccountPO bankAccountPO : bankAccountPOs) {
            System.out.println(bankAccountPO.getBalance());
        }
    }
}

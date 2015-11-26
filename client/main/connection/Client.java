package main.connection;

import main.bussinesslogic.financebl.BankAccountManagementBL;

/**
 * Created by Away
 * 2015/11/26
 */

public class Client {
    public static void main(String[] args) {
        try {
            ClientRMIHelper.init();
            BankAccountManagementBL bankAccountManagementBL = new BankAccountManagementBL();
            bankAccountManagementBL.inquireMember(null);
        } catch (ClientInitException e) {
            e.printStackTrace();
        }

    }
}

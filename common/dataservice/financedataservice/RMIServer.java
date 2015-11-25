package dataservice.financedataservice;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Away
 * 2015/11/25
 */

public class RMIServer {

    public static void main(String[] args) throws Exception
    {
        try {
            BankAccountManagementDataService bankAccountManagementData
                    = new BankAccountManagementData();
            LocateRegistry.createRegistry(6600);
            Naming.rebind("rmi://127.0.0.1:6600/bankAccountManagementData", bankAccountManagementData);

            System.out.println("rmi server start ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


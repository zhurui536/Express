package main.connection;

import main.data.financedata.BankAccountManagementDataServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Away
 * 2015/11/26
 */

public class ServerRMIHelper {

    private static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP =
            new HashMap<>();

    private static final String IP = "127.0.0.1";

    private static final int PORT = 1099;

    private static boolean init = false;

    static {
        NAMING_MAP.put("BankAccountManagementDataServiceImpl", BankAccountManagementDataServiceImpl.class);
    }

    public synchronized static void init() throws ServerInitException {
        if (init) {
            return;
        }
        try {
            LocateRegistry.createRegistry(PORT);
            for (Entry<String, Class<? extends UnicastRemoteObject>> entry : NAMING_MAP.entrySet()) {
                System.out.println(entry.getKey());
                String name = "rmi://" + IP + ":" + PORT +  "/" + entry.getKey();
                Class<? extends UnicastRemoteObject> clazz = entry.getValue();
                UnicastRemoteObject proxy = clazz.newInstance();
                Naming.rebind(name, proxy);
                System.out.println("Server started ...");
            }
            init = true;
        } catch (Exception e) {
            throw new ServerInitException(e);
        }
    }
}

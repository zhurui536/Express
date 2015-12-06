package main.connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Away
 * 2015/11/25
 */

public class ClientRMIHelper {

    private static final String IP = "127.0.0.1"; //Can be read from config file

    private static final String PORT = "1099";

    private static boolean init = false;

    private static Map<String, Object> OBJECT_MAP = new HashMap<>();

    private static String[] CLASS_NAMES = {
            "BankAccountManagementDataServiceImpl",
            "CreatePayBillDataServiceImpl"
    };

    public synchronized static void init() throws ClientInitException {
        if (init) {
            return;
        }

        try {
            initObjects();
            init = true;
        } catch (Exception e) {
            throw new ClientInitException(e);
        }
    }

    private static void initObjects() throws MalformedURLException, RemoteException, NotBoundException {
        String urlPrefix = "rmi://" + IP + ":" + PORT + "/";
        for (String name : CLASS_NAMES) {
            OBJECT_MAP.put(name, Naming.lookup(urlPrefix + name));
        }
    }

    public static Object getServiceByName(String name) {
        System.out.println(OBJECT_MAP.get(name));
        return OBJECT_MAP.get(name);
    }
}

package main.connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Away
 * 2015/11/25
 */

public class ClientRMIHelper {

    private static final String IP = "localhost"; //Can be read from config file

    private static boolean init = false;

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
        String urlPrefix = "rmi://" + IP + "/";
        Naming.lookup(urlPrefix + "order-businessLogic");
    }

    public static Object getServiceByName(String name) {
        return null;
    }
}

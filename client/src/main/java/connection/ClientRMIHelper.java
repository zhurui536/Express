package connection;

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

    private static final String IP = "172.26.98.70"; //Can be read from config file

    private static final int PORT = 1099;

    private static boolean init = false;

    private static Map<String, Object> OBJECT_MAP = new HashMap<>();

    private static String[] CLASS_NAMES = {
            "BankAccountManagementDataServiceImpl",
            "CreatePayBillDataServiceImpl",
            "ShowStatementDataServiceImpl",
            "CreateAccountingDataServiceImpl",
            "ShowReceiptDataServiceImpl",
            "StoreDataServiceImpl",
            "BillDataServiceImpl",
            "DeliveryDataServiceImpl",
            "BillQueryDataServiceImpl",
            "GoodsLoadDataServiceImpl",
            "GoodsReceiptDataServiceImpl",
            "ReceiptBillProduceDataServiceImpl",
            "ReceivingDataServiceImpl",
            "SystemlogDataServiceImpl",
            "DriverMessageMaintenanceDataServiceImpl",
            "InstitutionMessageMaintenanceDataServiceImpl",
            "StaffMessageMaintenanceDataServiceImpl",
            "TruckMessageMaintenanceDataServiceImpl",
            "StrategyDataServiceImpl",
            "AdminDataServiceImpl"
    };

    public ClientRMIHelper() {
        try {
            init();
        } catch (ClientInitException e) {
            e.printStackTrace();
        }
    }

    public synchronized void init() throws ClientInitException {
        if (init) {
            return;
        }
        
//        if(System.getSecurityManager() == null) {  
//            System.setSecurityManager(new RMISecurityManager());  
//        }
        
        try {
            initObjects();
            init = true;
        } catch (Exception e) {
            throw new ClientInitException(e);
        }
    }

    private void initObjects() throws MalformedURLException, RemoteException, NotBoundException {
        String urlPrefix = "rmi://" + IP + ":" + PORT + "/";
//        System.out.println(LocateRegistry.getRegistry(IP, PORT));
//        System.out.println(LocateRegistry.getRegistry(IP));
//        Registry registry = LocateRegistry.getRegistry(IP);
        for (String name : CLASS_NAMES) {
//            System.out.println(registry.lookup(name));
            OBJECT_MAP.put(name, Naming.lookup(urlPrefix + name));
        }
    }

    public Object getServiceByName(String name) {
        System.out.println(OBJECT_MAP.get(name));
        return OBJECT_MAP.get(name);
    }
}

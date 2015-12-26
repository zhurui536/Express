package connection;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Away
 * 2015/11/25
 */

public class ClientRMIHelper {

    private static String IP = RMIConfig.getIP();
    
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
        
        try {
            initObjects();
            init = true;
        } catch (Exception e) {
            throw new ClientInitException(e);
        }
    }

    private void initObjects() throws MalformedURLException, RemoteException, NotBoundException {
//        System.out.println(LocateRegistry.getRegistry(IP));
        Registry registry = LocateRegistry.getRegistry(IP);
        for (String name : CLASS_NAMES) {
            OBJECT_MAP.put(name, registry.lookup(name));
        }
    }

    public Object getServiceByName(String name) {
//        System.out.println(OBJECT_MAP.get(name));
        return OBJECT_MAP.get(name);
    }
}

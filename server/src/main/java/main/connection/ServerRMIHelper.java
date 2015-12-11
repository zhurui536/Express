package main.connection;

import main.data.billdata.BillDataServiceImpl;
import main.data.financedata.*;
import main.data.infodata.*;
import main.data.logisticsdata.*;
import main.data.storedata.StoreDataServiceImpl;
import main.data.strategydata.StrategyDataServiceImpl;
import main.data.userdata.AdminDataServiceImpl;

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

//    private static String[] CLASS_NAMES = {
//            "BankAccountManagementDataServiceImpl",
//            "CreatePayBillDataServiceImpl"
//    };

    static {
        NAMING_MAP.put("BankAccountManagementDataServiceImpl", BankAccountManagementDataServiceImpl.class);
        NAMING_MAP.put("CreateAccountingDataServiceImpl", CreateAccountingDataServiceImpl.class);
        NAMING_MAP.put("CreatePayBillDataServiceImpl", CreatePayBillDataServiceImpl.class);
        NAMING_MAP.put("ShowStatementDataServiceImpl", ShowStatementDataServiceImpl.class);
        NAMING_MAP.put("ShowReceiptDataServiceImpl", ShowReceiptDataServiceImpl.class);
        NAMING_MAP.put("StoreDataServiceImpl", StoreDataServiceImpl.class);
        NAMING_MAP.put("BillDataServiceImpl", BillDataServiceImpl.class);
        NAMING_MAP.put("BillQueryDataServiceImpl", BillQueryDataServiceImpl.class);
        NAMING_MAP.put("DeliveryDataServiceImpl", DeliveryDataServiceImpl.class);
        NAMING_MAP.put("GoodsLoadDataServiceImpl", GoodsLoadDataServiceImpl.class);
        NAMING_MAP.put("GoodsReceiptDataServiceImpl", GoodsReceiptDataServiceImpl.class);
        NAMING_MAP.put("ReceiptBillProduceDataServiceImpl", ReceiptBillProduceDataServiceImpl.class);
        NAMING_MAP.put("ReceivingDataServiceImpl", ReceivingDataServiceImpl.class);
        NAMING_MAP.put("SystemlogDataServiceImpl", SystemlogDataServiceImpl.class);
        NAMING_MAP.put("DriverMessageMaintenanceDataServiceImpl", DriverMessageMaintenanceDataServiceImpl.class);
        NAMING_MAP.put("InstitutionMessageMaintenanceDataServiceImpl", InstitutionMessageMaintenanceDataServiceImpl.class);
        NAMING_MAP.put("StaffMessageMaintenanceDataServiceImpl", StaffMessageMaintenanceDataServiceImpl.class);
        NAMING_MAP.put("TruckMessageMaintenanceDataServiceImpl", TruckMessageMaintenanceDataServiceImpl.class);
        NAMING_MAP.put("StrategyDataServiceImpl", StrategyDataServiceImpl.class);
        NAMING_MAP.put("AdminDataServiceImpl", AdminDataServiceImpl.class);
        
        //        for (String name : CLASS_NAMES) {
//            try {
//                NAMING_MAP.put(name, (Class<? extends UnicastRemoteObject>) Class.forName("main.data.financedata." + name));
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
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
            }
            System.out.println("Server started ...");
            init = true;
        } catch (Exception e) {
            throw new ServerInitException(e);
        }
    }
}

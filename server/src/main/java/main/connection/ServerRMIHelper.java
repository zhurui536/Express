package main.connection;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.data.billdata.BillDataServiceImpl;
import main.data.financedata.BankAccountManagementDataServiceImpl;
import main.data.financedata.CreateAccountingDataServiceImpl;
import main.data.financedata.CreatePayBillDataServiceImpl;
import main.data.financedata.ShowReceiptDataServiceImpl;
import main.data.financedata.ShowStatementDataServiceImpl;
import main.data.infodata.DriverMessageMaintenanceDataServiceImpl;
import main.data.infodata.InstitutionMessageMaintenanceDataServiceImpl;
import main.data.infodata.StaffMessageMaintenanceDataServiceImpl;
import main.data.infodata.SystemlogDataServiceImpl;
import main.data.infodata.TruckMessageMaintenanceDataServiceImpl;
import main.data.logisticsdata.BillQueryDataServiceImpl;
import main.data.logisticsdata.DeliveryDataServiceImpl;
import main.data.logisticsdata.GoodsLoadDataServiceImpl;
import main.data.logisticsdata.GoodsReceiptDataServiceImpl;
import main.data.logisticsdata.ReceiptBillProduceDataServiceImpl;
import main.data.logisticsdata.ReceivingDataServiceImpl;
import main.data.storedata.StoreDataServiceImpl;
import main.data.strategydata.StrategyDataServiceImpl;
import main.data.userdata.AdminDataServiceImpl;


/**
 * Created by Away
 * 2015/11/26
 */

public class ServerRMIHelper {

    private static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP = new HashMap<>();

//    private static final String IP = "172.26.98.70";
  private static final String IP = "localhost";
  
    private static final int PORT = 1099;

    private static boolean init = false;

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
    }

    public synchronized static void init() throws ServerInitException {
        if (init) {
            return;
        }
        
        try {
        	System.setProperty("java.rmi.server.hostname" , IP);
        	MyRMIFactory myRMIFactory = new MyRMIFactory(IP, PORT);
        	Registry registry = LocateRegistry.createRegistry(PORT, myRMIFactory, myRMIFactory);
        	
            for (Entry<String, Class<? extends UnicastRemoteObject>> entry : NAMING_MAP.entrySet()) {
                System.out.println(entry.getKey());
                String name = entry.getKey();
                Class<? extends UnicastRemoteObject> clazz = entry.getValue();
                UnicastRemoteObject proxy = clazz.newInstance();
                registry.rebind(name, proxy);
            }
            
            System.out.println("Server started ...");
            init = true;
        } catch (Exception e) {
            throw new ServerInitException(e);
        }
    }

}

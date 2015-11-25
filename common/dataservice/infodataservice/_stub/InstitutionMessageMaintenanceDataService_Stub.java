package dataservice.infodataservice._stub;

import java.rmi.RemoteException;

import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import po.InstitutionMessagePO;

/**
 * @author zhuding
 *
 */
public class InstitutionMessageMaintenanceDataService_Stub implements InstitutionMessageMaintenanceDataService {
        @Override
        public InstitutionMessagePO find(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("find it");
                return new InstitutionMessagePO(null,null);
        }

        @Override
        public void insert(InstitutionMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("insert successfully");
        }

        @Override
        public void delete(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("delete successfully");
        }

        @Override
        public void update(InstitutionMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("update successfully");
        }

        
}

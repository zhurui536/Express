package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.SystemlogMaintenanceDataService;
import po.SystemlogPO;
import util.ResultMessage;
import vo.SystemlogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public class SystemlogBL implements SystemlogMaintenanceBLService {
        
        private SystemlogMaintenanceDataService systemlogMaintenanceDataService;
        
        public SystemlogBL() {
                systemlogMaintenanceDataService = (SystemlogMaintenanceDataService) ClientRMIHelper.getServiceByName("SystemlogDataServiceImpl");
        }
        
        @Override
        public ResultMessage addSystemlog(SystemlogVO systemlog) {
                try {
                        systemlogMaintenanceDataService.insert(voToPo(systemlog));
                } catch (RemoteException e) {
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage("SUCCESS");
        }

        @Override
        public ResultMessage showSystemlog() {
                ArrayList<SystemlogPO> systemlogPOs = null;
                try {
                        systemlogPOs = systemlogMaintenanceDataService.getSystemlog();
                } catch (RemoteException e) {
                        return new ResultMessage("NO_LOG_EXIST", null);
                }
                ArrayList<SystemlogVO> systemlogVOs = new ArrayList<SystemlogVO>();
                Iterator<SystemlogPO> iterator = systemlogPOs.iterator();
                while (iterator.hasNext()) {
                        systemlogVOs.add(poToVo(iterator.next()));
                }
                return new ResultMessage("FOUND", systemlogVOs);
        }
        
        private SystemlogVO poToVo(SystemlogPO systemlogPO) {
                SystemlogVO systemlogVO = new SystemlogVO();
                systemlogVO.event = systemlogPO.getEvent();
                systemlogVO.origin = systemlogPO.getOrigin();
                systemlogVO.time = systemlogPO.getTime();
                systemlogVO.userID = systemlogPO.getUserID();
                return systemlogVO;
        }
        
        private SystemlogPO voToPo(SystemlogVO systemlogVO) {
                return new SystemlogPO(systemlogVO.time, systemlogVO.origin,
                                systemlogVO.userID, systemlogVO.event);
        }
        
}

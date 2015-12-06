package main.bussinesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.SystemlogPO;

import dataservice.infodataservice.SystemlogMaintenanceDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import main.vo.SystemlogVO;

public class SystemlogBL implements SystemlogMaintenanceBLService{
        
        private SystemlogMaintenanceDataService systemlogMaintenanceDataService;
        
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

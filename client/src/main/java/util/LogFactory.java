package util;

import bussinesslogic.infobl.SystemlogBL;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;

public class LogFactory {
        private static SystemlogMaintenanceBLService service;
        
        private LogFactory(){}
        
        public static SystemlogMaintenanceBLService getInstance() {
                if(service == null)
                        service = new SystemlogBL();
                return service;
        }
}

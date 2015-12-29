package bussinesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import po.InstitutionMessagePO;
import po.StaffMessagePO;
import util.City;
import util.InstitutionType;
import util.ResultMessage;
import vo.InstitutionMessageVO;

public class InstitutionMessageMaintenanceBL implements
        InstitutionMessageMaintenanceBLService {

        private InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService;
        private ArrayList<InstitutionMessagePO> pos;
		private StaffMessageMaintenanceDataService staffMessageMaintenanceDataService;

        public InstitutionMessageMaintenanceBL() {
                institutionMessageMaintenanceDataService = (InstitutionMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("InstitutionMessageMaintenanceDataServiceImpl");
                staffMessageMaintenanceDataService = (StaffMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("StaffMessageMaintenanceDataServiceImpl");
        }

        @SuppressWarnings("unchecked")
		@Override
        public ResultMessage addInstitutionMessage(
                        InstitutionMessageVO inst) {
                ResultMessage resultMessage = null;
                try {
    				if(inst.institutionType == InstitutionType.TRANSIT_CENTER){//中转中心编号的自动生成
    					inst.id = City.CityToNum(inst.city) + 0;
    					resultMessage = institutionMessageMaintenanceDataService.insert(new InstitutionMessagePO(inst));
    				}
    				else{//营业厅的编号需要先读取所有的机构信息，再根据已有的机构得出序号
    					ResultMessage result = this.institutionMessageMaintenanceDataService.get();
        				pos = (ArrayList<InstitutionMessagePO>) result.getValue();
    					inst.id = City.CityToNum(inst.city);
    					int num = 0;
    					for(int i=0;i<pos.size();i++){
    						if(inst.institutionType == pos.get(i).getInstitutionType()){
    							if(inst.id.equals(pos.get(i).getId().substring(0, 3))){
    								if(num<=Integer.parseInt(pos.get(i).getId().substring(3, 6)))
    									num = Integer.parseInt(pos.get(i).getId().substring(3, 6)) + 1;
    							}
    						}
    					}
    					if(num<10){
    						inst.id = "00"+inst.id;
    					}
    					else if(num<100){
    						inst.id = "0" + inst.id;
    					}
    					resultMessage = institutionMessageMaintenanceDataService.insert(new InstitutionMessagePO(inst));
    				}
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                
                return new ResultMessage(resultMessage.getKey());
        }

        @SuppressWarnings("unchecked")
		@Override
        public ResultMessage delInstitutionMessage(String institutionId) {
                try {//读取所有人员信息
                	ResultMessage resultMessage = this.staffMessageMaintenanceDataService.getStaff();
                    ArrayList<StaffMessagePO> staff = (ArrayList<StaffMessagePO>) resultMessage.getValue();
                	//有人员存在于需要删除的机构中时，不予删除
                	for(int i=0;i<staff.size();i++){
                		if(staff.get(i).getInstitutionid().equals(institutionId)){
                			return new ResultMessage("staffininst");
                		}
                	}
                	
                	resultMessage = institutionMessageMaintenanceDataService.delete(institutionId);
                	return new ResultMessage(resultMessage.getKey());
                        
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
        }

        @Override
        public ResultMessage modInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .update(new InstitutionMessagePO(
                                                        institutionMessage));
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage showInstitutionMessage(String institutionId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .find(institutionId);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                if (resultMessage.getKey().equals("FOUND")) {
                        return new ResultMessage("SUCCESS",
                                        ((InstitutionMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

		@SuppressWarnings("unchecked")
		@Override
		public ResultMessage getInstitutionMessage() {
			try {
				ResultMessage result = this.institutionMessageMaintenanceDataService.get();
				pos = (ArrayList<InstitutionMessagePO>) result.getValue();
				ArrayList<InstitutionMessageVO> vos = new ArrayList<InstitutionMessageVO>();
				
				for(int i=0;i<pos.size();i++){
					vos.add(pos.get(i).poToVo());
				}
				
				return new ResultMessage("SUCCESS", vos);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("FAIL");
			}
		}
}

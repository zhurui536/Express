package bussinesslogic.userbl;

import bussinesslogicservice.userblservice.UserBLService;
import connection.ClientRMIHelper;
import dataservice.userdataservice.AdminDataService;
import po.StaffMessagePO;
import po.UserPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class UserBLServiceImpl implements UserBLService {
	
	private AdminDataService dataservice;
	
	public UserBLServiceImpl(){
		dataservice = (AdminDataService) ClientRMIHelper.getServiceByName("AdminDataServiceImpl");
	}

	@Override
	public ResultMessage login(String id, String password) {
		try {
			ResultMessage result = dataservice.getUser();
			if(result.getKey().equals("success")){
				ArrayList<UserPO> users = (ArrayList<UserPO>) result.getValue();
				//检查用户id是否存在
				for(int i=0;i<users.size();i++){
					//如果存在，则比较密码
					System.out.println(users.get(i).getid()+" "+users.get(i).getPassword());
					if(users.get(i).getid().equals(id)){
						//如果密码正确，则查询员工编号
						if(users.get(i).getPassword().equals(password)){
							result = dataservice.getStaff();
							
							if(result.getKey().equals("success")){
								ArrayList<StaffMessagePO> staff = (ArrayList<StaffMessagePO>) result.getValue();
								
								//如果员工编号存在，则将该编号返回作为之后工作的编号
								for(int j=0;j<staff.size();j++){
									if(staff.get(j).getId().equals(users.get(i).getStaffid())){
										return new ResultMessage("success", staff.get(j).poToVo());
									}
								}
								//否则，返回错误
								return new ResultMessage("nostaffid", null);
							}
							
						}
						else{
							return new ResultMessage("wrong password", null);
						}
					}
				}
				
				return new ResultMessage("nouserid", null);
			}
			else{
				return new ResultMessage(result.getKey(), null);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
}

package bussinesslogic.adminbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import connection.ClientRMIHelper;
import dataservice.userdataservice.AdminDataService;
import po.UserPO;
import util.ResultMessage;
import vo.UserVO;
import bussinesslogicservice.adminblservice.AdminBLService;

public class AdminBL implements AdminBLService {
	private ArrayList<UserPO> users;
	private AdminDataService dataservice;
	
	public AdminBL(){
		dataservice = (AdminDataService) ClientRMIHelper.getServiceByName("AdminDataServiceImpl");
		users = new ArrayList<UserPO>();
	}

	@Override
	public ResultMessage addUser(UserVO user) {
		for(int i=0;i<users.size();i++){
			UserPO temp = users.get(i);
			
			if(temp.getid().equals(user.getUserid())){
				return new ResultMessage("existedid", null);
			}
		}
		
		users.add(new UserPO(user.getUserid(), user.getPassword(), user.getStaffid()));
		return new ResultMessage("success", this.getVO());
	}

	@Override
	public ResultMessage delUser(UserVO user) {
		for(int i=0;i<users.size();i++){
			UserPO temp = users.get(i);
			
			if(temp.getid().equals(user.getUserid())){
				users.remove(i);
				return new ResultMessage("success", this.getVO());
			}
		}
		
		return new ResultMessage("deletedid", this.getVO());
	}

	@Override
	public ResultMessage modifyUser(UserVO user) {
		for(int i=0;i<users.size();i++){
			UserPO temp = users.get(i);
			
			if(temp.getid().equals(user.getUserid())){
				users.remove(i);
				users.add(new UserPO(user.getUserid(), user.getPassword(), user.getStaffid()));
				return new ResultMessage("success", this.getVO());
			}
		}
		
		return new ResultMessage("deletedid", this.getVO());
	}

	@Override
	public ResultMessage getUser() {
		try {
			ResultMessage result = dataservice.getUser();
			if(result.getKey().equals("success")){
				this.users = (ArrayList<UserPO>) result.getValue();
				
				return new ResultMessage("success", this.getVO());
			}
			else{
				return new ResultMessage(result.getKey(), this.getVO());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}
	
	private ArrayList<UserVO> getVO(){
		ArrayList<UserVO> vos = new ArrayList<UserVO>();
		
		for(int i=0;i<users.size();i++){
			vos.add(new UserVO(this.users.get(i)));
		}
		
		return vos;
	}

	@Override
	public ResultMessage end(int condition) {
		if(condition == 0){
			try {
				ResultMessage result = dataservice.saveUser(users);
				if(result.getKey().equals("success")){
					return new ResultMessage("success", null);
				}
				else{
					return result;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error", null);
			}
		}
		else{
			return new ResultMessage("success", null);
		}
	}
}

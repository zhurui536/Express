package bussinesslogic.adminbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import connection.ClientRMIHelper;
import dataservice.userdataservice.AdminDataService;
import po.StaffMessagePO;
import po.UserPO;
import util.ResultMessage;
import vo.UserVO;
import bussinesslogicservice.adminblservice.AdminBLService;

public class AdminBL implements AdminBLService {
	private ArrayList<UserPO> users;
	private ArrayList<StaffMessagePO> staff;
	private AdminDataService dataservice;
	
	public AdminBL(){
		dataservice = (AdminDataService) ClientRMIHelper.getServiceByName("AdminDataServiceImpl");
		users = new ArrayList<UserPO>();
		staff = new ArrayList<StaffMessagePO>();
	}
	
	//创建了这个对象之后必须立即调用的方法
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
	
	@Override
	public ResultMessage addUser(UserVO user) {
		//检查登录账户是否存在，如果已经存在，则返回错误
		for(int i=0;i<users.size();i++){
			UserPO temp = users.get(i);
			
			if(temp.getid().equals(user.getUserid())){
				return new ResultMessage("existeduserid", null);
			}
		}
		//检查员工id是否存在，如果不存在，则返回错误
		try {
			ResultMessage result = dataservice.getStaff();
			
			if(result.getKey().equals("success")){
				staff = (ArrayList<StaffMessagePO>) result.getValue();
				
				for(int i=0;i<staff.size();i++){
					StaffMessagePO temp = staff.get(i);
					//如果员工id存在，则说明账户信息正确，添加账户
					if(temp.getId().equals(user.getStaffid())){
						users.add(new UserPO(user.getUserid(), user.getPassword(), user.getStaffid(), user.getLevel()));
						return new ResultMessage("success", this.getVO());
					}
				}
				//如果不存在，返回错误
				return new ResultMessage("nostaffid", null);
			}
			else{//如果没能成功的读取到员工信息，则进行报错
				return new ResultMessage(result.getKey(), this.getVO());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("internet error", null);
		}
	}

	@Override
	public ResultMessage delUser(UserVO user) {
		for(int i=0;i<users.size();i++){
			UserPO temp = users.get(i);
			//直接遍历当前用户，存在id相同的便删除
			if(temp.getid().equals(user.getUserid())){
				users.remove(i);
				return new ResultMessage("success", this.getVO());
			}
		}
		
		return new ResultMessage("deletedid", this.getVO());
	}

	@Override
	public ResultMessage modifyUser(UserVO user) {
		//依然遍历账户，找到该id
		for(int i=0;i<users.size();i++){
			UserPO temp = users.get(i);
			//如果找到了，就进行先删除再添加的操作
			if(temp.getid().equals(user.getUserid())){
				users.remove(i);
				return this.addUser(user);
			}
		}
		
		return new ResultMessage("deletedid", this.getVO());
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

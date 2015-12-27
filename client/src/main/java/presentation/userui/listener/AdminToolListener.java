package presentation.userui.listener;

import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import presentation.userui.AdminFrame;
import presentation.userui.data.AdminDataPane;
import presentation.userui.inputframe.AdminInputFrame;
import util.AuthorityLevel;
import util.ResultMessage;
import vo.UserVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AdminToolListener extends ToolListener {
	private AdminFrame ui;
	private AdminBLService bl;
	
	public AdminToolListener(AdminFrame ui){
		this.ui = ui;
		this.bl = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MyTool tool = super.getTool();
		
		int i;
		for(i=0;i<tool.getNumOfButton();i++){
			if(tool.getButton(i) == arg0.getSource()){
				break;
			}
		}
		
		if(i==0){
			AdminInputFrame input = new AdminInputFrame(this);
		}
		if(i==1){//取消行为必定成功
			ResultMessage result = bl.end(1);
			
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				ui.replaceTool(null);
				ui.paintdata(null);
			}
		}
		if(i==2){
			ResultMessage result = bl.end(0);
			
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result);
			}
		}
	}
	
	//处理删除信息而留下的方法入口
	public void delete(UserVO vo){
		ResultMessage result = bl.delUser(vo);
		if(result.getKey().equals("success")){
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
		}
		else{
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
			
			WarningDialog warning = new WarningDialog(ui, "id已删除");
		}
	}
	
	//为修改而留下的方法入口
	public void startmidify(UserVO vo){
		AdminInputFrame input = new AdminInputFrame(this, vo);
	}
	
	//为增加而留下的方法入口
	public void startadd(){
		AdminInputFrame input = new AdminInputFrame(this);
	}
	
	//为处理增加用户的输入而加入的方法
	public boolean addInput(String userid, String staffid, String password, AuthorityLevel level){
		UserVO user = new UserVO(userid, staffid, password, level);
		
		ResultMessage result = bl.addUser(user);
		if(result.getKey().equals("success")){
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
			return true;
		}
		else{
			WarningDialog warning  = new WarningDialog(ui, result);
			return false;
		}
	}
	
	//为处理修改用户信息的输入而留下的方法
	public boolean modifyInput(String userid, String staffid, String password, AuthorityLevel level){
		UserVO user = new UserVO(userid, staffid, password, level);
		
		ResultMessage result = bl.modifyUser(user);
		if(result.getKey().equals("success")){
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
			return true;
		}
		else{
			WarningDialog warning  = new WarningDialog(ui, result);
			return false;
		}
	}
}

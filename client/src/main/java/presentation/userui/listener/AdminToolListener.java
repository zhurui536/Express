package presentation.userui.listener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.WarningDialog;
import presentation.adminui.AdminFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import presentation.userui.data.AdminDataPane;
import presentation.userui.inputframe.AdminInputFrame;
import util.AuthorityLevel;
import util.ResultMessage;
import vo.UserVO;

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
		
		if(i==0){//新建用户操作
			new AdminInputFrame(this);
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
		if(i==2){//确定用户修改操作后
			ResultMessage result = bl.end(0);
			
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				if(result.getKey().equals("internet error")){
					new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					new WarningDialog(ui, "数据存储出错！！");
				}
				if(result.getKey().equals("existeduserid")){
					new WarningDialog(ui, "用户id已存在！！");
				}
				if(result.getKey().equals("nostaffid")){
					new WarningDialog(ui, "员工id不存在！！");
				}
			}
		}
	}
	
	//处理删除信息而留下的方法入口
	@SuppressWarnings("unchecked")
	public void delete(UserVO vo){
		ResultMessage result = bl.delUser(vo);
		if(result.getKey().equals("success")){
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
		}
		else{
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
			
			new WarningDialog(ui, "id已删除");
		}
	}
	
	//为修改而留下的方法入口
	public void startmidify(UserVO vo){
		new AdminInputFrame(this, vo);
	}
	
	//为增加而留下的方法入口
	public void startadd(){
		new AdminInputFrame(this);
	}
	
	//为处理增加用户的输入而加入的方法
	@SuppressWarnings("unchecked")
	public boolean addInput(String userid, String staffid, String password, AuthorityLevel level){
		UserVO user = new UserVO(userid, staffid, password, level);
		
		ResultMessage result = bl.addUser(user);
		if(result.getKey().equals("success")){
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
			return true;
		}
		else{
			if(result.getKey().equals("internet error")){
				new WarningDialog(ui, "网络连接出错！！");
			}
			if(result.getKey().equals("dataerror")){
				new WarningDialog(ui, "数据存储出错！！");
			}
			if(result.getKey().equals("existeduserid")){
				new WarningDialog(ui, "用户名已存在！！");
			}
			return false;
		}
	}
	
	//为处理修改用户信息的输入而留下的方法
	@SuppressWarnings("unchecked")
	public boolean modifyInput(String userid, String staffid, String password, AuthorityLevel level){
		UserVO user = new UserVO(userid, staffid, password, level);
		
		ResultMessage result = bl.modifyUser(user);
		if(result.getKey().equals("success")){
			AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), this);
			
			ui.paintdata(data);
			return true;
		}
		else{
			if(result.getKey().equals("internet error")){
				new WarningDialog(ui, "网络连接出错！！");
			}
			if(result.getKey().equals("dataerror")){
				new WarningDialog(ui, "数据存储出错！！");
			}
			if(result.getKey().equals("deletedid")){
				new WarningDialog(ui, "该id已被删除！！");
			}
			return false;
		}
	}
}

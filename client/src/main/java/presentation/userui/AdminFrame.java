package presentation.userui;

import bussinesslogic.adminbl.AdminBL;
import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.mainui.ExpressFrame;
import presentation.userui.listener.AdminMenuListener;

@SuppressWarnings("serial")
public class AdminFrame extends ExpressFrame {
	//处理用例逻辑的对象
	private AdminBLService bl;
	
	private AdminMenuListener menulistener;
	
	public static void main(String[] args){
		
//	        try {
//	            ClientRMIHelper.init();
//	        } catch (ClientInitException e) {
//	            e.printStackTrace();
//	        }
	    
		AdminFrame frame = new AdminFrame();
		frame.setVisible(true);
	}
	
	public AdminFrame(){
		this.menulistener = new AdminMenuListener(this);
		this.setLayout(null);
		this.setSize(1000, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bl = new AdminBL();
		this.paintFrame();
	}
	
	private void paintFrame(){
		this.paintmenu(menubutton, this.menulistener);
		this.painttool();
	}
	
	public AdminBLService getController(){
		return this.bl;
	}
	
	String[] menubutton = {"用户管理", "退出"};
}

package presentation.adminui;

import bussinesslogic.adminbl.AdminBL;
import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.adminui.listener.AdminMenuListener;
import presentation.mainui.ExpressFrame;

@SuppressWarnings("serial")
public class AdminFrame extends ExpressFrame {
	//处理用例逻辑的对象
	private AdminBLService bl;
	
	private AdminMenuListener menulistener;
	
//	public static void main(String[] args){
//		
////	        try {
////	            ClientRMIHelper.init();
////	        } catch (ClientInitException e) {
////	            e.printStackTrace();
////	        }
//	    
//		AdminFrame frame = new AdminFrame();
//		frame.setVisible(true);
//	}
	
	public AdminFrame(){
		this.setLayout(null);
		this.setSize(1000, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bl = new AdminBL();
		this.menulistener = new AdminMenuListener(this);
		this.paintFrame();
	}
	
	private void paintFrame(){
		this.paintmenu(menubutton, this.menulistener);
		this.painttool();
	}
	
	public AdminBLService getController(){
		return bl;
	}
	
	String[] menubutton = {"用户管理", "退出"};
}

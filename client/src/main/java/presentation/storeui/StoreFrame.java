package presentation.storeui;

import bussinesslogic.storebl.StoreBLController;
import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.mainui.ExpressFrame;
import presentation.storeui.listener.StoreMenuListener;


@SuppressWarnings("serial")
public class StoreFrame extends ExpressFrame{
	//处理窗口事件的对象
	private StoreBLService sc;
	
	private StoreMenuListener menulistener;
	
	public StoreFrame(){
		menulistener = new StoreMenuListener(this);
		sc = new StoreBLController();
		this.paintframe();
	}
	
	public static void main(String[] args){
		StoreFrame frame = new StoreFrame();
//		ClientRMIHelper.init();
		frame.setVisible(true);
	}
	
	private void paintframe(){
		paintmenu(names, menulistener);
		painttool();
	}
	
	public void close(){
		this.dispose();
		System.exit(0);
	}
	
	public StoreBLService getController(){
		return this.sc;
	}
	
	private final String[] names = {"入库", "出库", "库存查看", "库存盘点", "库存调整", "审批查看", "退出"};
}

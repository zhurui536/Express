package presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.InStoreDataPane;
import presentation.storeui.inputframe.InStoreInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.storevo.InStoreVO;
import vo.storevo.StorePlaceVO;

public class InStoreToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public InStoreToolListener(StoreFrame ui){
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		MyTool tool = super.getTool();
		
		for(i=0;i<3;i++){
			if(e.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){//点击了新建入库项
			InStoreInputFrame frame = new InStoreInputFrame(this);
			frame.setVisible(true);
		}
		else if(i==1){//点击了确定入库
			ResultMessage result = sc.endInStore(0);
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
			}
		}
		else if(i==2){//点击了取消入库
			ResultMessage result = sc.endInStore(1);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
		}
	}
	
	public boolean getInput(String number, String destination, int[] place){
		StorePlaceVO vo = new StorePlaceVO(place[0], place[1], place[2], place[3]);
		ResultMessage result = sc.addInStoreGoods(number, vo, destination);
		if(result.getKey().equals("success")){
			ui.paintdata(new InStoreDataPane((InStoreVO) result.getValue(), this));
			return true;
		}
		else{
			if(result.getKey().equals("internet error")){
				new WarningDialog(ui, "网络连接出错！！");
			}
			if(result.getKey().equals("dataerror")){
				new WarningDialog(ui, "数据存储出错！！");
			}
			if(result.getKey().equals("usedplace")){
				new WarningDialog(ui, "该位置已被占用！！");
			}
			if(result.getKey().equals("noexist")){
				new WarningDialog(ui, "货物不存在！！");
			}
			if(result.getKey().equals("wrongplace")){
				new WarningDialog(ui, "输入的位置越界啦！！");
			}
			if(result.getKey().equals("inputedid")){
				new WarningDialog(ui, "不能重复输入货物！！");
			}
			return false;
		}
	}
	
	public void delete(String id){
		ResultMessage result = sc.delInStoreGoods(id);
		if(result.getKey().equals("success")){
			ui.paintdata(new InStoreDataPane((InStoreVO) result.getValue(), this));
		}
		else{
			if(result.getKey().equals("noexist")){
				new WarningDialog(ui, "入库项不存在！！");
			}
		}
	}
}

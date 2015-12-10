package presentation.storeui.listener.toollistener;

import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.OutStoreDataPane;
import presentation.storeui.inputframe.OutStoreInputFrame;
import presentation.storeui.listener.ToolListener;
import presentation.storeui.tool.GetButtonOfTool;
import util.ResultMessage;
import util.Trans;
import vo.storevo.OutStoreVO;

import java.awt.event.ActionEvent;

public class OutStoreToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public OutStoreToolListener(StoreFrame ui) {
		this.sc = ui.getController();
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		GetButtonOfTool tool = super.getTool();
		
		for(i=0;i<3;i++){
			if(e.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			OutStoreInputFrame frame = new OutStoreInputFrame(this);
			frame.setVisible(true);
		}
		else if(i==1){
			ResultMessage result = sc.endOutStore(0);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				//提示错误
			}
		}
		else if(i==2){
			sc.endOutStore(1);
			ui.replaceTool(null);
			ui.paintdata(null);
		}
		
	}
	
	public boolean getInput(String number, String destination, Trans trans, String billid){
		ResultMessage result = sc.addOutStoreGoods(number, trans, destination, billid);
		
		if(result.getKey().equals("success")){
			ui.paintdata(new OutStoreDataPane((OutStoreVO) result.getValue(), this));
			return true;
		}
		else{
			return false;
		}
	}
	
	public void delete(String id){
		ResultMessage result = sc.delOutStoreGoods(id);
		
		if(result.getKey().equals("success")){
			ui.paintdata(new OutStoreDataPane((OutStoreVO) result.getValue(), this));
		}
		else{
			ui.paintdata(new OutStoreDataPane((OutStoreVO) result.getValue(), this));
		}
	}
}
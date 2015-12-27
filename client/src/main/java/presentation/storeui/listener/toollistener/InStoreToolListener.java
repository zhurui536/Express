package presentation.storeui.listener.toollistener;

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

import java.awt.event.ActionEvent;

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
		
		if(i==0){
			InStoreInputFrame frame = new InStoreInputFrame(this);
			frame.setVisible(true);
		}
		else if(i==1){
			ResultMessage result = sc.endInStore(0);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				WarningDialog frame = new WarningDialog(ui, result);
			}
		}
		else if(i==2){
			ResultMessage result = sc.endInStore(1);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				WarningDialog frame = new WarningDialog(ui, result);
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
			WarningDialog frame = new WarningDialog(ui, result);
			return false;
		}
	}
	
	public void delete(String id){
		ResultMessage result = sc.delInStoreGoods(id);
		if(result.getKey().equals("success")){
			ui.paintdata(new InStoreDataPane((InStoreVO) result.getValue(), this));
		}
		else{
			WarningDialog frame = new WarningDialog(ui, result);
		}
	}
}

package presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;

import presentation.ToolPane;
import presentation.WarningFrame;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.InStoreDataPane;
import presentation.storeui.inputframe.InStoreInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.storevo.InStoreVO;
import vo.storevo.StorePlaceVO;
import bussinesslogicservice.storeblservice.StoreBLService;

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
		ToolPane tool = super.getTool();
		
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
				WarningFrame frame = new WarningFrame(result);
			}
		}
		else if(i==2){
			ResultMessage result = sc.endInStore(1);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				WarningFrame frame = new WarningFrame(result);
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
			WarningFrame frame = new WarningFrame(result);
			return false;
		}
	}
	
	public void delete(String id){
		ResultMessage result = sc.delInStoreGoods(id);
		if(result.getKey().equals("success")){
			ui.paintdata(new InStoreDataPane((InStoreVO) result.getValue(), this));
		}
		else{
			WarningFrame frame = new WarningFrame(result);
		}
	}
}

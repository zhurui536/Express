package main.presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;

import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;
import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.datapanel.InStoreDataPane;
import main.presentation.storeui.inputframe.InStoreInputFrame;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;
import main.vo.storevo.InStoreVO;
import main.vo.storevo.StorePlaceVO;

public class InStoreToolListener extends ToolListener {

	private StoreBLController sc;
	private StoreFrame ui;
	
	public InStoreToolListener(StoreFrame ui){
		this.ui = ui;
		this.sc = ui.getController();
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
				//提示错误
			}
		}
		else if(i==2){
			ResultMessage result = sc.endInStore(1);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				//提示错误
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
			//提示错误
			return false;
		}
	}
	
	public void delete(String id){
		ResultMessage result = sc.delInStoreGoods(id);
		if(result.getKey().equals("success")){
			ui.paintdata(new InStoreDataPane((InStoreVO) result.getValue(), this));
		}
		else{
			ui.paintdata(new InStoreDataPane((InStoreVO) result.getValue(), this));
		}
	}
}

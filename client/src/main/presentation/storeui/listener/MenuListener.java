package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.ToolMaker;

public class MenuListener implements ActionListener {
	private StoreFrame storeui;
	
	public MenuListener(StoreFrame ui){
		this.storeui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i=0;
		while(true){
			if(e.getSource() == storeui.getButton(i)){
				break;
			}
			else{
				i++;
			}
		}
		
		switch(i){
		case 0:
			System.out.println("instore is clicked!");
			storeui.removeTool();
			storeui.getContentPane().add(ToolMaker.getTool());
			storeui.validate();
			storeui.repaint();
			
			break;
		case 1:
			System.out.println("outstore is clicked!");
			break;
		case 2:
			System.out.println("check is clicked!");
			break;
		case 3:
			System.out.println("verification is clicked!");
			break;
		case 4:
			System.out.println("adjust is clicked!");
			break;
		default:
			System.out.println("exit is clicked!");
			break;
		}
	}

}

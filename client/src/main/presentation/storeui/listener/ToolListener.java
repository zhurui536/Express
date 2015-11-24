package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.tool.GetButtonOfTool;

public class ToolListener implements ActionListener {
	private StoreFrame ui;
	private GetButtonOfTool tool;
	
	public ToolListener(StoreFrame ui){
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getSource());
	}
	
	public void setTool(GetButtonOfTool tool){
		this.tool = tool;
	}
}

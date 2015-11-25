package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.storeui.tool.GetButtonOfTool;

public class ToolListener implements ActionListener {
	private GetButtonOfTool tool;
	
	public ToolListener(){
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
	public void setTool(GetButtonOfTool tool){
		this.tool = tool;
	}
	
	public GetButtonOfTool getTool(){
		return this.tool;
	}
}

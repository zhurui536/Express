package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.storeui.tool.GetButtonOfTool;
//tool部分的父类，由于tool和toollistener互相持有引用，所以添加了此类的设定监听对象的方法
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

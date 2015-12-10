package presentation.storeui.tool;

import javax.swing.JButton;

//为了方便监听而创建的接口，主要监听tool上的按钮事件
public interface GetButtonOfTool {
	//获得按钮的引用
	public JButton getButton(int i);
	//获得按钮的数量
	public int getNumOfButton();
}

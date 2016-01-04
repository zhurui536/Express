package presentation;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.FrameUtil;
import util.MyFont;
import util.ResultMessage;

public class WarningDialog {
	
	private JDialog dialog;
	
	public WarningDialog(JFrame parent, String text) {
		initLocation(parent);
		initComponents(text);
		this.warn();
	}
	
	public WarningDialog(JFrame parent, ResultMessage result) {
		initLocation(parent);
		initComponents(resultToString(result));
		this.warn();
	}
	
	private void warn(){
		dialog.setVisible(true);
	}
	
	private String resultToString(ResultMessage result){
		if(result.getKey().equals("internet error")){
			return "网络连接出错";
		}
		else if(result.getKey().equals("dataerror")){
			return "数据存储出错";
		}
		else if(result.getKey().equals("inputedid")){
			return "货物id重复";
		}
		else if(result.getKey().equals("appearedplace")){
			return "该位置已输入";
		}
		if(result.getKey().equals("emptystart")){
			return "起始位置是空闲的";
		}
		if(result.getKey().equals("usedend")){
			return "目标位置已占用";
		}
		else{
			return result.getKey();
		}
	}

	private void initLocation(JFrame parent) {
		dialog = new JDialog(parent);
		dialog.setLayout(null);
		if (parent == null) {
			dialog.setSize(220, 150);
			FrameUtil.setFrameCenter(dialog);
		} else {
			dialog.setBounds(parent.getX() + parent.getWidth() / 5 * 2, 
					parent.getY() + parent.getHeight() / 3, 220, 150);
			dialog.setModal(true);
		}
	}
	
	private void initComponents(String text) {
		JPanel container = new JPanel();
		container.setBounds(0, 0, 200, 100);
		container.setLayout(null);
		
		JLabel warning = new JLabel(text, JLabel.CENTER);
		warning.setFont(MyFont.getFont1());
		warning.setBounds(0, 0, 200, 100);
		container.add(warning);
		
		dialog.setContentPane(container);
	}
}

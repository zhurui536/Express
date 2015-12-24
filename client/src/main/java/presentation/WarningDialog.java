package presentation;

import util.ResultMessage;

import javax.swing.*;

public class WarningDialog {
	//璀﹀憡绐楀彛锛�2绉掑悗鑷姩娑堝け
	private JDialog dialog;
//	private Thread thread = new Thread(new Runnable(){
//		@Override
//		public void run() {
//			try {
//				Thread.sleep(2000);
//				dialog.dispose();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	});

	public WarningDialog(JFrame parent, String text){
		init(parent);
		
		JPanel container = new JPanel();
		container.setBounds(0, 0, 200, 100);
		container.setLayout(null);
		
		JLabel warning = new JLabel(text, JLabel.CENTER);
		warning.setBounds(0, 0, 200, 100);
		container.add(warning);
		
		dialog.getContentPane().add(container);
		this.warn();
	}
	
	public WarningDialog(JFrame parent, ResultMessage result){
		init(parent);

		String text = this.resultToString(result);
		JPanel container = new JPanel();
		container.setBounds(0, 0, 200, 100);
		container.setLayout(null);
		
		JLabel warning = new JLabel(text, JLabel.CENTER);
		warning.setBounds(0, 0, 200, 100);
		container.add(warning);
		
		dialog.getContentPane().add(container);
		this.warn();
	}
	
	private void warn(){
		dialog.setVisible(true);
//		thread.start();
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

	private void init(JFrame parent) {
		dialog = new JDialog(parent);
		dialog.setLayout(null);
		dialog.setBounds(parent.getX() + 400, parent.getY() + 290, 220, 130);
		dialog.setModal(true);
	}
}

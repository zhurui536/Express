package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ResultMessage;

public class WarningFrame {
	//璀﹀憡绐楀彛锛�2绉掑悗鑷姩娑堝け
	private final JFrame frame;
	private final Thread thread = new Thread(new Runnable(){
		@Override
		public void run() {
			try {
				thread.sleep(2000);
				frame.dispose();
			} catch (InterruptedException e) {
			}
		}
	});
	
	public WarningFrame(String text){
		frame = new JFrame();
		
		frame.setSize(220, 130);
		frame.setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(0, 0, 200, 100);
		container.setLayout(null);
		
		JLabel warning = new JLabel(text, JLabel.CENTER);
		warning.setBounds(0, 0, 200, 100);
		container.add(warning);
		
		frame.getContentPane().add(container);
		this.warn();
	}
	
	public WarningFrame(ResultMessage result){
		String text = this.resultToString(result);
		
		frame = new JFrame();
		
		frame.setSize(220, 130);
		frame.setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(0, 0, 200, 100);
		container.setLayout(null);
		
		JLabel warning = new JLabel(text, JLabel.CENTER);
		warning.setBounds(0, 0, 200, 100);
		container.add(warning);
		
		frame.getContentPane().add(container);
		this.warn();
	}
	
	private void warn(){
		frame.setVisible(true);
		thread.start();
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
}

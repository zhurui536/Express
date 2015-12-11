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
			return "缃戠粶杩炴帴鏂紑锛岃妫�鏌ョ綉缁�";
		}
		else if(result.getKey().equals("dataerror")){
			return "鏁版嵁瀛樺偍鍑洪敊";
		}
		else if(result.getKey().equals("inputedid")){
			return "id宸茶緭鍏�";
		}
		else if(result.getKey().equals("appearedplace")){
			return "璇ヤ綅缃凡杈撳叆";
		}
		if(result.getKey().equals("emptystart")){
			return "璧峰浣嶇疆鏄┖鐨�";
		}
		if(result.getKey().equals("usedend")){
			return "鐩爣浣嶇疆宸插崰鐢�";
		}
		else{
			return "鏈煡閿欒";
		}
	}
}

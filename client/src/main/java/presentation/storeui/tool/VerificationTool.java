package presentation.storeui.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class VerificationTool extends MyTool{
	private JLabel pihao;
	
	public VerificationTool(ToolListener tl){
		super(buttonname, tl);
		
		JLabel batch = new JLabel("批次："+df.format(Calendar.getInstance().getTime()));
		batch.setSize(200, 30);
		batch.setLocation(145, 30);
		this.add(batch);
	}
	
	private static String[] buttonname = {"确定", "返回", "导出表格"};
	
	public void setPihao(int pihao){
		this.pihao = new JLabel("批号："+pihao);
		this.pihao.setSize(120, 60);
		this.pihao.setLocation(145, 30);
		this.add(this.pihao);
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
}

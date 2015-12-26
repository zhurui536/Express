package presentation.strategyui.tool;

import presentation.mainui.ToolPane;
import presentation.strategyui.listener.StrategyToolListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class StrategyTool extends ToolPane {
	
	private StrategyToolListener tl;
	
	public StrategyTool(StrategyToolListener tl){
		super.buttons = new JButton[4];
		this.tl = tl;
		
		this.initialize();
	}
	
	private void initialize(){
		buttons[0] = new JButton("城市距离制定");
		buttons[0].setBounds(300, 20, 120, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("运费制定");
		buttons[1].setBounds(430, 20, 120, 40);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("运费距离查看");
		buttons[2].setBounds(560, 20, 120, 40);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
		
		buttons[3] = new JButton("返回");
		buttons[3].setBounds(720, 20, 80, 40);
		buttons[3].addActionListener(tl);
		this.add(buttons[3]);
	}
}

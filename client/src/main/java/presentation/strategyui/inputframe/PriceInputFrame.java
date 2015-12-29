package presentation.strategyui.inputframe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import presentation.WarningDialog;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import presentation.strategyui.listener.StrategyToolListener;

@SuppressWarnings("serial")
public class PriceInputFrame extends InputFrame implements ActionListener {
	//确定、取消按钮
	private JButton confirm, cancle;
	
	StrategyToolListener tl;
	
	private JTable table;
	
	public static void main(String[] args){
		PriceInputFrame input = new PriceInputFrame(23, null);
		input.setVisible(true);
	}
	
	public PriceInputFrame(double price, StrategyToolListener tl){
		this.tl = tl;
		this.setLayout(null);
		this.setSize(430, 270);
		this.setLocation(400, 250);
		
		this.initialize(price);
	}

	private void initialize(double price) {
		JLabel title = new JLabel("运费价格输入");
		title.setSize(90, 30);
		title.setLocation(170, 10);
		this.getContentPane().add(title);
		
		Object[] header = {"", ""};
		Object[][] rowdata = new Object[3][2];
		rowdata[0][0] = "经济快递价格（元/（公斤*千公里））";
		rowdata[0][1] = price/23*18;
		rowdata[1][0] = "普通快递价格（元/（公斤*千公里））";
		rowdata[1][1] = price;
		rowdata[2][0] = "特快快递价格（元/（公斤*千公里））";
		rowdata[2][1] = price/23*25;
		
		table = new JTable(rowdata, header){
			public boolean isCellEditable(int row, int column) {
				//只允许用户修改普通快递的值
				if(row==1&&column==1){
					return true;
				}
				return false;
			}
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(335, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(230);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		//让其他两个值随着中间的值改变而改变
		table.getModel().addTableModelListener(new TableModelListener(){

			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE){
					try{
						if(e.getColumn() == 1&&e.getFirstRow() == 1){
							String value = (String) table.getValueAt(1, 1);
							double price = Double.parseDouble(value);
							table.setValueAt(price/23*18, 0, 1);
							table.setValueAt(price/23*25, 2, 1);
						}
					}catch(Exception ex){
						table.setValueAt("", 0, 1);
						table.setValueAt("", 2, 1);
					}
				}
				
			}
			
		});
		JPanel panel = new JPanel();
		panel.setBounds(40, 60, 335, 90);
		panel.add(table);
//		JScrollPane panel = new JScrollPane(table);
//		panel.setBounds(40, 60, 335, 100);
		this.getContentPane().add(panel);
		
		
		confirm = new ToolButton(250, 190,"确定");
		cancle = new ToolButton(330, 190,"取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm);
		this.getContentPane().add(cancle);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == cancle){
			this.dispose();
		}
		if(arg0.getSource() == confirm){
			double price;
			try{
				price = Double.parseDouble((String) table.getValueAt(1, 1));
				boolean result = tl.getPriceInput(price);
				if(result){
					this.dispose();
				}
			}catch(Exception e){
				new WarningDialog(null, "输入有误，请重新输入");
				table.setValueAt("", 0, 1);
				table.setValueAt("", 1, 1);
				table.setValueAt("", 2, 1);
			}
		}
	}

}

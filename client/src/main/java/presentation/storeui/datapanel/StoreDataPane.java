package presentation.storeui.datapanel;

import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

import po.GoodsPO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.City;
import util.MyJTable;

@SuppressWarnings("serial")
public class StoreDataPane extends JPanel {
	public StoreDataPane(StorePO store){
		this.setLayout(null);
		this.setSize(810, 2400);
		this.makeTable(store);
	}

	//构建库存状态显示的表格，4个分区分别使用4个表格进行显示
	private void makeTable(StorePO store) {
		//4个分区的合计数额的表格
		String[] column = {"", "1区", "2区", "3区", "4区"};
		String[] list = {"已用库存", "剩余库存", "使用比例"};
		double[][] total = new double[3][4];
		Object[][] totalData = new Object[3][5];
		
		//将数组初始化
		for(int i=0;i<3;i++){
			totalData[i][0] = list[i];
			for(int j=0;j<4;j++){
				total[i][j] = 0;
			}
		}
		
		//对库存使用情况进行统计，之所以不和下面的循环写在一起是为了方便程序阅读
		for(int area=0;area<store.getArea();area++){
			for(int row=0;row<store.getRow();row++){
				for(int shelf=0;shelf<store.getShelf();shelf++){
					for(int place=0;place<store.getPlace();place++){
						StorePlacePO temp = store.getStorePlace(area, row, shelf, place);
						if(temp.getGoods() == null){
							
							total[1][area]++;
						}
						else{
							total[0][area]++;
						}
					}
				}
			}
		}
		
		for(int i=0;i<4;i++){
			total[2][i] = total[0][i]/(total[0][i]+total[1][i]);
			for(int j=0;j<3;j++){
				totalData[j][i+1] = total[j][i];
			}
		}
		
		MyJTable totalTable = new MyJTable(totalData, column);
		totalTable.setWidth(new int[]{160, 160, 160, 160, 160});
		
		//如果有库存超过警戒值，则将该列改为红色
		 DefaultTableCellRenderer backGroundColor = new DefaultTableCellRenderer();
		for(int i=0;i<4;i++){
			if(total[2][i]>0){
				totalTable.getColumnModel().getColumn(i+1).setCellRenderer(backGroundColor);
				backGroundColor.setBackground(Color.RED);
			}
		}
		
		JScrollPane totalscroller = new JScrollPane(totalTable);
		totalscroller.setBounds(0, 0, 810, 150);
		
		this.add(totalscroller);
		
		
		//4个分区的详细使用情况的表格
		Object[] header = {"货物编号", "区号", "排号", "架号", "位号", "入库时间", "目的地"};
		Object[][] rowdata = new Object[store.getRow()*store.getShelf()*store.getPlace()][7];
		
		int i=0;
		for(int area=0;area<store.getArea();area++){
			for(int row=0;row<store.getRow();row++){
				for(int shelf=0;shelf<store.getShelf();shelf++){
					for(int place=0;place<store.getPlace();place++){
						StorePlacePO temp = store.getStorePlace(area, row, shelf, place);
						GoodsPO goods = temp.getGoods();
						
						rowdata[i][1] = area+1;
						rowdata[i][2] = row+1;
						rowdata[i][3] = shelf+1;
						rowdata[i][4] = place+1;
						if(goods == null){
							rowdata[i][0] = "无";
						}
						else{
							rowdata[i][0] = goods.getId();
							rowdata[i][5] = df.format(temp.getDate().getTime());
							rowdata[i][6] = City.cityToString(goods.getDestination());
						}
						
						i++;
					}
				}
			}
			
			MyJTable table = new MyJTable(rowdata, header);
			table.setWidth(new int[]{180, 60, 60, 60, 60, 200, 200});
			
			JScrollPane scroller = new JScrollPane(table);
			scroller.setBounds(0, 510*area + 150, 810, 500);
			
			this.add(scroller);
			
			//下一个循环的初始化
			i=0;
			rowdata = new Object[store.getRow()*store.getShelf()*store.getPlace()][7];
		}
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}

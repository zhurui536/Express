package presentation.storeui.datapanel;

import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import po.GoodsPO;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import util.City;
import util.MyJTable;

@SuppressWarnings("serial")
public class StoreDataPane extends JPanel {
	public StoreDataPane(StorePO store){
		this.setLayout(null);
		this.setSize(810, 500);
		this.makeTable(store);
	}

	private void makeTable(StorePO store) {
		Object[] header = {"货物编号", "区号", "排号", "架号", "位号", "入库时间", "目的地"};
		Object[][] rowdata = new Object[store.getNumOfEmpty()+store.getNumOfEmpty()][7];
		
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
					}
				}
			}
		}
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{130, 50, 50, 50, 50, 200, 200});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}

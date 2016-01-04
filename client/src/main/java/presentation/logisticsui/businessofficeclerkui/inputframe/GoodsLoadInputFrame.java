package presentation.logisticsui.businessofficeclerkui.inputframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.logisticsui.InputChecker;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsLoadToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.BillIDMaker;
import util.PublicMessage;
import util.Time;
import vo.logisticvo.LoadingBillVO;


@SuppressWarnings("serial")
public class GoodsLoadInputFrame extends InputFrame implements ActionListener{

        private GoodsLoadToolListener listener;

        private JButton confirm, cancle;

        private JLabel[][] jLabels;

        private JTextArea[][] jTextAreas;
        
        private JComboBox<String> city, institution;
        
        private JLabel errOutputLabel;

        private final String[] citys = {"南京","北京","上海","广州"};
        
        private final String[] institutions = {"营业厅","中转中心"};

        private static final String[][] nameStrings = {
                        { "汽运编号", "车辆代号"  }, { "监装员", "押运员" } ,{"到达地","订单号"}};
        
        public GoodsLoadInputFrame(GoodsLoadToolListener listener) {
                this.listener = listener;
                this.setName("装车信息输入");
                this.setLayout(null);
                this.setSize(600, 280);
                this.setLocation(350, 150);
                init();
        }
        
        private void init() {
                jLabels = new JLabel[3][2];
                jTextAreas = new JTextArea[3][2];
                for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                                jLabels[i][j] = new JLabel(nameStrings[i][j]);
                                jLabels[i][j].setLocation(15 + j * 290,
                                                15 + i * 50);
                                jLabels[i][j].setSize(75, 35);
                                this.getContentPane().add(jLabels[i][j], 0);
                                jTextAreas[i][j] = new JTextArea();
                                jTextAreas[i][j].setLocation(90 + j * 280,
                                                15 + i * 50);
                                jTextAreas[i][j].setSize(180, 35);

//                                if(i == 2 && j == 0)
//                                        continue;
//                                if(i == 2 && j == 1)
//                                	continue;
                                this.getContentPane().add(jTextAreas[i][j], 0);
                        }
                }
                jTextAreas[0][0].setText(BillIDMaker.getTransferNum());
                		
                city = new JComboBox<String>(citys);
                city.setBounds(90, 115, 80, 35);
                this.getContentPane().add(city, 0);
                
                institution = new JComboBox<String>(institutions);
                institution.setBounds(180, 115, 80, 35);
                this.getContentPane().add(institution, 0);
                
                confirm = new ToolButton(250, 220,"确定");
                cancle = new ToolButton(330, 220,"取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm, 0);
                this.getContentPane().add(cancle, 0);
                
                errOutputLabel = new JLabel();
                errOutputLabel.setBounds(15, 220, 190, 30);
                errOutputLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutputLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutputLabel, 0);
                
        }

        public static void main(String[] args) {
                GoodsLoadInputFrame goodsLoadInputFrame = new GoodsLoadInputFrame(null);
                goodsLoadInputFrame.setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        LoadingBillVO loadingBillVO = new LoadingBillVO();
                        loadingBillVO.date = new Time();
                        loadingBillVO.institution = PublicMessage.institutionID;
//                        if(!InputChecker.isNum(jTextAreas[0][0].getText())){
//                                errOutputLabel.setText("汽运编号必须是数字！");
//                                return;
//                        }
                        loadingBillVO.transferNum = jTextAreas[0][0].getText();
                        if(!InputChecker.isNum(jTextAreas[0][1].getText())){
                                errOutputLabel.setText("车辆代号必须是数字！");
                                return;
                        }
                        loadingBillVO.numOfTruck = jTextAreas[0][1].getText();
                        loadingBillVO.arrivalPlace = (String)city.getSelectedItem() + (String)institution.getSelectedItem();
                        loadingBillVO.supervisor = jTextAreas[1][0].getText();
                        loadingBillVO.supercargo = jTextAreas[1][1].getText();
                        loadingBillVO.ids = new ArrayList<>();
//                        for (String id :jTextAreas[2][1].getText().split(",")) {
//                                loadingBillVO.ids.add(id);
//                        }
                        boolean result = listener.getInput(loadingBillVO);
                        if(result){
                                this.setVisible(false);
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

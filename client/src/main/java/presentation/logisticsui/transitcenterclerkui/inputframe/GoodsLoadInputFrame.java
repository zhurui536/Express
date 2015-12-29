package presentation.logisticsui.transitcenterclerkui.inputframe;

import presentation.logisticsui.InputChecker;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsLoadToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.PublicMessage;
import util.Time;
import vo.logisticvo.LoadingBillVO;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



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
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 2; j++) {
                                jLabels[i][j] = new JLabel(nameStrings[i][j]);
                                jLabels[i][j].setLocation(15 + j * 290,
                                                15 + i * 50);
                                jLabels[i][j].setSize(75, 35);
                                this.getContentPane().add(jLabels[i][j]);
                                jTextAreas[i][j] = new JTextArea();
                                jTextAreas[i][j].setLocation(90 + j * 280,
                                                15 + i * 50);
                                jTextAreas[i][j].setSize(180, 35);
                                if(i == 2 && j == 0)
                                        continue;
                                this.getContentPane().add(jTextAreas[i][j]);
                        }
                }
                
                city = new JComboBox<String>(citys);
                city.setBounds(90, 115, 80, 35);
                this.getContentPane().add(city);
                
                institution = new JComboBox<String>(institutions);
                institution.setBounds(180, 115, 80, 35);
                this.getContentPane().add(institution);
                
                confirm = new ToolButton(250, 220,"确定");
                cancle = new ToolButton(330, 220,"取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
                errOutputLabel = new JLabel();
                errOutputLabel.setBounds(15, 220, 190, 30);
                errOutputLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutputLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutputLabel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        LoadingBillVO loadingBillVO = new LoadingBillVO();
                        loadingBillVO.date = new Time();
                        loadingBillVO.institution = PublicMessage.institutionID;
                        if(!InputChecker.isNum(jTextAreas[0][0].getText())){
                                errOutputLabel.setText("汽运编号必须是数字！");
                                return;
                        }
                        loadingBillVO.transferNum = jTextAreas[0][0].getText();
                        if(!InputChecker.isNum(jTextAreas[0][1].getText())){
                                errOutputLabel.setText("车辆代号必须是数字！");
                                return;
                        }
                        loadingBillVO.numOfTruck = jTextAreas[0][1].getText();
                        loadingBillVO.arrivalPlace = (String)city.getSelectedItem() + (String)institution.getSelectedItem();
                        loadingBillVO.supervisor = jTextAreas[1][0].getText();
                        loadingBillVO.supercargo = jTextAreas[1][1].getText();
                        if(jTextAreas[2][0].getText().equals("")){
                                errOutputLabel.setText("请输入" + jLabels[2][0].getText());
                                return;
                        }
                        loadingBillVO.ids = new ArrayList<>();
                        for (String id :jTextAreas[2][0].getText().split(",")) {
                                loadingBillVO.ids.add(id);
                        }
                        boolean result = listener.getInput(loadingBillVO);
                        if(result){
                                this.setVisible(false);
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

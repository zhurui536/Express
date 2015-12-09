package main.presentation.logisticsui.transitcenterclerkui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.bussinesslogic.util.PublicMessage;
import main.bussinesslogic.util.Time;
import main.presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsLoadToolListener;
import main.vo.logisticvo.LoadingBillVO;

@SuppressWarnings("serial")
public class GoodsLoadInputFrame extends JFrame implements ActionListener{

        private GoodsLoadToolListener listener;

        private JButton confirm, cancle;

        private JLabel[][] jLabels;

        private JTextArea[][] jTextAreas;

        private JComboBox<String> year, month, day;

        private static final String[][] nameStrings = {
                        { "汽运编号", "车辆代号", "到达地" }, { "监装员", "押运员", "订单号" } };
        
        public GoodsLoadInputFrame(GoodsLoadToolListener listener) {
                this.listener = listener;
                this.setName("装车信息输入");
                this.setLayout(null);
                this.setSize(600, 280);
                this.setLocation(350, 150);
                init();
        }
        
        private void init() {
                jLabels = new JLabel[3][3];
                jTextAreas = new JTextArea[3][3];
                for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 3; j++) {
                                if (nameStrings[i][j] == null)
                                        continue;
                                jLabels[i][j] = new JLabel(nameStrings[i][j]);
                                jLabels[i][j].setLocation(15 + j * 200,
                                                15 + i * 50);
                                jLabels[i][j].setSize(75, 35);
                                this.getContentPane().add(jLabels[i][j]);
                                jTextAreas[i][j] = new JTextArea();
                                jTextAreas[i][j].setLocation(90 + j * 190,
                                                15 + i * 50);
                                jTextAreas[i][j].setSize(100, 35);
                                this.getContentPane().add(jTextAreas[i][j]);
                        }
                }
                
                year = new JComboBox<>();
                for (int i = 2000; i <= 2020; i++) {
                    year.addItem(i + "年");
                }
                year.setBounds(15, 170, 120, 30);
                this.getContentPane().add(year);
                
                month = new JComboBox<>();
                for (int i = 1; i <= 12; i++) {
                        String s = i  < 10 ? "0" : "";
                        month.addItem(s + i + "月");
                }
                month.setBounds(185, 170, 60, 30);
                this.getContentPane().add(month);
                
                day = new JComboBox<>();
                for (int i = 1; i <= 31; i++) {
                        String s = i  < 10 ? "0" : "";
                        day.addItem(s + i + "日");
                }
                day.setBounds(295, 170, 60, 30);
                this.getContentPane().add(day);
                
                confirm = new JButton("确定");
                cancle = new JButton("取消");
                confirm.setSize(60, 25);
                cancle.setSize(60, 25);
                confirm.setLocation(250, 220);
                cancle.setLocation(330, 220);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
                
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        LoadingBillVO loadingBillVO = new LoadingBillVO();
                        loadingBillVO.date = new Time(((String)year.getSelectedItem()).substring(0,4) + "-" 
                                        + ((String)month.getSelectedItem()).substring(0,2) + "-" 
                                        + ((String)day.getSelectedItem()).substring(0, 2));
                        loadingBillVO.institution = PublicMessage.institutionID;
                        loadingBillVO.transferNum = jTextAreas[0][0].getText();
                        loadingBillVO.numOfTruck = jTextAreas[0][1].getText();
                        loadingBillVO.arrivalPlace = jTextAreas[0][2].getText();
                        loadingBillVO.supervisor = jTextAreas[1][0].getText();
                        loadingBillVO.supercargo = jTextAreas[1][1].getText();
                        loadingBillVO.ids = new ArrayList<>();
                        for (String id :jTextAreas[1][2].getText().split(",")) {
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

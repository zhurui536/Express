package presentation.logisticsui.deliverymanui.inputframe;


import presentation.logisticsui.deliverymanui.listener.toollistener.ReceivingToolListener;
import util.City;
import util.ExpressType;
import util.GoodsDeliveryState;
import util.PackageType;
import util.Time;
import vo.GoodsVO;
import vo.logisticvo.PeopleMessageVO;
import vo.logisticvo.SendBillVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ReceivingInputFrame extends JFrame implements ActionListener{
        
        private ReceivingToolListener listener;
        
        private JButton confirm, cancle;
        
        private JTextArea number;
        
        private JLabel numberLabel;
        
        private goodsPanel panelForGoods;
        
        private peoplePanel panelForSender;
        
        private peoplePanel panelForRec;
        
        public ReceivingInputFrame(ReceivingToolListener listener) {
                this.listener = listener;
                this.setName("快递单号输入");
                this.setLayout(null);
                this.setSize(590, 550);
                this.setLocation(350, 150);
                init();
        }
        
        private void init() {
                JPanel aJPanel = new JPanel();
                aJPanel.setLayout(null);
                this.setContentPane(aJPanel);
                
                numberLabel = new JLabel("订单号：");
                numberLabel.setSize(70,35);
                numberLabel.setLocation(15,15);
                this.getContentPane().add(numberLabel);
                
                number = new JTextArea();
                number.setLocation(65,25);
                number.setSize(100,15);
                this.getContentPane().add(number);
                
                
                panelForGoods = new goodsPanel();
                panelForGoods.setLayout(null);
                panelForGoods.setSize(580,165);
                panelForGoods.setLocation(15,45);
                
                this.add(panelForGoods);
                
                panelForSender = new peoplePanel("寄件人");
                panelForSender.setLocation(15,220);
                panelForSender.setSize(510,115);
                this.getContentPane().add(panelForSender);
                
                panelForRec = new peoplePanel("收件人");
                panelForRec.setLocation(15,350);
                panelForRec.setSize(510,115);
                this.getContentPane().add(panelForRec);
                
                confirm = new JButton("确定");
                cancle = new JButton("取消");
                confirm.setSize(60,35);
                confirm.setLocation(385,465);
                cancle.setSize(60,35);
                cancle.setLocation(465,465);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm);
                this.getContentPane().add(cancle);
        }
        
        class goodsPanel extends JPanel{
                JLabel[][] labels = new JLabel[3][3];
                JTextArea[] textAreas = new JTextArea[3];
                final String[][] nameStrings = { { "名称：", "出发地：", "目的地：" },
                                { "重量：", "体积：", null },
                                { "包装：", "快递方式：", null} };
                final String[] citys = {"南京","北京","上海","广州"};
                JComboBox<String> startPlace = new JComboBox<String>(citys);
                JComboBox<String> endPlace = new JComboBox<String>(citys);
                final String[] stringsP = {"纸箱", "木箱", "快递袋"};
                JComboBox<String> packageTypeBox = new JComboBox<String>(stringsP);
                final String[] stringsE = {"普通", "经济", "特快"};
                JComboBox<String> expressTypeBox = new JComboBox<>(stringsE);
                public goodsPanel() {
                        this.setSize(520,165);
                        for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                        if(nameStrings[i][j] == null)
                                                continue;
                                        labels[i][j] = new JLabel(nameStrings[i][j]);
                                        labels[i][j].setLocation(15 + j * 175, 15 + i * 50);
                                        labels[i][j].setSize(70,35);
                                        this.add(labels[i][j]);
                                }
                        }
                        textAreas[0] = new JTextArea();
                        textAreas[0].setBounds(65,15,100,35);
                        this.add(textAreas[0]);
                        
                        textAreas[1] = new JTextArea();
                        textAreas[1].setBounds(65, 65, 100, 35);
                        this.add(textAreas[1]);
                        
                        textAreas[2] = new JTextArea();
                        textAreas[2].setBounds(250,65,100,35);
                        this.add(textAreas[2]);
                        
                        startPlace.setBounds(250,15,100, 30);
                        this.add(startPlace);
                        
                        endPlace.setBounds(415,15,100,30);
                        this.add(endPlace);
                        
                        packageTypeBox.setBounds(65, 115, 100, 30);
                        this.add(packageTypeBox);
                       
                        expressTypeBox.setBounds(65 + 185, 115, 100, 30);
                        this.add(expressTypeBox);
                        
                }
                
                GoodsVO getInput(){
                        GoodsVO goodsVO = new GoodsVO();
                        goodsVO.name = textAreas[0].getText();
                        goodsVO.departurePlace =  City.stringToType((String)startPlace.getSelectedItem());
                        goodsVO.destination =City.stringToType((String)endPlace.getSelectedItem());
                        
                        double w = Double.parseDouble(textAreas[1].getText());
                        if(w > 0)
                                goodsVO.weight = w;
                        double v = Double.parseDouble(textAreas[2].getText());
                        if(v > 0)
                                goodsVO.volume = v;
                        
                        goodsVO.packageType = PackageType.stringToType((String)packageTypeBox.getSelectedItem());
                        goodsVO.expressType = ExpressType.stringToType((String)expressTypeBox.getSelectedItem());
                        goodsVO.goodsDeliveryState = GoodsDeliveryState.TRANSPORT;
                        goodsVO.startTime = new Time();
                        return goodsVO;
                }
        }
        
        class peoplePanel extends JPanel{
                JLabel name;
                
                JTextArea nameArea;
                
                JLabel location;
                
                JTextArea locationArea;
                
                JLabel institution;
                
                JTextArea insArea;
                
                JLabel telephoneNum;
                
                JTextArea telArea;
                
                JLabel mobliephoneNum;
                
                JTextArea mobArea;
                
                peoplePanel(String people){
                       
                        this.setLayout(null);
                         name = new JLabel(people + ":");
                        name.setSize(80,35);
                        name.setLocation(5,15);
                        this.add(name);
                         nameArea = new JTextArea();
                        nameArea.setSize(100,35);
                        nameArea.setLocation(65,15);
                        this.add(nameArea);
                        
                         location = new JLabel("住址：" );
                        location.setSize(50,35);
                        location.setLocation(200,15);
                        this.add(location);
                         locationArea = new JTextArea();
                        locationArea.setSize(100,35);
                        locationArea.setLocation(250,15);
                        this.add(locationArea);
                        
                         institution = new JLabel("单位：" );
                        institution.setSize(50,35);
                        institution.setLocation(15,65);
                        this.add(institution);
                         insArea = new JTextArea();
                        insArea.setSize(100,35);
                        insArea.setLocation(65,65);
                        this.add(insArea);
                        
                         telephoneNum = new JLabel("电话：");
                        telephoneNum.setSize(50,35);
                        telephoneNum.setLocation(200,65);
                        this.add(telephoneNum);
                         telArea = new JTextArea();
                        telArea.setSize(100,35);
                        telArea.setLocation(250,65);
                        this.add(telArea);
                        
                         mobliephoneNum = new JLabel("手机：" );
                        mobliephoneNum.setSize(50, 35);
                        mobliephoneNum.setLocation(365,65);
                        this.add(mobliephoneNum);
                         mobArea = new JTextArea();
                        mobArea.setSize(100,35);
                        mobArea.setLocation(415,65);
                        this.add(mobArea);
                }
                
                PeopleMessageVO getInput(){
                        PeopleMessageVO peopleMessageVO = new PeopleMessageVO();
                        peopleMessageVO.institution = insArea.getText();
                        peopleMessageVO.location = locationArea.getText();
                        peopleMessageVO.mobliephoneNum = mobArea.getText();
                        peopleMessageVO.name = nameArea.getText();
                        peopleMessageVO.telephoneNum = telArea.getText();
                        return peopleMessageVO;
                }
        }
        
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        SendBillVO sendBillVO = new SendBillVO();
                        sendBillVO.goodsVO = panelForGoods.getInput();
                        sendBillVO.senderVO = panelForSender.getInput();
                        sendBillVO.recipientVO = panelForRec.getInput();
                        sendBillVO.id = number.getText();

                        boolean result = listener.getInput(sendBillVO);
                        if(result){
                                this.setVisible(false);
                        }
                        else{
                                //TODO
                        }
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

package presentation.logisticsui.deliverymanui.inputframe;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.logisticsui.InputChecker;
import presentation.logisticsui.deliverymanui.listener.toollistener.ReceivingToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.City;
import util.ExpressType;
import util.GoodsDeliveryState;
import util.PackageType;
import util.ResultMessage;
import util.Time;
import vo.GoodsVO;
import vo.logisticvo.PeopleMessageVO;
import vo.logisticvo.SendBillVO;

@SuppressWarnings("serial")
public class ReceivingInputFrame extends InputFrame implements ActionListener{
        
        private ReceivingToolListener listener;
        
        private JButton confirm, cancle;
        
        private JTextArea number;
        
        private JLabel numberLabel;
        
        private goodsPanel panelForGoods;
        
        private peoplePanel panelForSender;
        
        private peoplePanel panelForRec;
        
        private JLabel errOutPutLabel;
        
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
                this.getContentPane().add(numberLabel, 0);
                
                number = new JTextArea();
                number.setLocation(65,15);
                number.setSize(100,25);
                this.getContentPane().add(number, 0);
                
                
                panelForGoods = new goodsPanel();
                panelForGoods.setLayout(null);
                panelForGoods.setSize(580,165);
                panelForGoods.setLocation(15,45);
                
                this.getContentPane().add(panelForGoods, 0);
                
                panelForSender = new peoplePanel("寄件人");
                panelForSender.setLocation(15,220);
                panelForSender.setSize(510,115);
                this.getContentPane().add(panelForSender, 0);
                
                panelForRec = new peoplePanel("收件人");
                panelForRec.setLocation(15,350);
                panelForRec.setSize(510,115);
                this.getContentPane().add(panelForRec);
                
                confirm = new ToolButton(385,465,"确定");
                cancle = new ToolButton(465,465,"取消");
                confirm.setSize(60,35);
                cancle.setSize(60,35);
                confirm.addActionListener(this);
                cancle.addActionListener(this);
                this.getContentPane().add(confirm, 0);
                this.getContentPane().add(cancle, 0);
                
                errOutPutLabel = new JLabel();
                errOutPutLabel.setBounds(325, 15, 240, 30);
                errOutPutLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
                errOutPutLabel.setForeground(Color.RED);
                this.getContentPane().add(errOutPutLabel, 0);
                
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
                                        this.add(labels[i][j], 0);
                                }
                        }
                        textAreas[0] = new JTextArea();
                        textAreas[0].setBounds(65,15,100,35);
                        this.add(textAreas[0], 0);
                        
                        textAreas[1] = new JTextArea();
                        textAreas[1].setBounds(65, 65, 100, 35);
                        this.add(textAreas[1], 0);
                        
                        textAreas[2] = new JTextArea();
                        textAreas[2].setBounds(250,65,100,35);
                        this.add(textAreas[2], 0);
                        
                        startPlace.setBounds(250,15,100, 30);
                        this.add(startPlace, 0);
                        
                        endPlace.setBounds(415,15,100,30);
                        this.add(endPlace, 0);
                        
                        packageTypeBox.setBounds(65, 115, 100, 30);
                        this.add(packageTypeBox, 0);
                       
                        expressTypeBox.setBounds(65 + 185, 115, 100, 30);
                        this.add(expressTypeBox, 0);
                        
                }
                
                ResultMessage getInput(){
                        GoodsVO goodsVO = new GoodsVO();
                        goodsVO.id = number.getText();
                        goodsVO.name = textAreas[0].getText();
                        goodsVO.departurePlace =  City.stringToType((String)startPlace.getSelectedItem());
                        goodsVO.destination =City.stringToType((String)endPlace.getSelectedItem());
                        
                        if(!InputChecker.isNum(textAreas[1].getText())||InputChecker.isMinus(textAreas[1].getText())){
                                return new ResultMessage("重量必须是正数！");
                        }
                        goodsVO.weight = Double.parseDouble(textAreas[1].getText());
                        if(!InputChecker.isNum(textAreas[2].getText())||InputChecker.isMinus(textAreas[2].getText())){
                                return new ResultMessage("体积必须是正数！");
                        }
                        goodsVO.volume = Double.parseDouble(textAreas[2].getText());
                        
                        goodsVO.packageType = PackageType.stringToType((String)packageTypeBox.getSelectedItem());
                        goodsVO.expressType = ExpressType.stringToType((String)expressTypeBox.getSelectedItem());
                        goodsVO.goodsDeliveryState = GoodsDeliveryState.TRANSPORT;
                        goodsVO.startTime = new Time();
                        return new ResultMessage("success",goodsVO);
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
                
                String peopleString;
                
                peoplePanel(String people){
                       
                        this.peopleString = people;
                        
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
                
                ResultMessage getInput(){
                        PeopleMessageVO peopleMessageVO = new PeopleMessageVO();
                        peopleMessageVO.institution = insArea.getText();
                        peopleMessageVO.location = locationArea.getText();
                        if(!InputChecker.isNum(mobArea.getText()))
                                return new ResultMessage(peopleString + "手机号必须是纯数字！");
                        peopleMessageVO.mobliephoneNum = mobArea.getText();
                        peopleMessageVO.name = nameArea.getText();
                        if(!InputChecker.isNum(telArea.getText()))
                                return new ResultMessage(peopleString + "电话号码必须是纯数字！");
                        peopleMessageVO.telephoneNum = telArea.getText();
                        return new ResultMessage("success",peopleMessageVO);
                }
        }
        
        public static void main(String[] args) {
                ReceivingInputFrame receivingInputFrame = new ReceivingInputFrame(null);
                receivingInputFrame.setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                        SendBillVO sendBillVO = new SendBillVO();
                        if(!InputChecker.isNum(number.getText())){
                                errOutPutLabel.setText("订单号必须是数字！");
                                return;
                        }
                        sendBillVO.id = number.getText();
                        //检查货物信息的输入
                        ResultMessage goodsInputMes = panelForGoods.getInput();
                        if(!goodsInputMes.getKey().equals("success")){
                                errOutPutLabel.setText(goodsInputMes.getKey());
                                return;
                        }
                        sendBillVO.goodsVO = (GoodsVO) goodsInputMes.getValue();
                        //检查寄件人和收件人信息的输入
                        ResultMessage senderInputMes = panelForSender.getInput();
                        if(!senderInputMes.getKey().equals("success")){
                                errOutPutLabel.setText(senderInputMes.getKey());
                                return;
                        }
                        sendBillVO.senderVO = (PeopleMessageVO) senderInputMes.getValue();
                        ResultMessage recipientInputMes = panelForRec.getInput();
                        if(!recipientInputMes.getKey().equals("success")){
                                errOutPutLabel.setText(recipientInputMes.getKey());
                                return;
                        }
                        sendBillVO.recipientVO = (PeopleMessageVO) recipientInputMes.getValue();
                        listener.getInput(sendBillVO);
                        this.setVisible(false);
                }else if(e.getSource() == cancle){
                        this.setVisible(false);
                }
        }

}

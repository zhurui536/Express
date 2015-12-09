package main.presentation.logisticsui.deliverymanui.datapane;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.bussinesslogic.util.*;
import main.vo.GoodsVO;
import main.vo.logisticvo.PeopleMessageVO;
import main.vo.logisticvo.SendBillVO;

@SuppressWarnings("serial")
public class ReceivingDataPane extends JPanel{
        
        private JLabel number;
        
        private JPanel panelForSender;
        
        private JPanel panelForRec;
        
        private JPanel panelForGoods;
        
        private JLabel time;

        public ReceivingDataPane(SendBillVO sendBillVO, long time) {
                this.setSize(810,700);
                init(sendBillVO,time);
        }
        
        private void init(SendBillVO sendBillVO, long time){
                number = new JLabel("条形码号：" + sendBillVO.id);
                number.setSize(200,35);
                number.setLocation(15,15);
                this.add(number);
                
                panelForGoods = panelForGoodsVO(sendBillVO.goodsVO);
                panelForGoods.setLocation(15,65);
                this.add(panelForGoods);
                
                panelForSender = makeFromPeopleVO("寄件人信息：", sendBillVO.senderVO);
                panelForSender.setLocation(15,245);
                this.add(panelForSender);
                
                panelForRec = makeFromPeopleVO("收件人信息：", sendBillVO.recipientVO);
                panelForRec.setLocation(15,445);
                this.add(panelForRec);
                
                this.time = new JLabel("预计用时：" + time + "天");
                this.time.setSize(200,35);
                this.time.setLocation(15,645);
                this.add(this.time);
        }
        
        private JPanel panelForGoodsVO(GoodsVO goodsVO){
                JPanel panel = new JPanel();
                panel.setSize(810, 165);
                panel.setLayout(null);
                
                JLabel title = new JLabel("货物信息");
                title.setSize(250,35);
                title.setLocation(15,15);
                panel.add(title);
                
                String[][] nameStrings = {{"名称：" + goodsVO.name, "出发地：" + goodsVO.departurePlace, "目的地：" + goodsVO.destination},
                                {"重量：" + goodsVO.weight, "体积：" + goodsVO.volume , "运费：" + goodsVO.price},
                                {"包装：" + PackageType.typeToString(goodsVO.packageType), 
                                        "快递方式：" + ExpressType.typeToString(goodsVO.expressType),
                                        "运转状态：" + GoodsDeliveryState.typeToString(goodsVO.goodsDeliveryState)}};
                
                JLabel[][] labels = new JLabel[3][3];
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                                labels[i][j] = new JLabel(nameStrings[i][j]);
                                labels[i][j].setSize(250,35);
                                labels[i][j].setLocation(15 + 265 * j, 65 + 50 * i);
                                panel.add(labels[i][j]);
                        }
                }
                
                return panel;
        }
        
        private JPanel makeFromPeopleVO(String title,PeopleMessageVO vo){
                JPanel panel = new JPanel();
                panel.setSize(810, 165);
                panel.setLayout(null);
                
                JLabel titleLabel = new JLabel(title);
                titleLabel.setSize(200,35);
                titleLabel.setLocation(15,15);
                panel.add(titleLabel);
                
                JLabel name = new JLabel("姓名："  + vo.name);
                name.setSize(200,35);
                name.setLocation(15,65);
                panel.add(name);
                
                JLabel location = new JLabel("住址：" + vo.location);
                location.setSize(565,35);
                location.setLocation(230,65);
                panel.add(location);
                
                JLabel institution = new JLabel("单位："  + vo.institution);
                institution.setSize(200,35);
                institution.setLocation(15,115);
                panel.add(institution);
                
                JLabel telephoneNum = new JLabel("电话：" + vo.telephoneNum);
                telephoneNum.setSize(265,35);
                telephoneNum.setLocation(230,115);
                panel.add(telephoneNum);
                
                JLabel mobliephoneNum = new JLabel("手机：" + vo.mobliephoneNum);
                mobliephoneNum.setSize(265, 35);
                mobliephoneNum.setLocation(495,115);
                panel.add(mobliephoneNum);
                
                return panel;
        }
}

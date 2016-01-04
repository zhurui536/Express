package presentation.logisticsui.deliverymanui.datapane;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ExpressType;
import util.GoodsDeliveryState;
import util.PackageType;
import vo.GoodsVO;
import vo.logisticvo.PeopleMessageVO;
import vo.logisticvo.SendBillVO;


@SuppressWarnings("serial")
public class BillQueryDataPane extends JPanel {

        private JLabel number;
        
        private JPanel panelForSender;
        
        private JPanel panelForRec;
        
        private JPanel panelForGoods;
        
        public BillQueryDataPane(SendBillVO sendBillVO) {
                this.setLayout(null);
                this.setSize(810,650);
                init(sendBillVO);
        }
        
        private void init(SendBillVO sendBillVO){
                number = new JLabel("条形码号：" + sendBillVO.id);
                number.setSize(200,35);
                number.setLocation(15,15);
                number.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(number);
                
                panelForGoods = panelForGoodsVO(sendBillVO.goodsVO);
                panelForGoods.setLocation(15,65);
                panelForGoods.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(panelForGoods);
                
                panelForSender = makeFromPeopleVO("寄件人信息：", sendBillVO.senderVO);
                panelForSender.setLocation(15,245);
                panelForSender.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(panelForSender);
                
                panelForRec = makeFromPeopleVO("收件人信息：", sendBillVO.recipientVO);
                panelForRec.setLocation(15,445);
                panelForRec.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(panelForRec);
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

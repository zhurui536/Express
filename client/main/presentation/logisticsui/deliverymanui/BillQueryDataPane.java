package main.presentation.logisticsui.deliverymanui;


import javax.swing.JLabel;
import javax.swing.JPanel;

import main.vo.logisticvo.PeopleMessageVO;
import main.vo.logisticvo.SendBillVO;


@SuppressWarnings("serial")
public class BillQueryDataPane extends JPanel {

        private JLabel number;
        
        private JPanel panelForSender;
        
        private JPanel panelForRec;
        
        private JPanel panelForGoods;
        
        public BillQueryDataPane(SendBillVO sendBillVO) {
                
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

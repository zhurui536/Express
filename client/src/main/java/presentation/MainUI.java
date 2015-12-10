package presentation;

import bussinesslogic.logisticsbl.LogisticsBLController;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import connection.ClientInitException;
import connection.ClientRMIHelper;
import presentation.financeui.FinanceFrame;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.managerui.ManagerFrame;
import presentation.storeui.StoreFrame;
import util.PublicMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/10/26
 */

@SuppressWarnings("serial")
public class MainUI extends JFrame implements ActionListener{
    private JTextArea id;
    private JPasswordField password;
    private JButton confirm;
    private JButton exit;

    public static String USER_ID;

    public static void main(String[] args){
        MainUI ui = new MainUI();
        ui.setVisible(true);
    }

    public MainUI(){
        this.setLayout(null);
        this.setBounds(300, 300, 330, 260);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initRMI();
        this.initialize();
    }

    private void initRMI() {
        try {
            ClientRMIHelper.init();
        } catch (ClientInitException e) {
            e.printStackTrace();
        }
    }

    private void initialize(){
        JLabel title = new JLabel("用户登录");
        title.setBounds(120, 10, 100, 35);
        this.getContentPane().add(title);

        JLabel id = new JLabel("用户ID");
        id.setBounds(20, 50, 50, 40);
        this.getContentPane().add(id);

        JLabel password = new JLabel("密码");
        password.setBounds(20, 100, 50, 40);
        this.getContentPane().add(password);

        this.id = new JTextArea();
        this.id.setBounds(90, 50, 200, 40);
        this.getContentPane().add(this.id);

        this.password = new JPasswordField();
        this.password.setBounds(90, 100, 200, 40);
        this.getContentPane().add(this.password);

        confirm = new JButton("确定");
        confirm.setBounds(40, 160, 80, 30);
        confirm.addActionListener(this);
        this.getContentPane().add(confirm);

        exit = new JButton("退出");
        exit.setBounds(150, 160, 80, 30);
        exit.addActionListener(this);
        this.getContentPane().add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            this.setVisible(false);
            System.exit(0);
        }
        if(e.getSource() == confirm){
            //           try{
            String id = this.id.getText();
            if(id.charAt(0) == '0'){
                this.setVisible(false);
                StoreFrame frame = new StoreFrame();
                frame.setVisible(true);
            }
            else if(id.charAt(0) == '1'){
                this.setVisible(false);
                ManagerFrame frame = new ManagerFrame();
                frame.setVisible(true);
            } else if (id.charAt(0) == '2'){
                this.setVisible(false);
                FinanceFrame frame = new FinanceFrame();
                frame.setVisible(true);
            } else if (id.charAt(0) == '3') {
                LogisticsBLService logisticsBLService = new LogisticsBLController();
                this.setVisible(false);
                DeliveryManFrame frame = new DeliveryManFrame(logisticsBLService);
                frame.setVisible(true);
            } else if (id.charAt(0) == '4') {
                LogisticsBLService logisticsBLService = new LogisticsBLController();
                this.setVisible(false);
                TransitCenterclerkFrame frame = new TransitCenterclerkFrame(logisticsBLService);
                frame.setVisible(true);
            }else if(id.charAt(0) == '5'){
                LogisticsBLService logisticsBLService = new LogisticsBLController();
                this.setVisible(false);
                BusinessOfficeClerkFrame frame = new BusinessOfficeClerkFrame(logisticsBLService);
                frame.setVisible(true);
            }
            PublicMessage.userID = id;
//            }
//            catch(Exception ex){
//            	JFrame warning = new JFrame();
//            	warning.setBounds(this.getBounds());
//            	
//            	JPanel panel = new JPanel();
//            	panel.setBounds(0, 0, 310, 250);
//            	
//            	JLabel label = new JLabel(ex.getClass().getName());
//            	label.setBounds(panel.getBounds());
//            	panel.add(label);
//            	
//            	warning.add(panel);
//            	
//            	warning.setVisible(true);
//            }
        }
    }
}

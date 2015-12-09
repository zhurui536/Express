package main.presentation;

import main.connection.ClientInitException;
import main.connection.ClientRMIHelper;
import main.presentation.financeui.FinanceFrame;
import main.presentation.logisticsui.deliverymanui.DeliveryManFrame;
import main.presentation.managerui.ManagerFrame;
import main.presentation.storeui.StoreFrame;

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
    private JTextArea password;
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

        this.password = new JTextArea();
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
                this.setVisible(false);
                DeliveryManFrame frame = new DeliveryManFrame();
                frame.setVisible(true);
            } else if (id.charAt(0) == '3') {
                this.setVisible(false);
                DeliveryManFrame frame = new DeliveryManFrame();
                frame.setVisible(true);
            }
        }
    }
}

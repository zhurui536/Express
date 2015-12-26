package presentation.mainui;

import bussinesslogic.logisticsbl.LogisticsBLController;
import bussinesslogic.userbl.UserBLServiceImpl;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import bussinesslogicservice.userblservice.UserBLService;
import connection.ClientInitException;
import connection.ClientRMIHelper;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.managerui.ManagerFrame;
import presentation.storeui.StoreFrame;
import presentation.userui.AdminFrame;
import util.FrameUtil;
import util.Job;
import util.PublicMessage;
import util.ResultMessage;
import vo.StaffMessageVO;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
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
    
    private UserBLService bl;

    public static String USER_ID;

    public static void main(String[] args){
    	initRMI();
        MainUI ui = new MainUI();
        FrameUtil.setFrameCenter(ui);
        ui.setVisible(true);
    }

    public MainUI(){
//    	try {
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
//            JFrame.setDefaultLookAndFeelDecorated(true);
//            JDialog.setDefaultLookAndFeelDecorated(true);
//            SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
//          SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
//          SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
//          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
//          SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
//            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
//            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());
        } catch (Exception e) {
//            System.err.println("Something went wrong!");
        }
    	this.bl = new UserBLServiceImpl();
        this.setLayout(null);
        this.setBounds(300, 300, 330, 260);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.initialize();
    }

    private static void initRMI() {
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
        	 String id = this.id.getText();
        	 String password = new String(this.password.getPassword());
        	 
        	 ResultMessage result = this.bl.login(id, password);
        	 if(result.getKey().equals("success")){
        		 StaffMessageVO vo = (StaffMessageVO) result.getValue();
        		 
        		 this.OpenFrame(vo);
        	 }
        	 else{
        		 new WarningDialog(this, result);
        	 }
        }
    }
    
    private void OpenFrame(StaffMessageVO vo){
    	if(vo.job == Job.COURIER){
    		LogisticsBLService logisticsBLService = new LogisticsBLController();
            this.setVisible(false);
            DeliveryManFrame frame = new DeliveryManFrame(logisticsBLService);
            FrameUtil.setFrameCenter(frame);
            frame.setVisible(true);
    	}
    	if(vo.job == Job.STOCKMAN){
            this.setVisible(false);
            StoreFrame frame = new StoreFrame();
            FrameUtil.setFrameCenter(frame);
            frame.setVisible(true);
    	}
    	if(vo.job == Job.MANAGER){
    		this.setVisible(false);
            ManagerFrame frame = new ManagerFrame();
            FrameUtil.setFrameCenter(frame);
            frame.setVisible(true);
    	}
    	if(vo.job == Job.SALESOFOFFICE){
    		LogisticsBLService logisticsBLService = new LogisticsBLController();
            this.setVisible(false);
            BusinessOfficeClerkFrame frame = new BusinessOfficeClerkFrame(logisticsBLService);
            FrameUtil.setFrameCenter(frame);
            frame.setVisible(true);
    	}
    	if(vo.job == Job.FINANCEMAN){
    		this.setVisible(false);
            FinanceFrame frame = new FinanceFrame();
            FrameUtil.setFrameCenter(frame);
            frame.setVisible(true);
    	}
    	if(vo.job == Job.SALESOFCENTRE){
    		LogisticsBLService logisticsBLService = new LogisticsBLController();
            this.setVisible(false);
            TransitCenterclerkFrame frame = new TransitCenterclerkFrame(logisticsBLService);
            FrameUtil.setFrameCenter(frame);
            frame.setVisible(true);
    	}
    	if(vo.job == Job.ADMIN){
    		this.setVisible(false);
    		AdminFrame frame = new AdminFrame();
            FrameUtil.setFrameCenter(frame);
    		frame.setVisible(true);
    	}
    	
    	PublicMessage.staffID = vo.id;
    	PublicMessage.institutionID = vo.institutionid;
    }
}

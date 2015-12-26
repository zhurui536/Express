package presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bussinesslogic.userbl.UserBLServiceImpl;
import bussinesslogicservice.userblservice.UserBLService;
import connection.ClientInitException;
import connection.ClientRMIHelper;
import connection.ConnectTest;
import po.InstitutionMessagePO;
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
    	JFrame frame = null;
    	this.setVisible(false);
    	
    	if(vo.job == Job.COURIER){
            frame = new DeliveryManFrame();
    	}
    	if(vo.job == Job.STOCKMAN){
            frame = new StoreFrame();
    	}
    	if(vo.job == Job.MANAGER){
            frame = new ManagerFrame();
    	}
    	if(vo.job == Job.SALESOFOFFICE){
            frame = new BusinessOfficeClerkFrame();
    	}
    	if(vo.job == Job.FINANCEMAN){
            frame = new FinanceFrame();
    	}
    	if(vo.job == Job.SALESOFCENTRE){
            frame = new TransitCenterclerkFrame();
    	}
    	if(vo.job == Job.ADMIN){
    		frame = new AdminFrame();
    	}
    	
    	FrameUtil.setFrameCenter(frame);
    	frame.setVisible(true);
    	
    	// 测试网络连接
    	testConnect(frame);
    	
    	initPublicMessage(vo);
    }
    
    private void initPublicMessage(StaffMessageVO vo) {
            PublicMessage.job = vo.job;
            PublicMessage.staffID = vo.id;
            PublicMessage.institutionID = vo.institutionid;
            ResultMessage resultMessage = bl.getCity(vo.institutionid);
            InstitutionMessagePO institutionMessagePO = null;
            if(resultMessage.getKey().equals("success"))
                    institutionMessagePO = (InstitutionMessagePO) resultMessage.getValue();
            if(institutionMessagePO == null)
                    return;
            PublicMessage.institutionType = institutionMessagePO.getInstitutionType();
            PublicMessage.location = institutionMessagePO.getCity();
            
    }
    
    private static void testConnect(JFrame ui) {
    	ConnectTest connectTest = new ConnectTest();
    	connectTest.init(ui);
    }
}

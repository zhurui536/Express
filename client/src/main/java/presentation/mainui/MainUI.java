package presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.mainui.component.ToolButton;
import presentation.managerui.ManagerFrame;
import presentation.storeui.StoreFrame;
import presentation.userui.AdminFrame;
import util.FrameUtil;
import util.Job;
import util.PublicMessage;
import util.ResultMessage;
import util.UIImage;
import vo.InstitutionMessageVO;
import vo.StaffMessageVO;

/**
 * Created by Away
 * 2015/10/26
 */

@SuppressWarnings("serial")
public class MainUI extends JFrame implements ActionListener{
    private JTextArea id;
    private JPasswordField password;
    private ToolButton confirm;
    private ToolButton exit;
    
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
        JLabel bg = new JLabel();
		bg.setIcon(UIImage.BACKGROUND_FRAME);
		bg.setBounds(0, 0, 1000, 600);
		this.getContentPane().add(bg, -1);

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
        this.getContentPane().add(title, 0);

        JLabel id = new JLabel("用户ID");
        id.setBounds(20, 50, 50, 40);
        this.getContentPane().add(id, 0);

        JLabel password = new JLabel("密码");
        password.setBounds(20, 100, 50, 40);
        this.getContentPane().add(password, 0);

        this.id = new JTextArea();
        this.id.setBounds(90, 50, 200, 40);
        this.getContentPane().add(this.id, 0);

        this.password = new JPasswordField();
        this.password.setBounds(90, 100, 200, 40);
        this.getContentPane().add(this.password, 0);

        confirm = new ToolButton(40, 160, "确定");
        confirm.setSize(80, 30);
        confirm.addActionListener(this);
        this.getContentPane().add(confirm, 0);

        exit = new ToolButton(150, 160, "退出");
        exit.setSize(80, 30);
        exit.addActionListener(this);
        this.getContentPane().add(exit, 0);
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
    	
    	if(vo.job == Job.COURIER) {
            frame = new DeliveryManFrame();
    	} else if(vo.job == Job.STOCKMAN) {
            frame = new StoreFrame();
    	} else if(vo.job == Job.MANAGER) {
            frame = new ManagerFrame();
    	} else if(vo.job == Job.SALESOFOFFICE) {
            frame = new BusinessOfficeClerkFrame();
    	} else if(vo.job == Job.FINANCEMAN) {
            frame = new FinanceFrame();
    	} else if(vo.job == Job.SALESOFCENTRE) {
            frame = new TransitCenterclerkFrame();
    	} else if(vo.job == Job.ADMIN) {
    		frame = new AdminFrame();
    	}
    	
    	frame.setVisible(true);
    	
    	// 测试网络连接
    	testConnect(frame);
    	
    	initPublicMessage(vo);
    }
    
    private void initPublicMessage(StaffMessageVO vo) {
            PublicMessage.job = vo.job;
            PublicMessage.staffID = vo.id;
            PublicMessage.institutionID = vo.institutionid;
            ResultMessage resultMessage = bl.getInstitution(vo.institutionid);
            InstitutionMessageVO institutionMessageVO = null;
            if(resultMessage.getKey().equals("success"))
                    institutionMessageVO = (InstitutionMessageVO) resultMessage.getValue();
            if(institutionMessageVO == null)
                    return;
            PublicMessage.institutionType = institutionMessageVO.institutionType;
            PublicMessage.location = institutionMessageVO.city;
            
    }
    
    private static void testConnect(JFrame ui) {
    	ConnectTest connectTest = new ConnectTest();
    	connectTest.init(ui);
    }
}

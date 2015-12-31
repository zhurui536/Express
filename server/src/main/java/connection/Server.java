package connection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import util.FrameUtil;

/**
 * Created by Away
 * 2015/11/26
 */

public class Server {
	
	private JFrame frame;
	private JPanel panel;
	private JButton end;
	private JLabel label;
	
	public Server() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch(Exception e) {
			e.printStackTrace();
		}
		init();
	}
	
    private void init() {
		frame = new JFrame();
		frame.setSize(300, 200);
		FrameUtil.setFrameCenter(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		label = new JLabel("快递物流系统服务器");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setBounds(60, 30, 300, 30);
		
		end = new JButton("结束");
		end.setBounds(100, 90, 80, 40);
		end.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		end.setToolTipText("点击关闭服务器");
		
		panel.add(label);
		panel.add(end);
		frame.setContentPane(panel);
		
	}
    
    public void start() {
    	frame.setVisible(true);
    	try {
    		ServerRMIHelper.init();
    		ConnectTestServer server = new ConnectTestServer();
    		server.init();
    	} catch (ServerInitException e1) {
    		e1.printStackTrace();
    	}
    }
    
	public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}

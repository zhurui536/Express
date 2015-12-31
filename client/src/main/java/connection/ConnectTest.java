package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

import presentation.WarningDialog;

public class ConnectTest {
	
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket sock;

	public synchronized void init(JFrame ui) {
		try {
			sock = new Socket(RMIConfig.getIP(), RMIConfig.getPORT() + 1);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
			Thread readerThread = new Send(ui);
			readerThread.start();
			
		} catch (IOException ex) {
			System.out.println("init");
			ex.printStackTrace();
		}
	}

	public class Send extends Thread {
		
		private JFrame ui;
		
		public Send(JFrame ui) {
			this.ui = ui;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					writer.println("test");
					writer.flush();
					Thread.sleep(50);
					reader.readLine();
				} catch(InterruptedException e) {
					e.printStackTrace();	
					break;
				} catch (IOException e) {
					new WarningDialog(ui, "已断线，系统关闭");
					System.exit(0);
//					e.printStackTrace();
				}
			}
		}
	}
}

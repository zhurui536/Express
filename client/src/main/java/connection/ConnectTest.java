package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import presentation.WarningDialog;

public class ConnectTest {
	
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket sock;

	public synchronized void init() {
		try {
			sock = new Socket(RMIConfig.getIP(), RMIConfig.getPORT() + 1);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
			Thread readerThread = new Send();
			readerThread.start();
			
		} catch (IOException ex) {
			System.out.println("init");
			ex.printStackTrace();
		}
	}

	public class Send extends Thread {
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
					new WarningDialog(null, "断线啦");
//					e.printStackTrace();
					break;
				}
			}
		}
	}
}
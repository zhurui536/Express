package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectTest {
	
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket sock;

	public synchronized void init() {
		try {
			sock = new Socket(RMIConfig.getIP(), RMIConfig.getPORT());
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
			Thread readerThread = new Send();
			readerThread.start();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public class Send extends Thread {
		public void run() {
			while (!this.isInterrupted()) {
				try {
					writer.println(ConnectTestConfig.getSendMsg());
					Thread.sleep(50);
					String msg = reader.readLine();
					if (!msg.equals(ConnectTestConfig.getSuccessMsg())) {
						break;
					}
				} catch(InterruptedException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

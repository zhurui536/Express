package connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConnectTest {
	
	
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket sock;

	public ConnectTest() {
		init();
		go();
	}

	public void go() {
		Thread readerThread = new Send();
		readerThread.start();
	}

	private void init() {
		try {
			sock = new Socket(RMIConfig.getIP(), RMIConfig.getPORT());
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public class Send extends Thread {
		public void run() {
			while (!this.isInterrupted()) {
				try {
					
				}
			}
		}
	}
}

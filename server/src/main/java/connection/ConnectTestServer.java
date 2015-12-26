package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ConnectTestServer {

	private ServerSocket serverSocket;
	private PrintWriter clientOutputStream;
	
	public synchronized void init() {
		try {
			serverSocket = new ServerSocket(RMIConfig.getPORT() + 1);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				clientOutputStream = new PrintWriter(
						clientSocket.getOutputStream());
				Thread t = new ClientHandler(clientSocket);
				t.start();
				System.out.println("got a connetcion");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public class ClientHandler extends Thread {
		BufferedReader reader;
		Socket sock;

		public ClientHandler(Socket clientSocket) {
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(
						sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					String msg = reader.readLine();
					clientOutputStream.println(msg);
					clientOutputStream.flush();
				} catch (SocketException se) {
					break;
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
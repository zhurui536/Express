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

	public void init() {
		try {
			serverSocket = new ServerSocket(RMIConfig.getPORT());
			Socket clientSocket = serverSocket.accept();
			clientOutputStream = new PrintWriter(
					clientSocket.getOutputStream());
			Thread t = new ClientHandler(clientSocket);
			t.start();
			System.out.println("got a connetcion");
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

		public void run() {
			while (!this.isInterrupted()) {
				try {
					String msg = reader.readLine();
					if (msg != null) {
						clientOutputStream.println("get");
					}

				} catch (SocketException se) {
					System.out.println("socket connection is closed!!!");
					try {
						serverSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
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
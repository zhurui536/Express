package main.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class MyRMIFactory extends RMISocketFactory {
	
	private String ip;
	
	private int port;
	
	public MyRMIFactory(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	@Override
	public Socket createSocket(String host, int port) throws IOException {
	     System.out.println("create client socket " + this.ip + ":" + this.port);
	     return new Socket(this.ip, this.port);

	}

	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		System.out.println("create server socket " + this.ip + ":" + this.port);
        return new ServerSocket(this.port, 0, InetAddress.getByName(this.ip));
	}

}

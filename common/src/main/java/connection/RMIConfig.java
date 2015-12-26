package connection;

public class RMIConfig {
	
	private static String IP;
	
    private static int PORT;
    
    public RMIConfig() {
//		IP = "172.26.98.70";
    	IP = "localhost";
		PORT = 1099;
	}

	public static String getIP() {
		return IP;
	}

	public static int getPORT() {
		return PORT;
	}
    
}

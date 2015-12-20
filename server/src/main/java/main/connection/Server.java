package main.connection;

/**
 * Created by Away
 * 2015/11/26
 */

public class Server {

    public static void main(String[] args) {
        try {
            ServerRMIHelper server = new ServerRMIHelper();
            server.init();
        } catch (ServerInitException e) {
            e.printStackTrace();
        }
    }
}

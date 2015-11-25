package main.connection;

/**
 * Created by Away
 * 2015/11/26
 */

public class Client {
    public static void main(String[] args) {
        try {
            ServerRMIHelper.init();
        } catch (ClientInitException e) {
            e.printStackTrace();
        }

    }
}

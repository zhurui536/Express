package connection;

/**
 * Created by Away
 * 2015/11/26
 */

public class Client {
    public static void main(String[] args) {
        try {
            ClientRMIHelper client = new ClientRMIHelper();
            client.init();
        } catch (ClientInitException e) {
            e.printStackTrace();
        }

    }
}

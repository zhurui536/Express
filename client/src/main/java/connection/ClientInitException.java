package connection;

/**
 * Created by Away
 * 2015/11/25
 */

public class ClientInitException extends Throwable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5101836605741298981L;

	public ClientInitException(Exception e) {
        super(e);
    }
}

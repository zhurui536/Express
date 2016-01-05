package connection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@SuppressWarnings("unchecked")
public class RMIConfig {
	
	private static final Map<String, String> param;
	
	private static String IP;
	
    private static int PORT;
    
    private static final boolean IS_DEBUG = true;
    
    static {
    	param = new HashMap<>();
		if (IS_DEBUG) {
			Element common = null;
			try {
				SAXReader reader = new SAXReader();
				Document doc = null;
//				doc = reader.read("../common/" + "ipconfig.xml");
				doc = reader.read("ipconfig.xml");
				common = doc.getRootElement();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			List<Element> params = common.element("connection").elements("param");
			for (Element element : params) {
				param.put(element.attributeValue("key"), element.attributeValue("value"));
			}
			
			IP = param.get("ip");
			PORT = Integer.parseInt(param.get("port"));
		}
		else {
			IP = "localhost";
			PORT = 1099;
		}
		
    }

	public static String getIP() {
		return IP;
	}

	public static int getPORT() {
		return PORT;
	}
    
}

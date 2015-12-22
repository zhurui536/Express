package util;

public enum City {
	NANJING, BEIJING, SHANGHAI, GUANGZHOU;
	
	public static String cityToString(City city){
		String result = null;
        switch (city) {
                case NANJING:
                        result = "南京";
                        break;
                case BEIJING:
                        result = "北京";
                        break;
                case SHANGHAI:
                        result = "上海";
                        break;
                case GUANGZHOU:
                		result = "广州";
                		break;
        }
        return result;
	}
	
	public static City stringToCity(String string) {
                City city = null;
                switch (string) {
                        case "南京":
                                city = NANJING;
                                break;
                        case "北京":
                                city = BEIJING;
                                break;
                        case "广州":
                                city = GUANGZHOU;
                                break;
                        case "上海":
                                city = SHANGHAI;
                                break;
                }
                return city;
        }
}

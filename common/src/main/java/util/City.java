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
                case GUANGZHOU:
                		result = "广州";
        }
        return result;
	}
}

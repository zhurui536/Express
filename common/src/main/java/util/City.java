package util;

import java.util.HashMap;

public enum City {
	NANJING, BEIJING, SHANGHAI, GUANGZHOU;
	
	private static HashMap<String, City> nameMap;
        
        static{
                nameMap = new HashMap<>();
                nameMap.put("南京", NANJING);
                nameMap.put("北京", BEIJING);
                nameMap.put("上海", SHANGHAI);
                nameMap.put("广州", GUANGZHOU);
        }
        
        public static City stringToType(String string) {
                return nameMap.get(string);
        }
        
        public static String cityToString(City type) {
                String result = null;
                for (String key : nameMap.keySet()) {
                        if(nameMap.get(key) == type)
                                result = key;
                }
                return result;
        }
        
        public static String CityToNum(City city){
        	if(city == NANJING)
        		return "025";
        	if(city == BEIJING)
        		return "010";
        	if(city == SHANGHAI)
        		return "021";
        	if(city == GUANGZHOU)
        		return "020";
        	
        	return null;
        }
}

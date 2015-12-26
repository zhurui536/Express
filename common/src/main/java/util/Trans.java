package util;

import java.util.HashMap;

public enum Trans {
	PLANE, TRAIN, TRUCK;
	
	private static HashMap<String, Trans> nameMap;
        
        static{
                nameMap = new HashMap<>();
                nameMap.put("飞机", PLANE);
                nameMap.put("火车", TRAIN);
                nameMap.put("汽车", TRUCK);
        }
        
        public static Trans stringToType(String string) {
                return nameMap.get(string);
        }
        
        public static String transToString(Trans type) {
                String result = null;
                for (String key : nameMap.keySet()) {
                        if(nameMap.get(key) == type)
                                result = key;
                }
                return result;
        }
}
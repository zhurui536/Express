package util;

import java.util.HashMap;

/**
 * @author zhuding
 *
 */
public enum ExpressType {
        ECONOMIC , COURIER,EXPRESS;
        
        private static HashMap<String, ExpressType> nameMap;
        
        static{
                nameMap = new HashMap<>();
                nameMap.put("经济", ECONOMIC);
                nameMap.put("普通", COURIER);
                nameMap.put("特快", EXPRESS);
        }
        
        public static ExpressType stringToType(String string) {
                return nameMap.get(string);
        }
        
        public static String typeToString(ExpressType type) {
                String result = null;
                for (String key : nameMap.keySet()) {
                        if(nameMap.get(key) == type)
                                result = key;
                }
                return result;
        }
        
        public static double typeToCost(ExpressType expressType, double distance){
                double result = 0;
                switch (expressType) {
                        case ECONOMIC:
                                result =  distance / 1000.0 * 18.0;
                                break;
                        case COURIER:
                                result =  distance / 1000.0 * 23.0;
                                break;
                        case EXPRESS:
                                result = distance / 1000.0 * 25.0;
                                break;
                }
                return result;
        }
}

package util;

/**
 * @author zhuding
 *
 */
public enum ExpressType {
        ECONOMIC , COURIER,EXPRESS;
        public static ExpressType stringToType(String string) {
                ExpressType expressType = null;
                if(string.contains("经济"))
                        expressType = ECONOMIC;
                else if(string.contains("普通"))
                        expressType = COURIER;
                else if(string.contains("特快"))
                        expressType = EXPRESS;
                return expressType;
        }
        public static String typeToString(ExpressType type) {
                String result = null;
                switch (type) {
                        case ECONOMIC:
                                result = "经济";
                                break;
                        case COURIER:
                                result = "普通";
                                break;
                        case EXPRESS:
                                result = "特快";
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

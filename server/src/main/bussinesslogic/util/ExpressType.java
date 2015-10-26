package main.bussinesslogic.util;

/**
 * @author zhuding
 *
 */
public enum ExpressType {
        ECONOMIC , COURIER,EXPRESS;
        
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

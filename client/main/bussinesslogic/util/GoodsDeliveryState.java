package main.bussinesslogic.util;

import java.util.HashMap;

/**
 * @author zhuding
 *
 */
public enum GoodsDeliveryState {
        TRANSPORT,DELIVERY,DELIVERED;
        
        private static HashMap<String, GoodsDeliveryState> nameMap;
        
        static{
                nameMap = new HashMap<>();
                nameMap.put("转运中", TRANSPORT);
                nameMap.put("派件中", DELIVERY);
                nameMap.put("已送达", DELIVERED);
        }
        
        public static GoodsDeliveryState stringToType(String string) {
                return nameMap.get(string);
        }
        
        public static String typeToString(GoodsDeliveryState type) {
                String result = null;
                for (String key : nameMap.keySet()) {
                        if(nameMap.get(key) == type)
                                result = key;
                }
                return result;
        }
}

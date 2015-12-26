package util;

import java.util.HashMap;

public enum PackageType {
        CARTONS, WOODEN_BOX, COURIER_BAG;
        
        private static HashMap<String, PackageType> nameMap;
        
        static{
                nameMap = new HashMap<>();
                nameMap.put("纸箱", CARTONS);
                nameMap.put("木箱", WOODEN_BOX);
                nameMap.put("快递袋", COURIER_BAG);
        }
        
        public static PackageType stringToType(String string) {
                return nameMap.get(string);
        }
        
        public static String typeToString(PackageType type) {
                String result = null;
                for (String key : nameMap.keySet()) {
                        if(nameMap.get(key) == type)
                                result = key;
                }
                return result;
        }
        
        public static int typeToCost(PackageType packageType) {
                int cost = 0;
                switch (packageType) {
                        case CARTONS:
                                cost = 5;
                                break;

                        case WOODEN_BOX:
                                cost = 10;
                                break;
                                
                        case COURIER_BAG:
                                cost = 1;
                                break;
                }
                return cost;
        }
}

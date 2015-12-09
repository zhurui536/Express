package main.bussinesslogic.util;

public enum PackageType {
        CARTONS, WOODEN_BOX, COURIER_BAG;
        
        public static PackageType stringToType(String string) {
                PackageType packageType = null;
                if(string.contains("纸箱"))
                        packageType = CARTONS;
                else if(string.contains("木箱"))
                        packageType = WOODEN_BOX;
                else if(string.contains("快递袋"))
                        packageType = COURIER_BAG;
                return packageType;
        }
        
        public static String typeToString(PackageType type) {
                String result = null;
                switch (type) {
                        case CARTONS:
                                result = "纸箱";
                                break;
                        case WOODEN_BOX:
                                result = "木箱";
                                break;
                        case COURIER_BAG:
                                result = "快递袋";
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

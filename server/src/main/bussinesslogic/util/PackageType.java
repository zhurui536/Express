package main.bussinesslogic.util;

public enum PackageType {
        CARTONS, WOODEN_BOX, COURIER_BAG;
        
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

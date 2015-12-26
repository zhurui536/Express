package util;

public enum InstitutionType {
        BUSINESS_HALL,TRANSIT_CENTER;
        
        public static String typeTpString(InstitutionType institutionType) {
                String result = null;
                switch (institutionType) {
                        case BUSINESS_HALL:
                                result = "营业厅";
                                break;
                        case TRANSIT_CENTER:
                                result = "中转中心";
                                break;
                }
                return result;
        }
}

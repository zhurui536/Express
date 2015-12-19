package util;

public enum Sex {
        Man,Woman;
        
        public static Sex stringToSex(String string) {
                if(string.equals("男"))
                        return Man;
                else
                        return Woman;
        }
        
        public static String sexToString(Sex sex) {
                if(sex == Man)
                        return "男";
                else 
                        return "女";
        }
}

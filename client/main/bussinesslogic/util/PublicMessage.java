package main.bussinesslogic.util;

public class PublicMessage {
        
        public static String location;
        
        public static String userID;
        
        public static void init(String location, String userID) {
                PublicMessage.location = location;
                PublicMessage.userID = userID;
        }
        
        private PublicMessage() {}
        
}

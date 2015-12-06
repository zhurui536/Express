package main.bussinesslogic.util;

public class PublicMessage {
        
        public static String location;
        
        public static String userID;
        
        public static String institutionID;
        
        public static void init(String location, String userID, String institutionID) {
                PublicMessage.location = location;
                PublicMessage.userID = userID;
                PublicMessage.institutionID = institutionID;
        }
        
        private PublicMessage() {}
        
}

package main.vo;

import main.bussinesslogic.util.PublicMessage;
import main.bussinesslogic.util.Time;

/**
 * @author zhuding
 */
public class SystemlogVO {
        public Time time;

        public String origin;

        public String userID;

        public String event;

        public SystemlogVO() {
                super();
        }
        
        public SystemlogVO(Time time, String origin, String userID, String event) {
                super();
                this.time = time;
                this.origin = origin;
                this.userID = userID;
                this.event = event;
        }
        
        public SystemlogVO(String origin,String event) {
                this(new Time(), origin, PublicMessage.userID, event);
        }
        
}

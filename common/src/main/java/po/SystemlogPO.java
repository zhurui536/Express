package po;

import java.io.Serializable;

import util.Time;

/**
 * @author zhuding
 *
 */
@SuppressWarnings("serial")
public class SystemlogPO implements Serializable{
        //标识发生的时间
        private Time time;
        //表示操作的人的身份和机构
        private String origin;
        //操作者的ID
        private String userID;
        //操作的内容
        private String event;

        public SystemlogPO(Time time, String origin, String userID, String event) {
                super();
                this.time = time;
                this.origin = origin;
                this.userID = userID;
                this.event = event;
        }

        public Time getTime() {
                return time;
        }

        public void setTime(Time time) {
                this.time = time;
        }

        public String getOrigin() {
                return origin;
        }

        public void setOrigin(String origin) {
                this.origin = origin;
        }

        public String getUserID() {
                return userID;
        }

        public void setUserID(String userID) {
                this.userID = userID;
        }

        public String getEvent() {
                return event;
        }

        public void setEvent(String event) {
                this.event = event;
        }
        
        

}

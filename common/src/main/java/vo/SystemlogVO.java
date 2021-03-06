package vo;


import util.City;
import util.InstitutionType;
import util.PublicMessage;
import util.Time;

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
        
        public SystemlogVO(String event) {
                this(new Time(), City.cityToString(PublicMessage.location) + InstitutionType.typeTpString(PublicMessage.institutionType), PublicMessage.staffID, event);
        }
        
}

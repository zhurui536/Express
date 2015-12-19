package vo;

import util.Sex;
import util.Time;

/**
 * @author zhuding
 *
 */
public class DriverMessageVO {
        
        public String driverId;
        
        public String name;
        
        public String ID;
        
        public String phoneNum;
        
        public Sex sex;
        
        public Time birth;
        
        public Time registrationTime;
        
        public Time terminationTime;
        
        public int yearsOfLicense;
        
        public DriverMessageVO() {
               
        }

        public DriverMessageVO(String driverId, String name, String iD,
                        String phoneNum, Sex sex, Time birth,
                        Time registrationTime, 
                        int yearsOfLicense) {
                super();
                this.driverId = driverId;
                this.name = name;
                ID = iD;
                this.phoneNum = phoneNum;
                this.sex = sex;
                this.birth = birth;
                this.registrationTime = registrationTime;
                this.yearsOfLicense = yearsOfLicense;
                this.terminationTime = registrationTime.add(yearsOfLicense);
        }
        
        

}

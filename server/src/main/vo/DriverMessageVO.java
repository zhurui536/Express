package main.vo;

/**
 * @author zhuding
 *
 */
public class DriverMessageVO {
        
        public  enum sex{MAN,WOMAN};
        
        private String driverId;
        
        private String name;
        
        private String ID;
        
        private String phoneNum;
        
        private sex sex;
        
        private double periodOfDrivinglicence;
        
//        public DriverMessageVO(String driverId, String name, String ID,
//                        String phoneNum, sex sex, double periodOfDrivinglicence) {
//                this.driverId = driverId;
//                this.name = name;
//                this.ID = ID;
//                this.phoneNum = phoneNum;
//                this.sex = sex;
//                this.periodOfDrivinglicence = periodOfDrivinglicence;
//        }

        public String getDriverId() {
                return driverId;
        }

        public void setDriverId(String driverId) {
                this.driverId = driverId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getID() {
                return ID;
        }

        public void setID(String iD) {
                ID = iD;
        }

        public String getPhoneNum() {
                return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
        }

        public sex getSex() {
                return sex;
        }

        public void setSex(sex sex) {
                this.sex = sex;
        }

        public double getPeriodOfDrivinglicence() {
                return periodOfDrivinglicence;
        }

        public void setPeriodOfDrivinglicence(double periodOfDrivinglicence) {
                this.periodOfDrivinglicence = periodOfDrivinglicence;
        }
        
        
}

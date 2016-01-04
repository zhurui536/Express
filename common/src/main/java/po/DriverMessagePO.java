package po;

import java.io.Serializable;

import util.PublicMessage;
import util.Sex;
import util.Time;
import vo.DriverMessageVO;

/**
 * @author zhuding
 * 
 */
public class DriverMessagePO implements Serializable {

        private static final long serialVersionUID = -7202933638051764325L;
        // 司机编号
        private String driverId;
        // 姓名
        private String name;
        // 身份证号
        private String ID;
        // 手机号
        private String phoneNum;
        // 性别
        private Sex sex;
        // 出生日期
        private Time birth;
        // 驾驶证的注册时间
        private Time registrationTime;
        // 驾驶证到期时间
        private Time terminationTime;
        // 驾驶证有效期
        private int yearsOfLicense;
        // 所属营业厅ID
        private String institutionID;

        public DriverMessagePO(String driverId, String name, String iD,
                        String phoneNum, Sex sex, Time birth,
                        Time registrationTime, int yearsOfLicense) {
                super();
                this.driverId = driverId;
                this.name = name;
                this.ID = iD;
                this.phoneNum = phoneNum;
                this.sex = sex;
                this.birth = birth;
                this.registrationTime = registrationTime;
                this.yearsOfLicense = yearsOfLicense;
                this.terminationTime = registrationTime.add(yearsOfLicense);
                this.setInstitutionID(PublicMessage.institutionID);
        }

        public DriverMessagePO(DriverMessageVO driverMessageVO) {
                this.driverId = driverMessageVO.driverId;
                this.name = driverMessageVO.name;
                this.ID = driverMessageVO.ID;
                this.phoneNum = driverMessageVO.phoneNum;
                this.sex = driverMessageVO.sex;
                this.birth = driverMessageVO.birth;
                this.registrationTime = driverMessageVO.registrationTime;
                this.yearsOfLicense = driverMessageVO.yearsOfLicense;
                this.terminationTime = registrationTime.add(yearsOfLicense);
                this.setInstitutionID(PublicMessage.institutionID);
        }

        public DriverMessageVO poToVo() {
                return new DriverMessageVO(driverId, name, ID, phoneNum, sex,
                                birth, registrationTime, yearsOfLicense);
        }

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

        public Sex getSex() {
                return sex;
        }

        public void setSex(Sex sex) {
                this.sex = sex;
        }

        public Time getBirth() {
                return birth;
        }

        public void setBirth(Time birth) {
                this.birth = birth;
        }

        public Time getRegistrationTime() {
                return registrationTime;
        }

        public void setRegistrationTime(Time registrationTime) {
                this.registrationTime = registrationTime;
        }

        public Time getTerminationTime() {
                return terminationTime;
        }

        public void setTerminationTime(Time terminationTime) {
                this.terminationTime = terminationTime;
        }

        public int getYearsOfLicense() {
                return yearsOfLicense;
        }

        public void setYearsOfLicense(int yearsOfLicense) {
                this.yearsOfLicense = yearsOfLicense;
        }

        public String getInstitutionID() {
                return institutionID;
        }

        public void setInstitutionID(String institutionID) {
                this.institutionID = institutionID;
        }

}

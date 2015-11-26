package po.logisticpo;

import java.io.Serializable;

import main.vo.logisticvo.PeopleMessageVO;
/**
 * @author zhuding
 */
@SuppressWarnings("serial")
public class PeopleMessagePO implements Serializable{
        //姓名
        private String name;
        //住址
        private String location;
        //单位
        private String institution;
        //电话
        private String telephoneNum;
        //手机
        private String mobliephoneNum;

        public PeopleMessagePO(String name, String location,
                        String institution, String telephoneNum,
                        String mobliephoneNum) {
                super();
                this.name = name;
                this.location = location;
                this.institution = institution;
                this.telephoneNum = telephoneNum;
                this.mobliephoneNum = mobliephoneNum;
        }

        public PeopleMessageVO poToVo() {
                PeopleMessageVO peopleMessageVO = new PeopleMessageVO();
                peopleMessageVO.institution = this.institution;
                peopleMessageVO.location = this.location;
                peopleMessageVO.mobliephoneNum = this.mobliephoneNum;
                peopleMessageVO.name = this.name;
                peopleMessageVO.telephoneNum = this.telephoneNum;
                return peopleMessageVO;
        }
        
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public String getInstitution() {
                return institution;
        }

        public void setInstitution(String institution) {
                this.institution = institution;
        }

        public String getTelephoneNum() {
                return telephoneNum;
        }

        public void setTelephoneNum(String telephoneNum) {
                this.telephoneNum = telephoneNum;
        }

        public String getMobliephoneNum() {
                return mobliephoneNum;
        }

        public void setMobliephoneNum(String mobliephoneNum) {
                this.mobliephoneNum = mobliephoneNum;
        }
        
        
}

package vo;


import util.City;
import util.InstitutionType;

/**
 * @author zhuding
 * 
 */
public class InstitutionMessageVO {
        // 机构名称
        public String name;

        // 机构编号
        public String id;

        // 机构类型
        public InstitutionType institutionType;
        
      //机构所在城市
        public City city;

        public InstitutionMessageVO(String name, String id,
                        InstitutionType institutionType, City city) {
                super();
                this.name = name;
                this.id = id;
                this.institutionType = institutionType;
                this.city = city;
        }

        public InstitutionMessageVO() {

        }

        
}

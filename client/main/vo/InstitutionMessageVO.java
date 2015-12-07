package main.vo;

import main.bussinesslogic.util.InstitutionType;

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

        public InstitutionMessageVO(String name, String id,
                        InstitutionType institutionType) {
                super();
                this.name = name;
                this.id = id;
                this.institutionType = institutionType;
        }
        
        
}

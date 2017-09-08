package com.zhaoxiang.component;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:18
 */
@Getter
@Setter
public class PatientInfoComponent {

    private String patientUserId;
    private String name;
    private String sex;
    private Integer age;
    private String inHospitalNum;
    private String bedNum;
    private String deptName;
}

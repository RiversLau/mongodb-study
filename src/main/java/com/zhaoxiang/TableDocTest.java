package com.zhaoxiang;

import com.zhaoxiang.component.PatientInfoComponent;
import com.zhaoxiang.tables.JOA001Table;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:48
 */
public class TableDocTest {

    public static void main(String[] args) {

        JOA001Table joa001Table = new JOA001Table();

        PatientInfoComponent patientInfo = new PatientInfoComponent();
        patientInfo.setPatientUserId("100001");
        patientInfo.setAge(35);
        patientInfo.setName("Don't Know");
        patientInfo.setSex("男");
        patientInfo.setDeptName("康复科");
        patientInfo.setBedNum("1220");
        patientInfo.setInHospitalNum("200001");
        joa001Table.setPatientInfoComponent(patientInfo);

        joa001Table.setPatientInfoComponent(patientInfo);
    }
}

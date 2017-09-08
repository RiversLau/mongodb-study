package com.zhaoxiang.tables;

import com.zhaoxiang.component.PatientInfoComponent;
import com.zhaoxiang.component.ResultComponent;
import com.zhaoxiang.component.SimpleLevelComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:32
 */
@Getter
@Setter
public class JOA001Table {

    private PatientInfoComponent patientInfoComponent;
    private ResultComponent resultComponent;

    private List<SimpleLevelComponent> subjectiveList;
    private List<SimpleLevelComponent> clinlcalList;
    private List<SimpleLevelComponent> lifeList;
    private SimpleLevelComponent bladder;
}

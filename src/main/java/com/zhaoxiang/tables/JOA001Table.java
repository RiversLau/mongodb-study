package com.zhaoxiang.tables;

import com.zhaoxiang.component.CategoryComponent;
import com.zhaoxiang.component.PatientInfoComponent;
import com.zhaoxiang.component.ResultComponent;
import com.zhaoxiang.component.SimpleLevelComponent;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:32
 */
@Getter
@Setter
public class JOA001Table {

    private String name;
    private String remark;

    private PatientInfoComponent patientInfoComponent;
    private ResultComponent resultComponent;

    private CategoryComponent subjective;
    private CategoryComponent clinlcal;
    private CategoryComponent life;
    private SimpleLevelComponent bladder;
}

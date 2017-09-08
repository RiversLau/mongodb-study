package com.zhaoxiang.component;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:00
 */
@Getter
@Setter
public class SimpleLevelComponent extends ItemComponent {

    private String itemName;            // 评估的项目名称
    private String levelResult;         // 评估的等级结果
    private Date estimateTime;          // 评估时间
    private String estimateRules;     // 评估准则
}

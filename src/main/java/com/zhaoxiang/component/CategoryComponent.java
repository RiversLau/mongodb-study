package com.zhaoxiang.component;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:37
 */
@Getter
@Setter
public class CategoryComponent {

    private String name;
    private String type;
    private Integer totalScore;
    private List<SimpleLevelComponent> componentList;
}

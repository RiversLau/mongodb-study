package com.zhaoxiang.component;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: RiversLau
 * Date: 2017/9/7 18:03
 */
@Getter
@Setter
public class ScoreComponent {

    private String quesName;
    private List<String> answerList;
    private String score;
}

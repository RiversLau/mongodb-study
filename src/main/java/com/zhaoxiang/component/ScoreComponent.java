package com.zhaoxiang.component;

import java.util.List;

/**
 * Author: RiversLau
 * Date: 2017/9/7 18:03
 */
public class ScoreComponent {

    private String quesName;
    private List<String> answerList;
    private String score;

    public String getQuesName() {
        return quesName;
    }

    public void setQuesName(String quesName) {
        this.quesName = quesName;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

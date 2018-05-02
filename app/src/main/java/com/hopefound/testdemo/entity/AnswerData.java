package com.hopefound.testdemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 王震 on 2018/4/25 0025.
 */
@Entity
public class AnswerData {
    @Id
    private Long answerId;
    private Long questionId;
    private String answerStr;
    @Generated(hash = 521083982)
    public AnswerData(Long answerId, Long questionId, String answerStr) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answerStr = answerStr;
    }
    @Generated(hash = 1298808599)
    public AnswerData() {
    }
    public Long getAnswerId() {
        return this.answerId;
    }
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
    public Long getQuestionId() {
        return this.questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    public String getAnswerStr() {
        return this.answerStr;
    }
    public void setAnswerStr(String answerStr) {
        this.answerStr = answerStr;
    }

    @Override
    public String toString() {
        return "answer:"+answerStr;
    }
}

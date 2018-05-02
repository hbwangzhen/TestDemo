package com.hopefound.testdemo.entity;

import java.io.Serializable;

/**
 * Created by 王震 on 2018/4/23 0023.
 */

public class TeacherListData implements Serializable{

    private String name;
    private String gender;
    private String age;
    private String type;
    private String teacherId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}

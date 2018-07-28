package com.example.activitytest;

import java.io.Serializable;

public class EmployeeInfo implements Serializable {

    private String name;
    private String _age;
    private String skill;
    private String gender;

    public EmployeeInfo(String name, String _age, String skill, String gender) {

        this.name = name;
        this._age = _age;
        this.skill = skill;
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String get_age() {

        return _age;
    }

    public void set_age(String _age) {

        this._age = _age;
    }

    public String getSkill() {

        return skill;
    }

    public void setSkill(String skill) {

        this.skill = skill;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }
}
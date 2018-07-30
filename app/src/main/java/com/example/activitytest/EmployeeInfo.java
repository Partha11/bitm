package com.example.activitytest;

import java.io.Serializable;

public class EmployeeInfo implements Serializable {

    private String name;
    private String _age;
    private String skills;
    private String gender;
    private String email;
    private String password;
    private String salary;

    public EmployeeInfo(String name, String email, String password, String _age, String skills, String gender, String salary) {

        this.name = name;
        this.email = email;
        this.password = password;
        this._age = _age;
        this.skills = skills;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {

        return name;
    }

    public String get_age() {

        return _age;
    }

    public String getSkill() {

        return skills;
    }

    public String getEmail() {

        return email;
    }

    public String getGender() {

        return gender;
    }

    public String getSalary() {

        return salary;
    }
}
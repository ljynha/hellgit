package com.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class account implements Serializable {
    private  int id;
    private  String name;
    private  int age;
    private Date birthday;
    private List<passport > passports;

    public List<passport> getPassports() {
        return passports;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", passports=" + passports +
                '}';
    }

    public void setPassports(List<passport> passports) {
        this.passports = passports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}

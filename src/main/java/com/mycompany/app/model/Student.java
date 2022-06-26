/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.model;

import java.util.Date;

/**
 *
 * @author leduc
 */
public class Student {

    private String code;
    private String departmentCode;
    private String name;
    private int gender;
    private String address;
    // Avoid conflict with class keyword
    private String klass;
    private Date birthday;

    public Student(String code, String departmentCode, String name, int gender, String address, String klass, Date birthday) {
        this.code = code;
        this.departmentCode = departmentCode;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.klass = klass;
        this.birthday = birthday;
    }

    public Student() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentCode()
    {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" + "code=" + code + ", departmentCode=" + departmentCode + ", name=" + name + ", gender=" + gender + ", address=" + address + ", klass=" + klass + ", birthday=" + birthday + '}';
    }

    
    
    
  
   
}

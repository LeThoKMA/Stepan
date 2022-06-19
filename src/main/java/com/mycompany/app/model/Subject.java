/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.model;

import java.util.List;

/**
 *
 * @author leduc
 */
public class Subject {

    private String code;
    private String name;
    private String departmentList = "";
    private int creditNumber;


    public Subject(String code, String name, int creditNumber) {
        this.code = code;
        this.name = name;
        this.creditNumber = creditNumber;
    }

    public Subject(String code, String name, int creditNumber, List<Department> departments) {
        this(code, name, creditNumber);
        departments.forEach(department -> {
            if (departmentList.isEmpty()) departmentList += department.getCode();
            else departmentList += "_" + department.getCode();
        });
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Subject() {
    }

    public String getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(String departmentList) {
        this.departmentList = departmentList;
    }
}

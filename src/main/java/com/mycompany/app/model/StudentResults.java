/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.model;

import java.util.List;

/**
 *
 * @author Phong
 */
public class StudentResults {
    private Student student;
     private List<Result> resultList;

    public StudentResults(Student student, List<Result> resultList) {
        this.student = student;
        this.resultList = resultList;
    }
   
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    
    
}

package com.mycompany.app.model;

public class StudentResult {
    private Student student;
    private Result result;

    public StudentResult(Student student, Result resultCode) {
        this.student = student;
        this.result = resultCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public StudentResult() {
    }
}

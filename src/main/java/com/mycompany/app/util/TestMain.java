package com.mycompany.app.util;

import com.mycompany.app.controller.StudentManagerController;
import com.mycompany.app.model.Department;

public class TestMain {
    public static void main(String[] args) {
        StudentManagerController.getInstance().getStudentResultBySubjectAndDepartment("CT", "CSDL").forEach(studentResult -> System.out.println( studentResult.getResult().getPoint3()));
    }
}

package com.mycompany.app.util;

import com.mycompany.app.controller.StudentManagerController;
import com.mycompany.app.model.Department;

public class TestMain {
    public static void main(String[] args) {
        StudentManagerController.getInstance().subjectInDepartment(new Department("AT", "An toàn")).forEach(subject -> System.out.println(subject.getName()));
    }
}

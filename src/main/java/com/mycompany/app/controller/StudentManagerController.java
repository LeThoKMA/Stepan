package com.mycompany.app.controller;

import com.mycompany.app.db.FakeDatabase;
//import com.mycompany.app.db.Feature;
import com.mycompany.app.db.iFeature;
import com.mycompany.app.model.Department;
import com.mycompany.app.model.Student;
import com.mycompany.app.model.StudentResult;
import com.mycompany.app.model.StudentResults;
import com.mycompany.app.model.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class StudentManagerController {
    private StudentManagerController(){};
    private static StudentManagerController instance;
    public static StudentManagerController getInstance() {
        if (instance == null) {
            instance = new StudentManagerController();
        }
        return instance;
    }
    private ArrayList<StudentResults> studentResult;
    iFeature dao = new FakeDatabase();
    public ArrayList<StudentResults> getAllResult() {
        studentResult = dao.getAllResult();
        return studentResult;
    }
    
    public ArrayList<StudentResults> sortByName() {
        studentResult.sort((o1, o2) -> {
            String[] nameO1 = o1.getStudent().getName().split(" ");
            String[] nameO2 = o2.getStudent().getName().split(" ");       
            //so sanh tu cuoi cung cua ten 
            return nameO1[nameO1.length - 1].compareTo(nameO2[nameO2.length - 1]);
        });
        return studentResult;
    }

    /**
     * Get all department need this subject
     * @param subject
     * @return
     */
    public List<Department> departmentsInSubject(Subject subject) {
        String[] departmentCodes = subject.getDepartmentList().split("_");
        return Arrays.stream(departmentCodes).map(code -> dao.getDepartment(code)).collect(Collectors.toList());
    }

    /**
     * Get all subject needed for {@linkplain   Department}
     * @param department
     * @return
     */
    public List<Subject> subjectInDepartment(Department department) {
        return dao.getSubjects().stream().filter(subject -> subject.getDepartmentList().contains(department.getCode())).collect(Collectors.toList());
    }
    public List<Department> getAllList()
    {
        return dao.departments();
    }
      public   List<StudentResult> getStudentResultBySubjectAndDepartment(String departmentCode, String subjectCode)
      {
          return dao.getStudentResultBySubjectAndDepartment(departmentCode, subjectCode);
      }
      public List<Student> getAllStudents(Department department)
              {
                  return dao.getStudentInDepartment(department.getCode());
              }
    
}

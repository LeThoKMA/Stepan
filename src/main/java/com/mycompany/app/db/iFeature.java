package com.mycompany.app.db;

import com.mycompany.app.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public interface iFeature {

    Vector findPointByID(int maSV);

    void updateStudent(Student stu);

    boolean insertStudent(Student s);

    Student getStudent(String code);

    List<Student> getAllStudent();

    List<Student> getStudentInDepartment(String departmentCode);

    boolean insertDepartment(Department department);

    void deleteDepartment(Department department);

    Department getDepartment(String code);

    List<Department> getDepartments();

    void insertResult(Result result);

    Result getResult(String studentCode, String subjectCode);

    List<Result> getAllResultOfStudent(String studentCode);

    ArrayList<StudentResults> getAllResult();

//    List<StudentResults> getStudentResultsInDepartment();

    List<StudentResult> getStudentResultBySubjectAndDepartment(String departmentCode, String subjectCode);





    boolean insertSubject(Subject subject);

    void deleteSubject(Subject subject);

    Subject getSubject(String code);

    List<Subject> getSubjects();
    List<Department> departments();
   
}

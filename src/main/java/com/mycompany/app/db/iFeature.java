package com.mycompany.app.db;

import com.mycompany.app.model.Department;
import com.mycompany.app.model.Student;
import com.mycompany.app.model.Subject;

import java.util.List;
import java.util.Vector;

public interface iFeature {

    Vector findPointByID(int maSV);

    void updateStudent(Student stu);

    boolean insertStudent(Student s);

    Student getStudent(String code);

    Department getDepartment(String code);








    Subject getSubject(String code);

    List<Subject> getSubjects();
    
   
}

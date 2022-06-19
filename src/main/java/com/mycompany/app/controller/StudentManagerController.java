package com.mycompany.app.controller;

import com.mycompany.app.db.Feature;
import com.mycompany.app.model.StudentResult;
import com.mycompany.app.model.Subject;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentManagerController {
    private StudentManagerController(){};
    Feature dao = new Feature();
    private static StudentManagerController instance;
    public static StudentManagerController getInstance() {
        if (instance == null) {
            instance = new StudentManagerController();
        }
        return instance;
    }
    private ArrayList<StudentResult> studentResult;
    
    public ArrayList<StudentResult> getAllResult() {
        studentResult = dao.getAllResult();
        return studentResult;
    }
    
    public ArrayList<StudentResult> sortByName() {
        studentResult.sort((o1, o2) -> {
            String[] nameO1 = o1.getStudent().getName().split(" ");
            String[] nameO2 = o2.getStudent().getName().split(" ");       
            //so sanh tu cuoi cung cua ten 
            return nameO1[nameO1.length - 1].compareTo(nameO2[nameO2.length - 1]);
        });
        return studentResult;
    }
    
    public Subject getSubject(String code) {
        return dao.getSubject(code);
    }
    
    
}

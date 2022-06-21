package com.mycompany.app.db;

import com.mycompany.app.model.*;
import com.mycompany.app.util.ListUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class FakeDatabase implements iFeature {
    Student thieu = new Student("CT0402000", "CT", "Thieu", 0, "Ha Noi", "CT4B", new Date());
    Student thang = new Student("CT0402001", "AT", "Thang", 0, "Ha Noi", "CT4B", new Date());
    Student tho = new Student("CT0402002", "CT", "Tho", 0, "Ha Noi", "CT4B", new Date());
    ArrayList<Student> students = ListUtil.arrayListOf(thieu, thang, tho);

    Department at = new Department("AT", "An toàn thông tin");
    Department ct = new Department("CT", "Công nghệ thông tin");
    Department dt = new Department("DT", "Điện tử viễn thông");
    ArrayList<Department> departments = ListUtil.arrayListOf(at, ct, dt);

    Subject csdl = new Subject("ATCT_CSDL", "Cơ sở dữ liệu", 3, ListUtil.arrayListOf(at, ct));
    Subject tin = new Subject("THDC", "Tin học đại cương", 3, ListUtil.arrayListOf(at, ct, dt));
    Subject toancc = new Subject("TA1", "Toán cao cấp A1", 4, ListUtil.arrayListOf(at, ct, dt));
    Subject atpm = new Subject("CT_ATPM", "An toàn phần mềm", 4, ListUtil.arrayListOf(ct));
    public ArrayList<Subject> subjects = ListUtil.arrayListOf(csdl, tin, toancc, atpm);

    Result thieuCsdlResult = new Result(thieu.getCode(), csdl.getCode(), 1, 2, 3);
    Result thieuTinResult = new Result(thieu.getCode(), tin.getCode(), 5, 2, 0);
    Result thieuToanccResult = new Result(thieu.getCode(), toancc.getCode(), 7, 5, 2);
    ArrayList<Result> thieuResult = ListUtil.arrayListOf(thieuCsdlResult, thieuToanccResult, thieuTinResult);

    Result thoCsdlResult = new Result(tho.getCode(), csdl.getCode(), 1, 2, 3);
    Result thoTinResult = new Result(tho.getCode(), tin.getCode(), 5, 2, 0);
    ArrayList<Result> thoResult = ListUtil.arrayListOf(thoCsdlResult, thoTinResult);

    Result thangCsdlResult = new Result(thang.getCode(), csdl.getCode(), 1, 2, 3);
    Result thangAtpmResult = new Result(thang.getCode(), atpm.getCode(), 5, 2, 0);
    Result thangToanccResult = new Result(thang.getCode(), toancc.getCode(), 7, 5, 2);
    ArrayList<Result> thangResult = ListUtil.arrayListOf(thangToanccResult, thangAtpmResult, thangCsdlResult);

    ArrayList<Result> results = ListUtil.arrayListOf(thieuResult, thoResult, thangResult);
    @Override
    public Vector findPointByID(int maSV) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Vector row = null;
        try {
            con = getDBconnection.getConnection();
            row = new Vector();
            statement = con.prepareStatement("select sv.MaSV,sv.TenSV,sv.Lop,mh.MaMH,kq.Diem "
                    + "from (Sinhvien sv join Ketqua kq on sv.MaSV=kq.MaSV) join Monhoc mh on kq.MaMH=mh.MaMH "
                    + "where sv.MaSV=? order by MaMH asc");
            statement.setInt(1, maSV);
            rs = statement.executeQuery();
            rs.next();
            row.add(rs.getInt("MaSV"));
            row.add(rs.getString("TenSV"));
            row.add(rs.getString("Lop"));
            for (int i = 1; i <= 5; i++) {
                if (rs.getInt("MaMH") == i) {
                    row.add(rs.getInt("Diem"));
                } else {
                    row.add("");
                }
                rs.next();
            }
            return row;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    @Override
    public void updateStudent(Student stu) {

    }

    public ArrayList<StudentResult> getAllResult() {
        return ListUtil.arrayListOf(
                new StudentResult(thieu, thieuResult),
                new StudentResult(tho, thoResult),
                new StudentResult(thang, thangResult)
        );
    }

    @Override
    public boolean insertStudent(Student s) {
        students.add(s);
        return true;
    }

    @Override
    public Student getStudent(String code) {
        try {
            return students.stream().filter(student -> student.getCode().equals(code)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Department getDepartment(String code) {
        try {
            return departments.stream().filter(department -> department.getCode().equals(code)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Subject getSubject(String code) {
        try {
            return subjects.stream().filter(subject -> subject.getCode().equals(code)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Subject> getSubjects() {
        return subjects;
    }


    public static void main(String[] args) {
        Subject a = new Feature().getSubject("CSDL");
        System.out.println(a.getCode());
    }

    public ResultSet query(String query) throws Exception {
        Connection con = getDBconnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    @Override
    public boolean insertDepartment(Department department) {
        departments.add(department);
        return true;
    }

    @Override
    public void deleteDepartment(Department department) {
        departments.remove(department);
    }

    @Override
    public void insertResult(Result result) {
    }

    @Override
    public void getResult(String studentCode, String subjectCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getAllResultOfStudent(String student) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertSubject(Subject subject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteSubject(Subject subject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Department> departments() {
        return departments;
    }
    

}

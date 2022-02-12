package com.techxtor.jdbcdao.dao;

import com.techxtor.jdbcdao.model.Student;

import java.sql.*;

public class StudentDAO {

    Connection conn = null;

    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
           conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/techxtor",
                    "root",
                    "root");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public Student getStudent(int id) {
        try {
            Student student = new Student();
            student.setUserId(id);
            student.setUserName(getStudentUserName(id));
            System.out.println(student.toString());
            return student;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    // get userName from DB
    public String getStudentUserName(int id) throws SQLException {
        Statement st = conn.createStatement();
        String query = "select userName from student where userId = " + id;
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String name = rs.getString("userName");
        return name;
    }

    //
    public void addStudent(Student s3) throws SQLException {
        String query = "insert into Student values (?,?)";
        PreparedStatement pSt = conn.prepareStatement(query);
        pSt.setInt(1, s3.getUserId());
        pSt.setString(2, s3.getUserName());
        pSt.executeUpdate();


    }
}

package com.techxtor.jdbcdao;

import com.techxtor.jdbcdao.dao.StudentDAO;
import com.techxtor.jdbcdao.model.Student;

import java.sql.SQLException;

public class JdbcDaoDemo {

    public static void main(String[] args) throws SQLException {

        // setup connection
        StudentDAO studentDao = new StudentDAO();
        studentDao.connect();

        // fetch student with id -> 3
        Student student1 = studentDao.getStudent(3);
        System.out.println(student1.getUserName());

        // fetch student with id -> 1
        Student student2 = studentDao.getStudent(1);
        System.out.println(student2.getUserName());

        // add new student to db
        Student student3 = new Student();
        student3.setUserId(5);
        student3.setUserName("Rahul");

        studentDao.addStudent(student3);
    }
}

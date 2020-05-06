package com.app;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        Student student = new Student(1,"Ravi","Yasas","raviyasas@live.com");
        studentDao.saveStudent(student);

        List<Student> students = studentDao.getStudents();
        System.out.println(students);

        studentDao.updateStudent(1,null,null,"rrr@live.com");

        List<Student> students2 = studentDao.getStudents();
        System.out.println(students2);

        studentDao.deleteStudent(1);
        System.out.println(studentDao.getStudents());
    }
}

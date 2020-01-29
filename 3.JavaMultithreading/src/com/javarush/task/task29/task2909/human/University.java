package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;


    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name; }

    public int getAge() {
        return age; }

    public List<Student> getStudents() {
        return students; }

    public void setName(String name) {
        this.name = name;}

    public void setAge(int age) {
        this.age = age; }

    public void setStudents(List<Student> students) {
        this.students = students; }

    public Student getStudentWithAverageGrade(double average) {
        //TODO:
        for (Student student:students) {
            if(student.getAverageGrade()==average){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student = students.get(0);
        for (Student st:students) {
            if(student.getAverageGrade()<st.getAverageGrade()){
                student = st;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student student = students.get(0);
        for (Student st:students) {
            if(student.getAverageGrade()>st.getAverageGrade()){
                student = st;
            }
        }
        return student;
    }

    public void expel(Student student) {
        //TODO:
        if(student == null) return;
        students.remove(student);
    }
}
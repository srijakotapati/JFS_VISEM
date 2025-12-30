package com.skillnext2;

public class Student {

    private int id;
    private String name;
    private String dept;
    private int marks;

    // No-argument constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String name, String dept, int marks) {
        this.name = name;
        this.dept = dept;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [id=" + id +
               ", name=" + name +
               ", dept=" + dept +
               ", marks=" + marks + "]";
    }
}

package com.skillnext2;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String dept;
    private int marks;

    public Student() {}

    public Student(String name, String dept, int marks) {
        this.name = name;
        this.dept = dept;
        this.marks = marks;
    }

    // getters & setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

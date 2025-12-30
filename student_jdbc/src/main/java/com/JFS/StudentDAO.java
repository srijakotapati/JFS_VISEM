package com.skillnext2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2db";
    private static final String USER = "root";
    private static final String PASSWORD = "srija"; // change if needed

    // Add student
    public void addStudent(Student stu) throws Exception {
        String sql = "INSERT INTO student (name, dept, marks) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, stu.getName());
            stmt.setString(2, stu.getDept());
            stmt.setInt(3, stu.getMarks());
            stmt.executeUpdate();
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() throws Exception {
        String sql = "SELECT * FROM student";
        List<Student> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDept(rs.getString("dept"));
                s.setMarks(rs.getInt("marks"));
                list.add(s);
            }
        }
        return list;
    }

    // Delete student
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM student WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Update student
    public void updateStudent(Student stu) throws Exception {
        String sql = "UPDATE student SET name=?, dept=?, marks=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, stu.getName());
            stmt.setString(2, stu.getDept());
            stmt.setInt(3, stu.getMarks());
            stmt.setInt(4, stu.getId());
            stmt.executeUpdate();
        }
    }
}

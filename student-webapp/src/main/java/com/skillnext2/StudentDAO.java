package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.skillnext2.Student;

public class StudentDAO {

    public static void save(Student stu) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skillnext2_db",
                "root",
                "srija"
            );

            String sql = "INSERT INTO employee(name,email,salary) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, stu.getName());
            ps.setString(2, stu.getDept());
            ps.setInt(3, stu.getMarks());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

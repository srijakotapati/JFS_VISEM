package com.skillnext2;

import com.skillnext2.StudentDAO;
import com.skillnext2.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
	 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h2>Student Servlet is WORKING</h2>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String dept = req.getParameter("dept");
        int marks = Int.parseInt(req.getParameter("marks"));

        Student stu = new Student();
        stu.setName(name);
        stu.setDept(dept);
        stu.setMarks(marks);

        StudentDAO.save(stu);

        res.sendRedirect("success.jsp");
    }
}

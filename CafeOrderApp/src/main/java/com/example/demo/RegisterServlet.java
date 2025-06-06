package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String jdbcURL = "jdbc:mysql://localhost:3306/cafeapp";
        String dbUser = "user";
        String dbPassword = "1234";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cafeapp", "user", "1234");

            String sql = "INSERT INTO users (id, name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, password);
            int row = stmt.executeUpdate();

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (row > 0) {
                out.println("<h3>회원가입 성공</h3>");
            } else {
                out.println("<h3>회원가입 실패</h3>");
            }

            conn.close();
            
            response.sendRedirect("success.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
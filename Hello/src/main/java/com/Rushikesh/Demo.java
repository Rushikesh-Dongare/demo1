package com.Rushikesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class Demo extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rushikesh", "root", "Rushikesh");
			
			PreparedStatement ps = con.prepareStatement("select * from demo");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id")+" "+rs.getString("firstname")+" "+rs.getString("lastname"));
				System.out.println();
			}
			
			ps.close();
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		doPost(req, res);
	}
}

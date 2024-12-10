package com.Rushikesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class One {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
}

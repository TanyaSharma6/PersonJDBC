package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.ty.dto.Person;

public class PersonDao {

	public void savePerson(Person p) {
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url);
			
			String query = "Insert into eb8.person values(?,?,?,?,?,?)";
			
			PreparedStatement pstmt= con.prepareStatement(query);

			pstmt.setInt(1,p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setLong(3,p.getPhone());
			pstmt.setString(4, p.getEmail());
			pstmt.setString(5, p.getPassword());
			pstmt.setInt(6, p.getAge());
			
			pstmt.execute();
			
			con.close();
			System.out.println("Data Inserted");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	public void updatePerson(Person p) {
			
		String url ="jdbc:mysql://localhost:3306?user=root&password=root";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url);
			
			String query = "update eb8.person set age=? where name=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, p.getAge());
			pstmt.setString(2, p.getName());
			
			pstmt.executeUpdate();
			
			con.close();
			
			System.out.println("Data Updated");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public void deletePerson(Person p) {
		
		String url ="jdbc:mysql://localhost:3306?user=root&password=root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url);
			
			String query = "delete from eb8.person where name=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, p.getName());
			
			int i=pstmt.executeUpdate();
			
			con.close();
			
			System.out.println(i+" Data Deleted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
	public void getAllData() {
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url);
			
			String query = "select * from eb8.person";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getLong(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getInt(6));
				System.out.println("----------------------------");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	public void getDataById(int id) {
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url);
			
			String query = "Select * from eb8.person where id=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,id);
			
			ResultSet rs =pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getLong(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getInt(6));
			}
			
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	public void validatePerson(Person p) {
		
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url);
			
			String query= "select * from eb8.person where email=? and password=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, p.getEmail());
			pstmt.setString(2, p.getPassword());
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					
					System.out.println("------------------");
					System.out.println("Successfully Matched... Data is available is the Database");
					
					
			}
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
}

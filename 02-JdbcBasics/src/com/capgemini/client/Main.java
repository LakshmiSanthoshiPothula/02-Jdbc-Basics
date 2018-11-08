package com.capgemini.client;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static Connection createConnection() throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/demodb";
		String userName = "root";
		String password = "pass";
		Connection connection = DriverManager.getConnection(dbURL, userName,
				password);
		return connection;

	}

	public static void insertRecord() throws ClassNotFoundException,SQLException {
		Connection connection = createConnection();
		System.out.println("Connected Successfully!!");
		String sql = "insert into Customer values(5,'nani','mumbai',2600.0)";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(sql);
		System.out.println(r + " rows inserted");
		statement.close();
		connection.close();
	}

	public static void updateRecord() throws ClassNotFoundException,SQLException {
		Connection connection = createConnection();
		System.out.println("Connected Successfully!!");
		String sql = "update Customer set c_amt=c_amt+2000 where c_id=1";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(sql);
		System.out.println(r + " rows updated");
		statement.close();
		connection.close();
	}

	public static void deleteRecord() throws ClassNotFoundException,SQLException {
		Connection connection = createConnection();
		System.out.println("Connected Successfully!!");
		String sql = "delete from Customer where c_id=5";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(sql);
		System.out.println(r + " rows inserted");
		statement.close();
		connection.close();
	}

	public static void displayOneRecord(int c_id)throws ClassNotFoundException, SQLException {
		Connection connection = createConnection();
		System.out.println("Connected Successfully!!");
		String sql = "select * from Customer where c_id=" + c_id;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {

			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.println(rs.getDouble(4));
		}
		statement.close();
		connection.close();
	}

	public static void displayAllRecord() throws ClassNotFoundException,SQLException {
		Connection connection = createConnection();
		System.out.println("Connected Successfully!!");
		String sql = "select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.println(rs.getDouble(4));
		}
		statement.close();
		connection.close();
	}

	public static void main(String[] args) throws ClassNotFoundException,SQLException {

		updateRecord();
		displayOneRecord(3);

	}
}

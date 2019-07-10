package com.controller;

import java.sql.*;

public class RegisterBean {

	Connection connection = null;

	public boolean connectDatabase() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/login_authentication";
			String username = "root";
			connection = DriverManager.getConnection(url, username, "Sapient123");
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public boolean register(String username, String password, int age, String department, String designation, String email ) {
		try {
			String login = "insert into user values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, department);
			preparedStatement.setString(5, designation);
			preparedStatement.setString(6, email);
			try {
				preparedStatement.execute();
				return true;
			}catch (Exception e) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

}

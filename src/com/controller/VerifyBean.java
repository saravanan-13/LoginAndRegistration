package com.controller;

import java.sql.*;

public class VerifyBean {

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
			System.out.println(e);
			return false;
		}
	}

	public boolean loginAuthentication(String username, String password) {
		try {
			String login = "select * from user where username = ? and password = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(login);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}
	 

}
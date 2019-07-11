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

	public ResponseObject register(String name, String password, int age, String department, String email) {
		VerifyBean vrBean = new VerifyBean();
		ResponseObject responseObject = new ResponseObject();

		try {
			
			if (vrBean.loginAuthentication(name, password) == false) {
				String login = "insert into user values(?,?,?,?,?)";

				PreparedStatement preparedStatement = connection.prepareStatement(login);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, password);
				preparedStatement.setInt(3, age);
				preparedStatement.setString(4, email);
				preparedStatement.setString(5, department);
				try {
					preparedStatement.execute();
					responseObject.setMessage("Successfully Registered !");
					responseObject.setResult(true);
					return responseObject;
				} catch (Exception e) {
					responseObject.setMessage(e.getMessage());
					responseObject.setResult(false);
					return responseObject;

				}
			} else {
				responseObject.setMessage("Account Already Exists !");
				responseObject.setResult(false);
				return responseObject;

			}

		} catch (Exception e) {
			responseObject.setMessage(e.getMessage());
			responseObject.setResult(false);
			return responseObject;

		}
	}

}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DB;
import model.*;
public class AdminRegisterdao {
	public int registeradmin(Admin admin) throws ClassNotFoundException{
		String INSERT_USERS_SQL="INSERT INTO admin"+"(id,first_name,last_name,username,password,contact,address)VALUES"+"(?,?,?,?,?,?,?);";
		int result=0;
	Class.forName("com.mysql.jdbc.Driver");
	try(Connection con=DB.getConnection();
		PreparedStatement preparedStatement=con.prepareStatement(INSERT_USERS_SQL)){
		preparedStatement.setInt(1,2);
		preparedStatement.setString(2,admin.getFirstname());
		preparedStatement.setString(3,admin.getLastname());
		preparedStatement.setString(4,admin.getUsername());
		preparedStatement.setString(5,admin.getPassword());
		preparedStatement.setString(6,admin.getAddress());
		preparedStatement.setString(7,admin.getContact());
		System.out.println(preparedStatement);
		result=preparedStatement.executeUpdate();		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return result;
	}
}

package dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DB;

import java.sql.ResultSet;
import model.*;

public class LoginDao {
	public boolean validate(Admin admin) throws ClassNotFoundException {
		boolean status=false;
		
		try(Connection con=DB.getConnection();
				PreparedStatement preparedStatement=con.prepareStatement("select * from admin where username=? and password=?")){
				preparedStatement.setString(1,admin.getUsername());
				preparedStatement.setString(2,admin.getPassword());
				System.out.println(preparedStatement);
				ResultSet rs=preparedStatement.executeQuery();
				status=rs.next();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return status;
	};
}

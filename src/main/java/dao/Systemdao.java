package dao;
//import java.util.*;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;
import database.DB;
import model.Product;

public class Systemdao {
	public ArrayList<Product> search(String item)throws ClassNotFoundException{
		try{
			Product product=new Product();
			Connection con=DB.getConnection();	
			PreparedStatement ps=con.prepareStatement("select * from product where item=?");
			ps.setString(1,item);
			ResultSet rs=ps.executeQuery();
			int rows=rs.getRow();
			ArrayList<Product>list=new ArrayList<Product>(rows);	
			while(rs.next()) {
		    	product.setItem(rs.getString("item"));
		        product.setPrice(rs.getString("price"));
		        product.setAmount(rs.getString("amount"));
		        product.setColor(rs.getString("color"));
		        list.add(product);
			}
		    con.close();
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public ResultSet view()throws ClassNotFoundException{
//		try{
//			Connection con=DB.getConnection();
//			PreparedStatement ps=con.prepareStatement("select * from product");
//		    ResultSet rs=ps.executeQuery();
//	        con.close();
//	        return rs;
//	    }catch(SQLException e) {
//	e.printStackTrace();
//}     
	public List<Product> view()throws ClassNotFoundException{
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from product");
		    ResultSet rs=ps.executeQuery();
			int rows=rs.getRow();
			List<Product>list=new ArrayList<Product>(rows);	
			while(rs.next()){
				Product product=new Product();
				product.setItem(rs.getString("item"));
		        product.setPrice(rs.getString("price"));
		        product.setAmount(rs.getString("amount"));
		        product.setColor(rs.getString("color"));
		        list.add(product);
			}
			con.close();			
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean insert(Product product)throws ClassNotFoundException{
		boolean result=false;
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into product(item,price,amount,color) values(?,?,?,?)");
			ps.setString(1,product.getItem());
			ps.setString(2,product.getPrice());
			ps.setString(3,product.getAmount());
			ps.setString(4,product.getColor());
			status=ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		result=status==0?false:true;
		return result;
	}
	public boolean update(Product product)throws ClassNotFoundException{
		boolean result=false;
		int status=0;		
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("update product set item=?,price=?,amount=?,color=? where item=?");
			ps.setString(1,product.getItem());
			ps.setString(2,product.getPrice());
			ps.setString(3,product.getAmount());
			ps.setString(4,product.getColor());
			ps.setString(5,product.getItem());
			status=ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		result=status==0?false:true;
		return result;
	}
	
	public static boolean delete(int id)throws ClassNotFoundException{
		int status=0;
		boolean result=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from product where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		result=status==0?false:true;
		return result;
	}
	public static boolean truncate()throws ClassNotFoundException{
		int status=0;
		boolean result=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("truncate table product");
			status=ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		result=status==0?false:true;
		return result;
	}
	public ArrayList<String> distinct()throws ClassNotFoundException{
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select distinct item from product");
			ResultSet rs=ps.executeQuery();
			int rows=rs.getRow();
			ArrayList<String>list=new ArrayList<String>(rows);	
			while(rs.next()){
		        list.add(rs.getString("item"));
			}
			con.close();
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.nareshit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.nareshit.bean.Product;
public class ProductDAOImpl 
implements ProductDAO{
@Override
public List<Product> searchProducts(double minPrice,
		double maxPrice) {
List<Product> list=new ArrayList<>();	
	try{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/angularjs_cls";
String un="root";
String pwd="root";
Connection con=
DriverManager.getConnection(url,un,pwd);
String sql="select productId,productName,price from Product_details where price>=? and price<=?";
PreparedStatement pst=con.prepareStatement(sql);
   pst.setDouble(1,minPrice);
   pst.setDouble(2,maxPrice);
   ResultSet rs=pst.executeQuery();
   while(rs.next()){
  Product product=new Product();
  product.setProductId(rs.getInt(1));
  product.setProductName(rs.getString(2));
  product.setPrice(rs.getDouble(3));
  //add product obj into list
  list.add(product);
   }
	}catch(SQLException se){
se.printStackTrace();		
	}
	catch(ClassNotFoundException ce){
	ce.printStackTrace();	
	}
		return list;
	}

}

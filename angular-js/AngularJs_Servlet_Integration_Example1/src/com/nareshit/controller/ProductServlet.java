package com.nareshit.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nareshit.service.ProductService;
import com.nareshit.service.ProductServiceImpl;
public class ProductServlet 
extends HttpServlet{
private ProductService productService;
public void init(){
productService=new ProductServiceImpl();	
}
public void doGet(HttpServletRequest req,
		HttpServletResponse res)
throws ServletException,IOException{
//gather request parameters
double minPrice=
Double.parseDouble(req.getParameter("minPrice"));	
double maxPrice=Double.parseDouble(req.getParameter("maxPrice"));
//create ProductService obj,call service method
  String jsonProductsList
  =productService.searchProducts(minPrice,maxPrice);
System.out.println(jsonProductsList);
  //service method returns jsonProductList
//set ContentType mediatype as application/json
res.setContentType("application/json");
PrintWriter out=res.getWriter();
   out.write(jsonProductsList);
}
}






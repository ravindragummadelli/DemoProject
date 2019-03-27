package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.Product;
import com.nareshit.dao.ProductDAO;
import com.nareshit.dao.ProductDAOImpl;
import com.nareshit.util.JsonUtil;

public class ProductServiceImpl 
implements ProductService{
	@Override
public String searchProducts(double minPrice, double maxPrice) {
//create ProductDAO obj
ProductDAO productDAO=new ProductDAOImpl();		
//call productDAO method,it returns list
   List<Product> list=productDAO.searchProducts(minPrice,maxPrice);
//convert list obj into json by using jack-son API
  String jsonProductsList=
		 JsonUtil.convertJavaToJson(list);
   
//return json
		return jsonProductsList;
	}
	
}

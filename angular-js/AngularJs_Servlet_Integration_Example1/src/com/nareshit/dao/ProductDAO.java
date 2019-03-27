package com.nareshit.dao;

import java.util.List;

import com.nareshit.bean.Product;

public interface ProductDAO {
public List<Product> 
searchProducts(double minPrice,double maxPrice);
}

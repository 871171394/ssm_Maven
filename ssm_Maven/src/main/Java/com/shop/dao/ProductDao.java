package com.shop.dao;

import java.util.List;

import com.shop.domian.Product;

public interface ProductDao {

    public List<Product> getProductList();

    Product getProductById(Integer id);

    int updateProduct(Product product);

}

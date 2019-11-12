package com.shop.dao.impl;

import com.shop.dao.ProductDao;
import com.shop.domian.Product;
import com.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList() {
        List<Product> products = productMapper.selectByExampleWithBLOBs(null);
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public int updateProduct(Product product) {

        return productMapper.updateByPrimaryKeyWithBLOBs(product);
    }
}

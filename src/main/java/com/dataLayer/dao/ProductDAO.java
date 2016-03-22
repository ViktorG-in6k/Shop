package com.dataLayer.dao;

import com.model.categories;
import com.model.product;

import java.util.List;

public interface ProductDAO {
    public void save(product prod);
    public product getProduct(long id);
    public List<product> getProductsFromCategory(categories categ);
    public product getProductByName(String name);
    public List<product> getAllProducts();
}

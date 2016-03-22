package com.serviceLayer.service;

import com.dataLayer.implementations.ProductDAOImpl;
import com.model.categories;
import com.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public void saveProduct(product p);

    public product getProduct(long id);

    public List<product> getProductsFromCategory(categories categ);

    public product getProductByName(String name);

    public List<product> getAllProducts();

}
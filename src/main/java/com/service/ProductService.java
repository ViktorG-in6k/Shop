package com.service;

import com.dao.ProductDAO;
import com.model.categories;
import com.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public void saveProduct(product us){
        productDAO.save(us);
    }

    public product getProduct(long id){
        return productDAO.getProduct(id);
    }

    public List<product> getProductsFromCategory(categories categ){
        return productDAO.getProductsFromCategory(categ);
    }

    public product getProductByName(String name){
        return productDAO.getProductByName(name);
    }

    public List<product> getAllProducts(){
        return productDAO.getAllProducts();
    }

}
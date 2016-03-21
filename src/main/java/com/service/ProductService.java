package com.service;

import com.dao.ProductRepository;
import com.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by employee on 3/17/16.
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void saveProduct(product us){
        productRepository.save(us);
    }

    public product getProduct(long id){
        return productRepository.getProduct(id);
    }
}

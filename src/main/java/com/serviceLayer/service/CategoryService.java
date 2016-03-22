package com.serviceLayer.service;

import com.dataLayer.implementations.CategoryDAOImpl;
import com.model.categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    public void saveCategory(categories us);

    public categories getCategory(long id);

    public categories getCategoryByName(String name);

    public List<categories> getAllCategory();

}
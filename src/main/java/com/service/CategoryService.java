package com.service;

import com.dao.CategoryDAO;
import com.model.categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public void saveCategory(categories us){
        categoryDAO.save(us);
    }

    public categories getCategory(long id){
        return categoryDAO.getCategory(id);
    }

    public categories getCategoryByName(String name){
        return categoryDAO.getCategoryByName(name);
    }

    public List<categories> getAllCategory(){
        return categoryDAO.getAll();
    }

}
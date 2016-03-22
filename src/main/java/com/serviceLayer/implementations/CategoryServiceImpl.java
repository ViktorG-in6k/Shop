package com.serviceLayer.implementations;

import com.dataLayer.dao.CategoryDAO;
import com.model.categories;
import com.serviceLayer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

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
package com.service;

import com.dao.CategoryRepository;
import com.model.categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoriesRepository;

    public void saveCategory(categories us){
        categoriesRepository.save(us);
    }

    public categories getCategory(long id){
        return categoriesRepository.getCategory(id);
    }
}

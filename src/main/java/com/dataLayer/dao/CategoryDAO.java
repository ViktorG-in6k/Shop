package com.dataLayer.dao;

import com.model.categories;

import java.util.List;

public interface CategoryDAO {
    public void save(categories category);
    public categories getCategory(long id);
    public categories getCategoryByName(String name);
    public List<categories> getAll();
    public void addNewCategory();
}

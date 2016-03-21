package com.dao;

import com.model.categories;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryRepository {
    @Autowired
    SessionFactory sf;

    public void save(categories category){
        Session session = sf.getCurrentSession();
        session.save(category);
    }

    public categories getCategory(long id) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from categories where id = :id");

        if((categories) query.setLong("id",id).uniqueResult()!=null) {
            return (categories) query.setLong("id",id).uniqueResult();
        }
        else{
            categories k = new categories("null");
            return k;
        }
    }

    public categories getCategoryByName(String name) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from  categories where name = :name");
        return (categories) query.setString("name" ,name).uniqueResult();
    }
}

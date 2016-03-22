package com.dataLayer.implementations;

import com.dataLayer.dao.CategoryDAO;
import com.model.categories;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(categories category){
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    public categories getCategory(long id) {
        Session session = sessionFactory.getCurrentSession();
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
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from  categories where name = :name");
        return (categories) query.setString("name" ,name).uniqueResult();
    }

    protected static Logger logger = Logger.getLogger("service");

    public List<categories> getAll() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("FROM  categories ").list();
    }

    public void addNewCategory(){
        int i = 1;
        ArrayList<categories> categories = new ArrayList<categories>();
        String s = "null";
        while(!s.equals(getCategory(i).getName())) {
            categories.add(getCategory(i));
            i++;
        }
    }
}

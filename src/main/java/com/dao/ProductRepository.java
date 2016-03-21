package com.dao;

import com.model.categories;
import com.model.product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ProductRepository {
    @Autowired
    SessionFactory sf;

    public void save(product prod){
        Session session = sf.getCurrentSession();
        session.save(prod);
    }

    public product getProduct(long id) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from product where id = :id");

        if((product) query.setLong("id",id).uniqueResult()!=null) {
            System.out.println( ((product) query.setLong("id",id).uniqueResult()).getName());
            return (product) query.setLong("id",id).uniqueResult();
        }
        else{
            product k = new product("null");
            return k;
        }
    }

    public List<product> getProducts(categories categ) {

        Session session = sf.openSession();
        Query query = session.createQuery("from product where categori_id = :categ");

        if(query.setEntity("categ",categ).list()!=null) {
            return (query.setEntity("categ",categ).list());
        }
        else{
            return null;
        }
    }

    public product getProductByName(String name) {
        Session session = sf.getCurrentSession();

        Query query = session.createQuery("from  product where name = :name");
        return (product) query.setString("name" ,name).uniqueResult();
    }
}
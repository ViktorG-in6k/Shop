package com.dataLayer.implementations;

import com.dataLayer.dao.ProductDAO;
import com.model.categories;
import com.model.product;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(product prod){
        sessionFactory.getCurrentSession().save(prod);
    }

    public product getProduct(long id) {
        Session session = sessionFactory.getCurrentSession();
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

    public List<product> getProductsFromCategory(categories categ) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from product where category_id = :categ");
        System.out.println(categ);
        if(query.setEntity("categ",categ).list()!=null) {
            return (query.setEntity("categ",categ).list());
        }
        else{
            return null;
        }
    }

    public product getProductByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from  product where name = :name");
        return (product) query.setString("name" ,name).uniqueResult();
    }



    protected static Logger logger = Logger.getLogger("service");

    public List<product> getAllProducts() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("FROM  product").list();
    }
}
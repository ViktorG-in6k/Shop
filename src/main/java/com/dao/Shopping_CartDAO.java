package com.dao;

import com.model.shopping_cart;
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
public class Shopping_CartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public shopping_cart getShoppingCartOfUser(int id) {

        Session session =sessionFactory.openSession();
        Query query = session.createQuery("from shopping_cart where user_id = :id");

        if(query.setInteger("id",id)!=null) {
            return (shopping_cart) query.setInteger("id",id);
        }
        else{
            return null;
        }
    }
    protected static Logger logger = Logger.getLogger("service");
    public List<shopping_cart> getAllShoppingCarts() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("FROM  shopping_cart ").list();
    }




//    public List<shopping_cart> getAllShoppingCarts() {
//
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("from shopping_cart");
//
//        if(query.list()!=null) {
//            ArrayList<shopping_cart>products= (ArrayList<shopping_cart>) query.list();
//            return products;
//        }
//        else{
//            return null;
//        }
//    }

    public void save(shopping_cart shopping_Cart){
        Session session = sessionFactory.getCurrentSession();
        session.save(shopping_Cart);
    }
}

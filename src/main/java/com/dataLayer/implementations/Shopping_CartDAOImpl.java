package com.dataLayer.implementations;

import com.dataLayer.dao.Shopping_CartDAO;
import com.model.product;
import com.model.shopping_cart;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class Shopping_CartDAOImpl implements Shopping_CartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected static Logger logger = Logger.getLogger("service");

    public List<shopping_cart> getAllShoppingCarts() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.openSession();
        return  session.createQuery("FROM  shopping_cart ").list();
    }

    public void save(shopping_cart shopping_Cart){
        Session session = sessionFactory.openSession();
        session.save(shopping_Cart);
        session.save(shopping_Cart.getProducts());
    }
}

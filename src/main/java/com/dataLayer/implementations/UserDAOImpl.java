package com.dataLayer.implementations;

import com.dataLayer.dao.UserDAO;
import com.model.user;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(user us){
        Session session = sessionFactory.getCurrentSession();
        session.save(us);
    }

    public user getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where id = :id");
        if((user) query.setLong("id",id).uniqueResult()!=null) {
            return (user) query.setLong("id", id).uniqueResult();
        }
        else{
            return null;
        }
    }

    public user getUser(String number) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where number = :number");
        if((user) query.setString("number",number).uniqueResult()!=null) {
            return (user) query.setString("number", number).uniqueResult();
        }
        else{
            return null;
        }
    }

    public user getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from  user where name = :name");
        return (user) query.setString("name" ,name).uniqueResult();
    }

    public List<user> getUsers() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user");

        if(query.list()!=null) {
            return (query.list());
        }
        else{
            return null;
        }
    }

    protected static Logger logger = Logger.getLogger("service");

    public List<user> getAllUsers() {
        logger.debug("Retrieving all persons");
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("FROM  user").list();
    }



}

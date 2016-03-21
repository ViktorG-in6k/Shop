package com.service;

import com.dao.UserDAO;
import com.model.user;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    UserDAO userDAO;

    public void savePerson(user us){
        userDAO.save(us);
    }

    public user getPerson(long id){
       return userDAO.getUser(id);
    }

    public user get(Integer id ) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        user person = (user) session.get( user.class, id);

        return person;
    }
    protected static Logger logger = Logger.getLogger("service");
    public List<user> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)

        // Retrieve all
        return  session.createQuery("FROM  user").list();
    }

}

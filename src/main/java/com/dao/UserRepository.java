package com.dao;

import com.model.user;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepository {

    @Autowired
    SessionFactory sf;

    public void save(user us){
        Session session = sf.getCurrentSession();
        session.save(us);
    }

    public user getPerson(long id) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from user where id = :id");
        if((user) query.setLong("id",id).uniqueResult()!=null) {
            return (user) query.setLong("id", id).uniqueResult();
        }
        else{
            user k = new user("null");
            return k;
        }
    }

    public user getPersonByName(String name) {
        Session session = sf.getCurrentSession();
        Query query = session.createQuery("from  user where name = :name");
        return (user) query.setString("name" ,name).uniqueResult();
    }

}

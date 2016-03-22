package com.serviceLayer.implementations;

import com.dataLayer.dao.UserDAO;
import com.dataLayer.implementations.UserDAOImpl;
import com.model.user;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    public void saveUser(user us){
        if(getUser(us.getNumber())==null) {
            userDAO.save(us);
        }
    }

    public user getUser(long id){
        return userDAO.getUser(id);
    }

    public user getUser(String number){
        return userDAO.getUser(number);
    }

    public List<user> getAllUsers(){
        return userDAO.getAllUsers();
    }



}
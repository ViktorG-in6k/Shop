package com.service;

import com.dao.UserDAO;
import com.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void saveUser(user us){
        userDAO.save(us);
    }

    public user getUser(long id){
        return userDAO.getUser(id);
    }

    public List<user> getAllUsers(){
        return userDAO.getAllUsers();
    }



}
package com.serviceLayer.service;

import com.dataLayer.implementations.UserDAOImpl;
import com.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public void saveUser(user us);

    public user getUser(long id);

    public user getUser(String number);

    public List<user> getAllUsers();

}
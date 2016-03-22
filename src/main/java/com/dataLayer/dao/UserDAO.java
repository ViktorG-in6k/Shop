package com.dataLayer.dao;

import com.model.user;

import java.util.List;

public interface UserDAO {
    public void save(user us);
    public user getUser(long id);
    public user getUser(String number);
    public user getUserByName(String name);
    public List<user> getUsers();
    public List<user> getAllUsers();

}

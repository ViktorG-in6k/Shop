package com.serviceLayer.service;

import com.dataLayer.implementations.Shopping_CartDAOImpl;
import com.model.shopping_cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Shopping_CartService {

    public void saveShopping_Cart(shopping_cart us);



  //  public shopping_cart getShoppingCartOfUser(String number);

    public List<shopping_cart> getAllShoppingCarts();


}
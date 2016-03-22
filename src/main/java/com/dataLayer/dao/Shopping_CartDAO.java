package com.dataLayer.dao;

import com.model.shopping_cart;

import java.util.List;

public interface Shopping_CartDAO {

 //   public shopping_cart getShoppingCartOfUser(String number);
    public List<shopping_cart> getAllShoppingCarts();
    public void save(shopping_cart shopping_Cart);
}

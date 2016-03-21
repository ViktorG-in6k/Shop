package com.service;

import com.dao.Shopping_CartDAO;
import com.model.shopping_cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Shopping_CartService {

    @Autowired
    Shopping_CartDAO shopping_CartDAO;

    public void saveShopping_Cart(shopping_cart us){
        shopping_CartDAO.save(us);
    }

    public shopping_cart getShoppingCartOfUser(int id)  {
        return  shopping_CartDAO.getShoppingCartOfUser(id);
    }

    public List<shopping_cart> getAllShoppingCarts()  {
        return  shopping_CartDAO.getAllShoppingCarts();
    }


}
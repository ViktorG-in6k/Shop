package com.serviceLayer.implementations;

import com.dataLayer.dao.Shopping_CartDAO;
import com.model.shopping_cart;
import com.serviceLayer.service.Shopping_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Shopping_CartServiceImpl implements Shopping_CartService{

    @Autowired
    Shopping_CartDAO shopping_cartDAO;

    public void saveShopping_Cart(shopping_cart us){
        shopping_cartDAO.save(us);
    }



//    public shopping_cart getShoppingCartOfUser(String number){
//        return  shopping_cartDAO.getShoppingCartOfUser(number);
//    }

    public List<shopping_cart> getAllShoppingCarts()  {
        return  shopping_cartDAO.getAllShoppingCarts();
    }


}
package com.controllers;

import com.Classes.DataForShoppingCart;
import com.Classes.Order;
import com.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes(value = "product")
public class SessionController {

    @RequestMapping(value = "/shopping_cart")
    public String getShoppingCart(HttpSession session)
    {
        Order order = (Order) session.getAttribute("order");
        System.out.println(order.getOrder().size());
        return "shopping_cart";
    }

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = "/add")
    public String addToOrder(HttpSession session, HttpServletRequest req, @RequestParam("product") int id) {
        Order order;
        if(session.getAttribute("order")==null){
            order = new Order();
        }
        else{
            order = (Order) session.getAttribute("order");
        }
        order.addToOrder(new DataForShoppingCart(productDAO.getProduct(id),1));

        session.setAttribute("order",order);
        System.out.println(order.getTotalPrice());
        System.out.println(order.getOrder().size());
        String ref  = req.getHeader("Referer");
        return "redirect:"+ref;
    }

    @RequestMapping(value = "/rec")
    public String recount(HttpSession session, @RequestParam("product_id") int id,@RequestParam("product_count") int count) {
        Order order = (Order) session.getAttribute("order");


        for (DataForShoppingCart aDataForShoppingCart : order.getOrder()) {
            if (aDataForShoppingCart.getProd().getId() == id) {
                if(count<1){
                    order.getOrder().remove(aDataForShoppingCart);
                }
                else {
                    aDataForShoppingCart.setCountOfProducts(count);
                }
                order.rePrice();

            }
        }
        System.out.println(order.getOrder().size());
        session.setAttribute("order",order);
        return "shopping_cart";
    }
}

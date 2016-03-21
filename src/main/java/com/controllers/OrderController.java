package com.controllers;

import com.Classes.Order;
import com.model.categories;
import com.model.product;
import com.model.shopping_cart;
import com.service.CategoryService;
import com.service.Shopping_CartService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avatarion on 3/21/16.
 */
@Controller
public class OrderController {
    @Autowired
    Shopping_CartService shopping_cartService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/order")
    public String getNew() {
        return "order";
    }

    @RequestMapping(value = "/create")
    public String create(HttpServletRequest req, HttpSession session) {
        String name = req.getParameter("userName");
        String number = req.getParameter("userNumber");

        Order order = (Order) session.getAttribute("order");
        System.out.println(order.getOrder().size());
        session.removeAttribute("order");

        ArrayList<categories> categories = (ArrayList<com.model.categories>) categoryService.getAllCategory();
        session.setAttribute("data",categories);

        return "hello";
    }

    @RequestMapping(value = "/allUsers")
    public String getUsers()
    {
        List<shopping_cart> userList = shopping_cartService.getAllShoppingCarts();
        for (shopping_cart u: userList) {
            product[] arr =   u.getProductsList().toArray(new product[u.getProductsList().size()]);
            for (product a: arr){
                System.out.println(a.getName()+" ");
            }
            System.out.println(u.getId()+" ");
        }
        return "order";
    }

//    @RequestMapping(value = "/allOrders")
//    public String getOrders()
//    {
//        List<user> userList = .getUsers();
//        for (user u: userList) {
//            System.out.print(u.getId()+" ");
//            System.out.println(u.getName());
//        }
//        return "order";
//    }
}

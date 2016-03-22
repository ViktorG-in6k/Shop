package com.controllers;

import com.Classes.DataForShoppingCart;
import com.Classes.Order;
import com.model.categories;
import com.model.product;
import com.model.shopping_cart;
import com.model.user;
import com.serviceLayer.service.CategoryService;
import com.serviceLayer.service.Shopping_CartService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        userService.saveUser(new user(name,number));
        Order order = (Order) session.getAttribute("order");
        //ArrayList<DataForShoppingCart> shopping_carts = order.getOrder();
        List<product>products = new ArrayList<product>();
        ArrayList<DataForShoppingCart> shopping_carts = order.getOrder();
        for (DataForShoppingCart s: shopping_carts) {
            for(int i = 0;i<s.getCountOfProducts();i++){
                System.out.println(s.getProd().getName());
                products.add(s.getProd());
            }
        }
        java.util.Date date = new Date();
        shopping_cartService.saveShopping_Cart(new shopping_cart(number, products, new java.sql.Timestamp(date.getTime())));
        System.out.println(shopping_carts);

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
            List<product> arr =   u.getProducts();
            for (product a: arr){
                System.out.println(a.getName()+"c ");
            }
            System.out.println(u.getId()+"b ");
            System.out.println(arr.size()+"l ");
        }
        System.out.println(userList.size()+"a ");
        return "order";
    }

}

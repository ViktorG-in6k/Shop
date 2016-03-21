package com.controllers;

import com.model.categories;
import com.model.product;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;



    @RequestMapping(value = "/")
    public String getMain(HttpSession session) {
        ArrayList<categories> categories = (ArrayList<com.model.categories>) categoryService.getAllCategory();
        session.setAttribute("data",categories);
        return "hello";
    }

    @RequestMapping(value = "/{id}")
    public String getProductsOfCategory(HttpSession session, @PathVariable ("id") String id) {
        List<product> products= productService.getProductsFromCategory(categoryService.getCategoryByName(id));
        session.setAttribute("data",products);
        return "page";
    }

    @RequestMapping(value = "/*/{name}")
    public String getProduct(HttpSession session,@PathVariable ("name") String name) {
        product prod= productService.getProductByName(name);
        session.setAttribute("product",prod);
        return "product";
    }

    @RequestMapping(value = "/new")
    public String getNew() {
        return "new";
    }
}

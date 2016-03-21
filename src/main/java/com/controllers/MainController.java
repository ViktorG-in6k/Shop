package com.controllers;

import com.dao.CategoryRepository;
import com.dao.ProductRepository;
import com.model.categories;
import com.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/")
    public String getMain(HttpSession session) {
        int i = 1;
        ArrayList<categories> categories = new ArrayList<categories>();
        String s = "null";
        while(!s.equals(categoryRepository.getCategory(i).getName())) {
            categories.add(categoryRepository.getCategory(i));
            i++;
        }
        session.setAttribute("data",categories);
        return "hello";
    }

    @RequestMapping(value = "/{id}")
    public String getProductsOfCategory(HttpSession session, @PathVariable ("id") String id) {
        categories categ = categoryRepository.getCategoryByName(id);
        List<product> products=productRepository.getProducts(categ);
        session.setAttribute("data",products);
        return "page";
    }

    @RequestMapping(value = "/*/{name}")
    public String getProduct(HttpSession session,@PathVariable ("name") String name) {
        product prod=productRepository.getProductByName(name);
        session.setAttribute("product",prod);
        return "product";
    }

    @RequestMapping(value = "/new")
    public String getNew() {
        return "new";
    }
}

package com.psl.demoProj.controller;


import java.util.ArrayList;
import java.util.List;

import com.psl.demoProj.modal.Products;
import com.psl.demoProj.auth.models.User;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("test")
public class TestController {

    private static List<Products> list = new ArrayList<>();
    static {
        list.add(new Products(1,"Allegra 180","Allopathy",180,100));
        list.add(new Products(2,"Cough syrup","Allopathy",18,130));
        list.add(new Products(3,"Dettol liquid","Allopathy",10,40));
        list.add(new Products(4,"Vitamin C meds","Allopathy",50,70));
        list.add(new Products(5,"Patanjali crap","Homeopathy",100,1));
        list.add(new Products(6,"Cow dung","Homeopathy",1800,10));
        list.add(new Products(7,"Eno","Allopathy",5,25));
    }

    @GetMapping("products")
    public List<Products> getAllProducts() {
        return list;
    }

    @GetMapping("products/category/{name}")
    public List<Products> getByCategory(@PathVariable("name") String name) {
        List<Products> pro = new ArrayList<>();
        for(Products p:list) {
            System.out.println(p.getCategory());
            if(p.getCategory().equals(name)) {
                pro.add(p);
            }
        }
        System.out.println(pro);
        return pro;
    }

    @GetMapping("products/{id}")
    public Products getById(@PathVariable("id") int id) {
        for(Products p: list) {
            if(p.getId() == id) {
                return p;
            }
        }
        return new Products();
    }

    @GetMapping("products/testing")
    public ResponseEntity<User> Authtest(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok(user);

    }
}


/*
 /products
 /products/{category}
 /products/{id}

 */

package com.psl.demoProj.controller;

import com.psl.demoProj.modal.Products;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sec")
public class PublicControllers {
    @GetMapping("test")
    ResponseEntity<String> getPublic() {
        return ResponseEntity.ok("ok");
    }
    @GetMapping("product")
    ResponseEntity<Products>  getProduct() {
        Products products=new Products(1,"name","cat",100,100);

        return ResponseEntity.ok(products);

    }
}

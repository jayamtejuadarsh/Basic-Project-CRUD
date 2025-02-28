package org.example.ecommerceclothapp2k25.controllers;


import org.example.ecommerceclothapp2k25.models.Product;
import org.example.ecommerceclothapp2k25.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("website")
public class ProductController {

        @Autowired
        private IProductService iproductService;

        @GetMapping("/products")
        public ResponseEntity<List<Product>> getProducts() {
            return new ResponseEntity<>(iproductService.getProducts(),HttpStatus.OK);
        }

        @GetMapping("/products/{id}")
        public Product getProductById(@PathVariable int id)
        {
            return iproductService.getProductById(id);
        }

        @PostMapping("/send")
        public ResponseEntity<String> sendProduct(@RequestBody Product prod) {
        String name=iproductService.sendProduct(prod);
            return new ResponseEntity<> (name,HttpStatus.OK);
        }

        @PostMapping("/sendall")
        public  ResponseEntity<List<Product>> sendAllProducts(@RequestBody List<Product> prods) {

            return new ResponseEntity<>(iproductService.sendAllProducts(prods),HttpStatus.CREATED);
        }

        @PutMapping("/products/{id}")
        public void putProduct(@PathVariable int id,@RequestBody Product prod) {
            iproductService.putProduct(id,prod);
        }

        @DeleteMapping("/products/{id}")
        public void deleteProductById(@PathVariable int id)
        {
            iproductService.deleteProductById(id);
        }
        @DeleteMapping("/batch")
        public void deleteAllProducts(@RequestBody List<Integer> ids)
        {
            iproductService.deleteAllProducts(ids);
        }

    }

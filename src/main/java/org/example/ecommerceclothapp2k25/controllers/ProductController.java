package org.example.ecommerceclothapp2k25.controllers;

import org.example.ecommerceclothapp2k25.dtos.CategoryDto;
import org.example.ecommerceclothapp2k25.dtos.ProductDto;
import org.example.ecommerceclothapp2k25.models.Category;
import org.example.ecommerceclothapp2k25.models.Product;
import org.example.ecommerceclothapp2k25.models.State;
import org.example.ecommerceclothapp2k25.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins = "http://localhost:3000")  // Allow frontend access
@RestController
@RequestMapping("e-commerce/fashion/category")
public class ProductController {

        @Autowired
        private IProductService iproductService;

        // http://localhost:8082/Products/e-commerce/getproducts
        // http://localhost:8082/getproducts
        //get api,GetMapping -->we can test all get api's through browser
        @GetMapping("/getproducts")
        public List<Product> getAllProducts() {
            Product pr = new Product();
            pr.setId(2L);
            pr.setName("Iphone");
            pr.setDescription("Iphone 16 new version");
            pr.setPrice(50000.00);
            pr.setCreated_at(new Date());
            pr.setModified_at(new Date());
            pr.setState(State.Active);

            List<Product> listproduct = new ArrayList<>();
            listproduct.add(pr);
            return listproduct;

        }

        // bind query parameters from a URL to a method parameter in a controller
        @GetMapping("/pr")
        public Product getProductByName(@RequestParam String productname) {
            Product pr = new Product();
            pr.setName(productname);//request param we can pass query parametres extract get results
            return pr;
        }


    /* post req-->http://localhost:8083/Products/e-commerce/createproduct req-->{
        "id": 10,
        "name": "laptop",
        "price": 50999.95,
        "category": {
            "id":12,
          "name":"electronics"

        }
}  res:->D:\Documents\DSA-SQL-LLD-notes-scaler\Java-SpringBoot-project\ProductCatalog-ServiceDec24\src\main\java\org\example\productcatalogservicedec24\Controllers\ProductController.java */
        @PostMapping("/createproduct")
        public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto prd) {
            Product pr = convertprdtoprd(prd);
            Product prductsve = iproductService.saveProduct(pr);
            return ResponseEntity.status(HttpStatus.CREATED).body(from(prductsve));

            //save to db/jpa/hibernate
            // return ResponseEntity.status(HttpStatus.CREATED).body(prd);
        }


        //http://localhost:8082/Products/e-commerce/222  --->got 400Bad Request
        @GetMapping("{productid}")
        public ResponseEntity<ProductDto> getProductById(@PathVariable Long productid) {
            try {
                MultiValueMap<String, String> headers = new LinkedMultiValueMap();//for multi value header

                if (productid <= 0) {
                    headers.add("called by", "fool");
                    //return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
                    throw new IllegalArgumentException("please try with product greater than 0");
                }
                //we are calling get 3rd party api using productservice inteface getprdbyid
                Product prd = iproductService.getProductById(productid);//using interface we are calling getprdid
                headers.add("called by", "iintelligent");//for some meta data to client/user
                if (prd == null) return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(from(prd), headers, HttpStatus.OK);
            } catch (IllegalArgumentException ex) {
                throw ex;
            }
        }

        //getall roducts api from3rd api fskestoreapi
        @GetMapping("/products")
        public ResponseEntity<List<ProductDto>> getProductsAll() {
            try {
                MultiValueMap<String, String> headers = new LinkedMultiValueMap();//for multi value header
                List<ProductDto> prddto = new ArrayList<>();//output response
                List<Product> prd = iproductService.getProductsAll();
                if (prd == null) {
                    headers.add("called by", "fool");
                    throw new IllegalArgumentException("there are no products in this category.");
                }
                //iterating for loop here
                for (Product pr : prd) {
                    prddto.add(from(pr));//one by one add to prddto than convert into prd to prddto object
                }
                headers.add("called by", "iintelligent");//for some meta data to client/user
                return new ResponseEntity<>(prddto, headers, HttpStatus.OK);
            } catch (IllegalArgumentException ex) {
                throw ex;
            }
        }

        //using object mapper converting object to objectdto
        public ProductDto from(Product product) {
            ProductDto productdto = new ProductDto();
            productdto.setId(product.getId());
            productdto.setDescription(product.getDescription());
            productdto.setPrice(product.getPrice());
            productdto.setImage(product.getImageUrl());
            productdto.setCreated_at(new Date());
            productdto.setName(product.getName());
            if (product.getCategory() != null) {
                CategoryDto cat = new CategoryDto();
                cat.setName(product.getCategory().getName());
                cat.setId(product.getCategory().getId());
                cat.setCreated_at(new Date());

                cat.setDescription(product.getCategory().getDescription());
                productdto.setCategoryDto(cat);
            }
            return productdto;

        }

        //using object mapper converting json to json object /prddto to prd object
        public Product convertprdtoprd(ProductDto productdto) {
            Product product = new Product();
            product.setId(productdto.getId());
            product.setDescription(productdto.getDescription());
            product.setPrice(productdto.getPrice());
            product.setCreated_at(new Date());
            product.setName(productdto.getName());
            if (productdto.getCat() != null) {
                Category cat = new Category();
                cat.setName(productdto.getName());
                cat.setId(productdto.getId());
                cat.setDescription(productdto.getDescription());
                product.setCategory(cat);
            }
            return product;

        }
    @GetMapping("prodct1")
    public String getProduct() {
        //Product pr = new Product();
        //pr.setName(productname);//request param we can pass query parametres extract get results
        return "hello surya";
    }
    }

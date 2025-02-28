package org.example.ecommerceclothapp2k25.services;
import org.example.ecommerceclothapp2k25.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//interface has abstract methods for loose coupling
public interface IProductService {


  String sendProduct(Product prod);

    List<Product> getProducts();

    Product getProductById(int id);

    void putProduct(int id,Product prod);

  void deleteProductById(int id);

  void deleteAllProducts(List<Integer> ids);

  List<Product> sendAllProducts(List<Product> prods);
}

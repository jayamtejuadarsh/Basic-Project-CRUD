package org.example.ecommerceclothapp2k25.services;
import org.example.ecommerceclothapp2k25.models.Product;
import java.util.List;

//interface has abstract methods for loose coupling
public interface IProductService {
    Product getProductById(Long id);

    List<Product> getProductsAll();

    Product saveProduct(Product product);

    Product saveUser(Product product);

    //Product replaceProductById(Long id, Product product);

}

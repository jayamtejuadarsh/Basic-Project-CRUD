package org.example.ecommerceclothapp2k25.services;
import org.example.ecommerceclothapp2k25.models.Product;
import org.example.ecommerceclothapp2k25.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Primary
@Service //service act as business logic and to specify whih bean to choose when mult beans exist with same type
public class StorageProductService implements IProductService {

    @Autowired
     private ProductRepo productRepo;

    @Override
    public Product getProductById(Long prductid) {
        Optional<Product> product = productRepo.findProductById(prductid);
        if (product.isEmpty()) {
            return null;
        }
        return product.get();
    }

    @Override
    public List<Product> getProductsAll() {
        List<Product> products = productRepo.findAll();
        if (products.isEmpty()) {
            return Collections.emptyList();
        }
        return products;
    }

    @Override
    public Product saveProduct(Product product) {
        Product prdoduct = productRepo.save(product);
        return product;
    }

    @Override
    public Product saveUser(Product product) {
        return null;
    }

   /* @Override
    public Product replaceProductById(Long id, Product product) {

        return null;
    } */


}

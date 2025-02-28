package org.example.ecommerceclothapp2k25.services;
import org.example.ecommerceclothapp2k25.models.Product;
import org.example.ecommerceclothapp2k25.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Primary
@Service //service act as business logic and to specify whih bean to choose when mult beans exist with same type
public class StorageProductService implements IProductService {

    @Autowired
     private ProductRepo productRepo;

   public String sendProduct(Product prod)
   {
       productRepo.save(prod);
       return "Awesome Teju, Product updated in DB Successfully";
   }

   public Product getProductById(int id)
   {
       return productRepo.findById(id).orElse(new Product());
   }

   public List<Product> getProducts() {
       return productRepo.findAll();
   }

    @Override
    public void putProduct(int id,Product prod) {

       Optional<Product> p=productRepo.findById(id);
       if(p.isPresent())
       {
           Product actualpro=p.get();
           actualpro.setName(prod.getName());
           actualpro.setDescription(prod.getDescription());
           actualpro.setPrice(prod.getPrice());
           productRepo.save(actualpro);
       }
       else {
           throw new RuntimeException("Product not found");
       }
    }

    public void deleteProductById(int id) {
       productRepo.deleteById(id);
    }

    public void deleteAllProducts(List<Integer> ids) {
       productRepo.deleteAllById(ids);
    }

    public List<Product> sendAllProducts(List<Product> prods) {
       return productRepo.saveAll(prods);
    }


}

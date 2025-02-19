package org.example.ecommerceclothapp2k25.repository;

import org.example.ecommerceclothapp2k25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//prdrepo has custom repo for prdct table to access all functions from jpa extends of hibernate in orm concept
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long Long);//implementtation present on hibernate we are using b jpa interface extendscrud,list crud,sorting and oagingrepository has extra functions crud rep is top desndeant repos interface basic funct

    List<Product> findAll();

    Product save(Product product);

    //List<Product> searchAllPrdctsByName(String query,int pagnumber,int pagesize);

    //List<Product> findProductsByOrderByPrice();

   // @Query("select t from tbproduct t where t.id = ?1") using working
    //@QueryAnnotation("SELECT p.name FROM Product p WHERE p.id = ?1")
   // String findProductTitleById(@Param("1") Long id);

}

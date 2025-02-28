package org.example.ecommerceclothapp2k25.repository;

import org.example.ecommerceclothapp2k25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//prdrepo has custom repo for prdct table to access all functions from jpa extends of hibernate in orm concept
public interface ProductRepo extends JpaRepository<Product, Integer> {



}

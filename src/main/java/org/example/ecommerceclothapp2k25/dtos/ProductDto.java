package org.example.ecommerceclothapp2k25.dtos;

import java.util.Date;

 //lombok internal gene setter/getters for this entity by adding lombok dependency
public class ProductDto {
    //dto-->data trasnfer object we are not exposng entire entity instead of only specified fields
    public Long id;
    public String name;
    public String description;
    public Double price;

}

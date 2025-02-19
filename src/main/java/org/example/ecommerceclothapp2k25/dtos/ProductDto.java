package org.example.ecommerceclothapp2k25.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.ecommerceclothapp2k25.models.BaseModel;

import java.util.Date;

 //lombok internal gene setter/getters for this entity by adding lombok dependency
public class ProductDto extends BaseModel {
    //dto-->data trasnfer object we are not exposng entire entity instead of only specified fields
    public Long id;
    public String name;
    public String description;
    public Double price;
    public CategoryDto cat;
    public String image;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public Double getPrice() {
         return price;
     }

     public void setPrice(Double price) {
         this.price = price;
     }

     public CategoryDto getCat() {
         return cat;
     }

     public void setCat(CategoryDto cat) {
         this.cat = cat;
     }

     public String getImage() {
         return image;
     }

     public void setImage(String image) {
         this.image = image;
     }

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryDto(CategoryDto cat) {
    }

    public void setCreated_at(Date date) {
    }
    public void setName(Date date) {
    }
}

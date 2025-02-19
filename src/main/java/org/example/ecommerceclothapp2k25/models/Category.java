package org.example.ecommerceclothapp2k25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="category")
    public class Category extends  BaseModel{
        private String name;
        private String description;
        @OneToMany(mappedBy="category") //cardinality bet prd and cate we explicitly mention field name  ,telling to jpa don't create relationship create twice times
        private List<Product> prd;

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

    public List<Product> getPrd() {
        return prd;
    }

    public void setPrd(List<Product> prd) {
        this.prd = prd;
    }
}


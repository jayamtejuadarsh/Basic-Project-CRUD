package org.example.ecommerceclothapp2k25.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.ecommerceclothapp2k25.models.BaseModel;

public class CategoryDto extends BaseModel {
        private  Long id;

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

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        private String name;
        private String description;

}

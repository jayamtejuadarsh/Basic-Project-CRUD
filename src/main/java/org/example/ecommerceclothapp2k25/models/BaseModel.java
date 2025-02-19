package org.example.ecommerceclothapp2k25.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
//base model for all services and its abstract
@Setter
@Getter
@MappedSuperclass
//means it will not create table for basemodel class rather than it will allow thses fileds to create in another tables
public abstract class BaseModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id;
    private Date created_at;
    private Date modified_at;
    private State state;

}

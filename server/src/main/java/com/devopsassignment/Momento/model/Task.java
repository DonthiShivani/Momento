package com.devopsassignment.Momento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    private long id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Task{" +
                "id"+":" + id +
                ", \n name'" + name + '\'' +
                ", \n description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public void setId(Long id2) {
        this.id = id2;
    }

    public Long getId() {
        return id;
    }
}

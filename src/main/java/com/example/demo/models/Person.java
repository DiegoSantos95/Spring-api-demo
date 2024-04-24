package com.example.demo.models;

import jakarta.validation.constraints.NotNull;

public class Person {
    private int id;

    @NotNull(message = "missing name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

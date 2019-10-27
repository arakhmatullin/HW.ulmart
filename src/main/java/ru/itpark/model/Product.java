package ru.itpark.model;

import ru.itpark.ru.itpark.repository.ProductStoreElement;

public class Product implements ProductStoreElement {
    private int id;
    private String name;
    private String description;
    private int price;
    private String category;
    private int rating;

    public Product(String name, String description, int price, String category, int rating) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){

        return this.getName()+"\n"+
                this.getCategory()+"\n"+
                this.getPrice()+"\n"+
                this.getRating()+"\n";
    }
}

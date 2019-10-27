package ru.itpark.model;


public class MouseProduct extends Product {
    private String color;
    private String connectionType;

    public MouseProduct(String name, String description, int price, int rating, String color, String connectionType) {
        super(name, description, price, "МЫШЬ", rating);
        this.color = color;
        this.connectionType = connectionType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
}

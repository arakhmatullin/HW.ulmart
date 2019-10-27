package ru.itpark.model;

public class ChargerProduct extends Product {
    private String chargerType;

    public ChargerProduct(String name, String description, int price, int rating, String chargerType) {
        super(name, description, price, "ЗАРЯДНОЕ УСТРОЙСТВО", rating);
        this.chargerType = chargerType;
    }


}

package ru.itpark.model;

public class ScrewdriverProduct extends Product{
    private int voltageInMv;
    private String batteryType;

    public ScrewdriverProduct(String name, String description, int price, int rating, int voltageInMv, String batteryType) {
        super(name, description, price, "ИНСТРУМЕНТ", rating);
        this.voltageInMv = voltageInMv;
        this.batteryType = batteryType;
    }

    public int getVoltageInMv() {
        return voltageInMv;
    }

    public void setVoltageInMv(int voltageInMv) {
        this.voltageInMv = voltageInMv;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
}

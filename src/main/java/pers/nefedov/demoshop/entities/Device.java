package pers.nefedov.demoshop.entities;

public abstract class Device {
    long serialNumber;
    String manufacturer;
    double price;
    int quantity;

    public Device(long serialNumber, String manufacturer, double price, int quantity) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    public Device() {
    }

}

package ru.netology.homework;

public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean matches(String search) {
        return super.matches(search) || getManufacturer().equalsIgnoreCase(search);
//        if (super.matches(search)) {
//            return true;
//        }
//        if (search.matches(getManufacturer())) {
//            return true;
//        } else {
//            return false;
//        }
    }

}

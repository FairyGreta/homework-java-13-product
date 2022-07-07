package ru.netology.homework;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product() {

    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean matches(String search) {
        return name.equalsIgnoreCase(search);
//        if (search.matches(name)) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
package ru.netology.homework;

public class Book extends Product {
    public String author;

    public Book() {

    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || getAuthor().equalsIgnoreCase(search);
        // если правая часть выражения вернула false, то вычисляется левая часть
        //левая часть - поиск по автору, игнорируя
//        if (super.matches(search)) {
//            return true;
//        }
//        if (search.matches(getAuthor())) {
//            return true;
//        } else {
//            return false;
//        }
    }
}

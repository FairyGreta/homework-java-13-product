package ru.netology.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "Джентельмены и игроки", 1080, "Джоан Харрис");
    Product book2 = new Book(2, "Руководство по коксованию", 2500, "О. Гросскинский");
    Product book3 = new Book(3, "Сказки", 500, "А.С. Пушкин");
    Product book4 = new Book(6, "Сказки", 600, "Г.Х. Андерсен");
    Product smartphone1 = new Smartphone(4, "Samsung A52", 25000, "Samsung Group");
    Product smartphone2 = new Smartphone(5, "Nokia 8", 18000, "Nokia Corporation");

    @BeforeEach
    public void shouldSetAll() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("А.С. Пушкин");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Руководство по коксованию");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindManufacturerSmartphone() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung Group");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameSmartphone() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung A52");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindDifferentItemsByName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Сказки" + "Samsung A52");

        assertArrayEquals(expected, actual);
    }

    //находится 0 товаров, т.е. ни один товар не подходит.
    @Test
    public void shouldSearchNoProduct() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Игра");

        assertArrayEquals(expected, actual);
    }

    //находится несколько товаров
    @Test
    public void shouldSearchMultipleProducts () {
        Product[] expected = {book3, book4};
        Product[] actual = manager.searchBy("Сказки");

        assertArrayEquals(expected, actual);

    }

}

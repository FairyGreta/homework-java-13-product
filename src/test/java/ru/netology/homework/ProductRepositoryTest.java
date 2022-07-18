package ru.netology.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.junit.StrictStubsRunnerTestListener;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Джентельмены и игроки", 1080, "Джоан Харрис");
    Product book2 = new Book(2, "Руководство по коксованию", 2500, "О. Гросскинский");
    Product book3 = new Book(3, "Сказки", 500, "А.С. Пушкин");
    Product smartphone1 = new Smartphone(4, "Samsung A52", 25000, "Samsung Group");
    Product smartphone2 = new Smartphone(5, "Nokia 8", 18000, "Nokia Corporation");

    // тест на несуществующий id. Основная задача 14
    @Test
    public void shouldCheckExceptionNotExistingElement() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }

    // Тест на существующий ID. К основной задаче 14
    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.removeById(book2.getId());

        Product[] expected = {book1, book3, smartphone1, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldSetId() {
        Product phone = new Smartphone();

        phone.setId(6);

        int expected = 6;
        int actual = phone.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetName() {
        Product phone = new Smartphone();

        phone.setName("iPhone");

        String expected = "iPhone";
        String actual = phone.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrice() {
        Product phone = new Smartphone();

        phone.setPrice(100_000);

        int expected = 100_000;
        int actual = phone.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetManufacturer() {
        Smartphone phone = new Smartphone();

        phone.setManufacturer ("Apple");

        String expected = "Apple";
        String actual = phone.getManufacturer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetAuthor() {
        Book book = new Book();

        book.setAuthor ("В. Пелевин");

        String expected = "В. Пелевин";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }
}

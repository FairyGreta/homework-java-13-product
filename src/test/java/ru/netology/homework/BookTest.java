package ru.netology.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    Book book = new Book(7, "Основы Java", 1500, "Николай Прохоренок");

    @Test
    public void shouldFindByAuthorTrue() {
        boolean actual = book.matches("Николай Прохоренок");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindByAuthorFalse() {
        boolean actual = book.matches("Н. Прохоренок");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindByName() {
        boolean actual = book.matches("Основы Java");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindByNameFalse() {
        boolean actual = book.matches("Н. Прохоренок");

        Assertions.assertFalse(actual);
    }
}

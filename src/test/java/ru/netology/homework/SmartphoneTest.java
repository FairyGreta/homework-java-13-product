package ru.netology.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartphoneTest {

    Smartphone phone = new Smartphone(9, "iPhone", 100_000, "Apple");

    @Test
    public void shouldFindByManufacturerTrue() {
        boolean actual = phone.matches("Apple");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindByManufacturerFalse() {
        boolean actual = phone.matches("Asus");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindByName() {
        boolean actual = phone.matches("iPhone");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindByNameFalse() {
        boolean actual = phone.matches("iPad");

        Assertions.assertFalse(actual);
    }
}

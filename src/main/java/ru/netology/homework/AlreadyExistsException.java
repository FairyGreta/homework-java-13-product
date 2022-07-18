package ru.netology.homework;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException (String s) {
        super(s);
    }
}

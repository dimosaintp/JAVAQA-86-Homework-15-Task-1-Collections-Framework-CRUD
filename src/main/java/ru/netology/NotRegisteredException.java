package ru.netology;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("The player named " + name + " is not registered");
    }
}
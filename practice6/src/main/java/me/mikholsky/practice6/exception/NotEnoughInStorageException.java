package me.mikholsky.practice6.exception;

public class NotEnoughInStorageException extends Exception {
    public NotEnoughInStorageException(String message) {
        super(message);
    }
}

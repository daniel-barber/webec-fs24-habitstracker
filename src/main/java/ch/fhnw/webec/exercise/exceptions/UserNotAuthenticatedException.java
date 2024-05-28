package ch.fhnw.webec.exercise.exceptions;

public class UserNotAuthenticatedException extends RuntimeException{
    public UserNotAuthenticatedException(String message){
        super(message);
    }
}

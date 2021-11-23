package Exceptions;

public class InvalidCharacterException extends Exception{

    public InvalidCharacterException(String message){
        super(message);
        System.out.println(message);
    }
}

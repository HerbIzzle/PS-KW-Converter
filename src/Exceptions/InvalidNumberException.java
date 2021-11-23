public class InvalidNumberException extends Exception{

    public InvalidNumberException(String message) {
        super(message);
        System.out.println(message);
    }
}

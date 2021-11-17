public class TestException extends Exception{

    public TestException(String message) {
        super(message);
        System.out.println("Not a number");
    }
}

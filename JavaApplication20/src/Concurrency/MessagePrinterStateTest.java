package Concurrency;

/**
 *
 * @author seunghyekim
 */
public class MessagePrinterStateTest {
    public static void main(String[] args) {
        Thread t = new MessagePrinter("Happy days are here again", 10);
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
    }
}

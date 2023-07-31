package Concurrency;

/**
 *
 * @author seunghyekim
 */
class MessagePrinterTest {
    public static void main(String[] args) {
        Thread t = new MessagePrinter("Happy days are here again 1", 5);
        Thread t2 = new MessagePrinter("Happy days are here again 2", 5);
        t.start();
        t2.start();
        try{
            t.join();
        } catch (InterruptedException e){}
        System.out.println("All messages are printed");
    }
}

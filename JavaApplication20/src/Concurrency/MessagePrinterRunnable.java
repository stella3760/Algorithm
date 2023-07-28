package Concurrency;

/**
 *
 * @author seunghyekim
 */
public class MessagePrinterRunnable implements Runnable {
    private String message; 
    private int n;
    
    MessagePrinterRunnable(String m, int p){
        message = m; 
        n = p;
    }
    public void run(){
        int k = 0;
        while (k < n) {
            System.out.println(message);
            k++;
        }
    }
}


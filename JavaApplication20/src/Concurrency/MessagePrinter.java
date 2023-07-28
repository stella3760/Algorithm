package Concurrency;

/**
 *
 * @author seunghyekim
 */
public class MessagePrinter extends Thread{
    private String message;
    private int n;
    MessagePrinter(String m, int p){
        message = m; n = p;
    }
    public void run(){
        for(int k = 0; k < n; k++){
            System.out.println(message);
        }
    }
    public static void main(String args[]){
        MessagePrinter mp = new MessagePrinter("Good morning everyone", 10);
        mp.start();
    }
}

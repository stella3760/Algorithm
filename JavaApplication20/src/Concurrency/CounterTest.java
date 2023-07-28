package Concurrency;

/**
 *
 * @author seunghyekim
 */
public class CounterTest {
    public static void main(String[] args) {
        Thread counter_up = new Thread(new CountUp(100, 200));
        Thread counter_down = new Thread(new CountDown(100, 400));
        counter_up.start();
        counter_down.start();
        try { Thread.sleep(22000);
    } catch (InterruptedException e) { }
        if(counter_down.isAlive()){ counter_down.interrupt();}
    }
}

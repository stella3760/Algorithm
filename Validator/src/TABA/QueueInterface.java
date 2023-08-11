package TABA;

/**
 *
 * @author seunghyekim
 */
public interface QueueInterface<T> {
    
    public void enqueue (T elem);
    public T dequeue();
    public T peek();
    public String ToString();
    
}

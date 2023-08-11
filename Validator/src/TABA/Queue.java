package TABA;

/**
 *
 * @author seunghyekim
 */

import java.util.LinkedList;
        
public class Queue<T> implements QueueInterface<T>{
    
    LinkedList<T> theList;
    public Queue() {
        theList = new LinkedList<>(); 
        
    }
    
}

package TABA;

/** @author seunghyekim */
public class Node {
    
    private Object element;
    private Node next;
    
    public Node(Object e, Node n) {
        this.element = e;
        this.next = n;
    }
    
    public Object getElement () {
        return element;
    }
    
    public void setElement (Object e) {
        this.element = e;
    }
    
    public Node getNext () {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    // @Override
    public String ToString() {
        return element.toString();
    }
    
}

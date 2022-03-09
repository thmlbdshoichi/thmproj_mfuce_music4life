package Music4LifebyThM;

//@author Shoichi
//NODE V2.0 IMPROVED!

public class Node {
    
    private String element;
    private Node prev;
    private Node next;
    
    public Node(String data)
    {
        element = data;
        prev = null;
        next = null;
    }

    public void linkPrev(Node newNode)
    {
        prev = newNode;
    }
    public void linkNext(Node newNode)
    {
        next = newNode;
    }
    public Node getPrevNode()
    {
        return prev;  
    }
    public Node getNextNode()
    {
        return next;
    }
    public String getElement()
    {
        return element;
    }
}

package Music4LifebyThM;
//@author Shoichi | DLL IMPROVE 2.0

public class DLL 
{
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    
    public DLL()
    {
        //build an empty link list
        head = new Node("[Head]--> ");
        tail = new Node(" <--[tail]");
        head.linkNext(tail);
        tail.linkPrev(head);     
    }
    
    public void addFirst(String data)
    {
        //create new node
        Node newNode = new Node (data);
        newNode.linkPrev(head);
        newNode.linkNext(head.getNextNode());
        head.getNextNode().linkPrev(newNode);
        head.linkNext(newNode);
        size++;
    }
    
    public void addLast(String data){
        Node newNode = new Node(data);
        newNode.linkNext(tail);
        newNode.linkPrev(tail.getPrevNode());
        tail.getPrevNode().linkNext(newNode);
        tail.linkPrev(newNode);
        size++;
    }

    public void removeFirst()
    {
        //if(size==0) do nothing
        if(size==1)
        {
            head.linkNext(tail);
            tail.linkPrev(head);
            size--;
        }
        else if (size>1)
        {
            head.linkNext(head.getNextNode().getNextNode());
            head.getNextNode().linkPrev(head);
            size--;
        }
    }
    
    public void removeLast()
    {
        //if(size==0) do nothing
        if(size==1)
        {
            head.linkNext(tail);
            tail.linkPrev(head);
            size--;
        }
        else if (size>1)
        {
            tail.linkPrev(tail.getPrevNode().getPrevNode());
            tail.getPrevNode().linkNext(tail);
            size--;
        }
    }
    
    public String iterateForward()
    {
        String str = "";
        Node tmp = head;
        while(tmp != null)
        {
            str = str.concat((tmp.getElement()+", "));
            tmp = tmp.getNextNode();
        }
        return str;
    }
    
    public String iterateBackward()
    {
        String str = "";
        Node tmp = tail;
        while(tmp != null)
        {
            str = str.concat((tmp.getElement()+", "));
            tmp = tmp.getPrevNode();
        }
        return str;
    }
    
    public String getElementByIndex(int index)
    {
        //node that index start with 0 to size -1
        String element = "NONE";
        if((size > 0) && (index <= size))
        {
            Node p = head;
            for (int i=0; i<index; i++)
            {
                p = p.getNextNode();
            }
            element = p.getElement();
        }
        return element;
    }
    
    public int getSize()
    {
        return size;
    }
 
            
}

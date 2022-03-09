package Music4LifebyThM;
//Shoichi | Queue Improve 2.0
public class QueueArray {
    
    private final int CAPACITY = 5;
    String [] data;
    int front = 0;
    int size = 0;
    int capacity;
    
    public QueueArray()
    {
        data = new String[CAPACITY];
    }

    public String peek()
    {
        if (isEmpty())
        {
            return "Queue of the song is empty";
        }
        return data[front];
    }
    
    public void old_enqueue(String element)
    {
        if (size == data.length)
        {
            System.out.println("Queue is Full!");
        }
        else
        {
            // add new element at the rear
            int rear = (front+size) % data.length;
            data[rear] = element;
            size++;
            System.out.println("Inserting " + element);
            System.out.println("Queue size is : "+ getSize());
            System.out.println("Front Element : "+ peek());
            System.out.println("All List Queue : "+ printQueue());
        }
    }
    
    public void enqueue(String element) {
		if (size == data.length) {
			resize();
		}
		// add new element at the rear
		int tail = (front + size) % data.length;
		data[tail] = element;
		size++;
                System.out.println("Inserting : " + element);
                System.out.println("Queue size is : "+ getSize());
                System.out.println("Capacity is : "+ getCapacity());
                System.out.println("Front Element : "+ peek());
                System.out.println("All List Queue : "+ printQueue());
                System.out.println("");
	}
    
    public String dequeue()
    {
        if (isEmpty())
        {
            return "There is no song in Queue";
        }
        String element = data[front];
        front = (front + 1) % data.length;
        size--;
        return element;
    }
    
    public int getCapacity()
    {
        return data.length;
    }
    public int getSize()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return (getSize() == 0);
    }
    
    public String printQueue()
    {
        String queuelist = "";
        if (size == 0)
        {
            queuelist = "Queue is empty!";
        }
        else
        {
            for (int i = front; i < (front + size); i++)
            {
                queuelist = queuelist.concat(data[i % data.length] + " -> ");
            }
        }
        return queuelist;
    }
    
    public void resize() {
		// create a temp array of double size
		String[] temp = new String[data.length * 2];
		// copy old array and rearrange to the new array
		int indexNew = 0;
		int indexOld = front;
		for (int i = 0; i < size; i++) {
			temp[indexNew] = data[indexOld];
			indexOld = (indexOld + 1) % data.length;
			indexNew++;
		}
		// assign data to new array
		data = temp;
		front = 0;
	}

    
    public static void main (String[] args)
    {
        QueueArray CQ = new QueueArray();
        CQ.enqueue("Love so sweet");
        CQ.enqueue("Level 10");
        CQ.enqueue("Just be friends");
        CQ.enqueue("Hunter x Hunter");
        CQ.enqueue("Nine one one");
        CQ.enqueue("Mather");

        
    }
    
}

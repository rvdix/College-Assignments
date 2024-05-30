/**
 * This class is used for the creation and operation of Object Queues.
 * @author Richard Stegman
 * @version 1.0
 */
public class ObjectQueue implements ObjectQueueInterface{
    private Object[] item;
    private int front;
    private int rear;
    private int count;

    /**
     * The constructor for the Object Queue class
     */
    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * Checks if a queue is empty.
     * @return true if queue has no items
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks if a queue is full.
     * @return true if queue is full
     */
    public boolean isFull() {
        return count == item.length;
    }

    /**
     * Clears the queue of all items.
     */
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**
     * Inserts an object in the rear of the queue.
     * @param o object for insertion
     */
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }

    /**
     * Removes the object at the front of the queue.
     * @return object in front of queue
     */
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }

    /**
     * Returns the object at the front without modifying.
     * @return  front object
     */
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }

    /**
     * Resizes the array based on if it's full.
     * @param size
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}


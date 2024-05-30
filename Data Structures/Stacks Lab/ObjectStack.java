// ObjectStack.java
/**
 * This class is used to create a stack of Objects with methods for manipulating the stack.
 * @author Richard Stegman
 * @version 1.0
 */
public class ObjectStack implements ObjectStackInterface {
    private Object[] item;
    private int top;

    /**
     * This creates a new ObjectStack object and sets the top the initial value
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }

    /**
     * This method returns whether or not the ObjectStack is empty
     * @return true if the ObjectStack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * This method checks whether or not the ObjectStack is full
     * @return true if ObjectStack is full
     */
    public boolean isFull() {
        return top == item.length - 1;
    }

    /**
     * This method clears the ObjectStack object
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }

    /**
     * This class pushes objects to the stack
     * @param o This represents the object going to be pushed on the stack
     */
    public void push(Object o) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = o;
    }

    /**
     * This method resizes the stack if it is too big or too small
     * @param size this represents the new size of the stack
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }

    /**
     * This method takes the object from the top and clears it from the stack
     * @return the object at the top of the stack
     */
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length / 4)
            resize(item.length / 2);
        return temp;
    }

    /**
     * This method takes the object from the top of the stack without modifying the stack
     * @return the object at the top of the stack
     */
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        return item[top];
    }
}

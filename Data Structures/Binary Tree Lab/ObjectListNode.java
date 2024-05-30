/**
 * This class creates nodes to be used in the ObjectList class
 * @author Richard Stegman
 * @version 1.0
 */
public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;

    /**
     * Default ctor
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One arg constructor
     * @param o object to be added
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }

    /**
     * two arg constructor
     * @param o object to be added
     * @param p node to be added
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }

    /**
     * sets the info filed
     * @param o object which is put into the info field
     */
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * Returns the object in the info field
     * @return object in the info field
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets the next field in the node
     * @param p the node to be set
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Gets the object from the next node
     * @return object from the info field
     */
    public ObjectListNode getNext() {
        return next;
    }
}
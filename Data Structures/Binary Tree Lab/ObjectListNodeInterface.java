/**
 * Interface for the ObjectListNode class
 * @author Richard Stegman
 * @version 1.0
 */
public interface ObjectListNodeInterface {
    // Sets info field
    void setInfo(Object o);

    // Returns object in info field
    Object getInfo();

    // Sets next field
    void setNext(ObjectListNode p);

    // Returns object in info field
    ObjectListNode getNext();
}

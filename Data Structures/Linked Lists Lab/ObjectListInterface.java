public interface ObjectListInterface {
    // Returns the first node in the list
    ObjectListNode getFirstNode();

    // Returns the last node in the list
    ObjectListNode getLastNode();

    // Returns the first object in the list
    Object getFirst();

    // Returns the last object in the list
    Object getLast();

    // Adds an object to the front of a list
    void addFirst(Object o);

    // Adds a node to the front of the list
    void addFirst(ObjectListNode p);

    // Adds an object to the end of the list
    void addLast(Object o);

    // Adds a node to the end of the list
    void addLast(ObjectListNode p);

    // Removes the first object from the list
    Object removeFirst();

    // Removes the last object from the list
    Object removeLast();

    // Inserts an object after the node referenced by p
    void insertAfter(ObjectListNode p, Object o);

    // Inserts a node after the node referenced by p
    void insertAfter(ObjectListNode p, ObjectListNode q);

    // Deletes the node after the node referenced by p
    Object deleteAfter(ObjectListNode p);

    // Inserts an item into its correct location within an ordered list
    void insert(Object o);

    // Inserts a node into its correct location within an ordered list
    void insert(ObjectListNode r);

    // Removes the first occurrence of an item in a list
    Object remove(Object o);

    // Returns true if the item is found in the list
    boolean contains(Object o);

    // Returns a reference to the node with the requested value
    // Returns null otherwise
    ObjectListNode select(Object o);

    // Determines whether or not a list is empty
    boolean isEmpty();

    // Removes all elements from a list
    void clear();

    // Returns the number of elements in the list
    int size();

    // Makes a copy of a list
    ObjectListInterface copyList();

    // Reverses a list
    void reverse();
}

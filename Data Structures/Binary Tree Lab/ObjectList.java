/**
 * The class which is used to create Object lists
 * @author Richard Stegman
 * @version 1.0
 */
public class ObjectList implements ObjectListInterface {
    private ObjectListNode list;
    private ObjectListNode last;

    /**
     *Constructs an empty list
     */
    public ObjectList() {
        list = null;
        last = null;
    }

    /**
     * Returns the first node in the list
     * @return first node
     */
    public ObjectListNode getFirstNode() {
        return list;
    }

    /**
     * Returns the last node in the list
     * @return  last node
     */
    public ObjectListNode getLastNode() {
        return last;
    }

    /**
     * Return the first object in the list
     * @return first object
     */
    public Object getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    /**
     * Return the last object in the list
     * @return last object
     */
    public Object getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    /**
     * Adds object to the front of the list
     * @param o object to be added
     */
    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list);
        if (list == null)
            last = p;
        list = p;
    }

    /**
     * Adds node to the front of the list
     * @param p node to be added
     */
    public void addFirst(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
    }

    /**
     * Adds object to the end of a list
     * @param o object to be added
     */
    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * Adds node to the end of the list
     * @param p node to be added
     */
    public void addLast(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * Removes first object in a list
     * @return the object in the front
     */
    public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        return p.getInfo();
    }

    /**
     * Removes the last object in a list
     * @return the last object
     */
    public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        }
        else {
            q.setNext(null);
            last = q;
        }
        return p.getInfo();
    }

    /**
     * Inserts an object after the node pointed to by p
     * @param p node to add object after
     * @param o object to be added
     */
    public void insertAfter(ObjectListNode p, Object o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    /**
     * Inserts a node after the node pointed to by p
     * @param p node to add node after
     * @param q node to be added
     */
    public void insertAfter(ObjectListNode p, ObjectListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = q;
    }

    /**
     * Deletes object after the node pointed to by p
     * @param p reference node
     * @return object pointed to after by p
     */
    public Object deleteAfter(ObjectListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = p;
        return q.getInfo();
    }

    /**
     * Inserts an object in the appropriate ordered location
     * @param o object to be inserted
     */
    public void insert(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    /**
     * Inserts a node in the appropriate ordered location
     * @param r node to be inserted
     */
    public void insert(ObjectListNode r) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null &&
                ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    /**
     * Removes the first instance of the object
     * @param o object to be removed
     * @return object removed
     */
    public Object remove(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
                0) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return null;
        else return q == null ? removeFirst() : deleteAfter(q);
    }

    /**
     * Returns true if the object is found in the list
     * @param o object to be found
     * @return true or false if object is found
     */
    public boolean contains(Object o) {
        ObjectListNode p = list;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
                0)
            p = p.getNext();
        return p != null;
    }


    /**
     * Returns a reference to the node with the requested value
     * Returns null otherwise
     * @param o object used for searching
     * @return reference to node which contains the object
     */
    public ObjectListNode select(Object o) {
        ObjectListNode p = list;
        while (p != null)
            if (((Comparable)o).compareTo(p.getInfo()) == 0)
                return p;
            else
                p = p.getNext();
        return null;
    }

    /**
     * Determines whether or not a list is empty
     * @return true/false if list is empty
     */
    public boolean isEmpty() {
        return list == null;
    }

    /**
     * Clears a list of all objects
     */
    public void clear() {
        list = null;
        last = null;
    }

    /**
     * Returns the size of the list
     * @return size of list
     */
    public int size() {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    /**
     * Makes a copy of the list
     * @return copy of list
     */
    public ObjectListInterface copyList() {
        ObjectListNode p = null;
        ObjectListNode q = null; // to satisfy compiler;
        ObjectListNode r = list;

        if (isEmpty())
            return null;
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode(r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p);
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }

    /**
     * Reverses a list
     */
    public void reverse() {
        ObjectListNode p = list;
        ObjectListNode q = null;
        ObjectListNode r;

        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }
}
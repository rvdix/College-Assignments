/**
 * This class creates nodes to be used in the construction of Binary Trees
 * @author Richard Stegman
 * @version 1.0
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;

    /**
     * Constructor for the ObjectTreeNode class
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }

    /**
     * Creates a node with the object being used as the info field
     * @param o object to be inserted into info field
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }

    /**
     * Sets the info field of the node
     * @param o object to be inserted
     */

    public void setInfo(Object o) {
        info = o;
    }

    /**
     * Gets the info from the info field of the node
     * @return object from info field
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets the left field of the node
     * @param p node to be set as left child
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }

    /**
     * Gets the left field of the node
     * @return left child node
     */
    public ObjectTreeNode getLeft() {
        return left;
    }

    /**
     * Sets the right field of the node
     * @param p node to be set as right child
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }

    /**
     * Gets the right field of the node
     * @return right child node
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}

